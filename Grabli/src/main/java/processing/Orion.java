package processing;

import factories.FactoryDao;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 16.11.2010
 * Time: 15:43:34
 * To change this template use File | Settings | File Templates.
 */
public class Orion extends Thread {
    private int processId;
    private String picPath;
    private boolean useProxy = true;
    private String ip = "127.0.0.1";
    private int port = 8118;


    public Orion(int processId, String picPath, boolean useProxy, String ip, int port) {
        this.processId = processId;
        this.picPath = picPath;
        this.useProxy = useProxy;
        this.ip = ip;
        this.port = port;
    }

    private OrionProcessing orionPro = new OrionProcessing(useProxy, ip, port);
    private FactoryDao fd = FactoryDao.getInstance();

    @Override
    public void run() {

        fd.getProcessDao().updateProcessStatusById("On", processId);

        if (processId == 5) {
            orionPro.startGrabbing();
            fd.getProcessDao().updateProcessStatusById("Off", processId);
        } else if (processId == 6) {
            List<String> articles = fd.getInputDataDao().getAllArticlesByShop(3);

            for (String article : articles) {
                orionPro.downloadPics(article, picPath);
            }
            fd.getProcessDao().updateProcessStatusById("Off", processId);
        }
    }
}
