package processing;

import factories.FactoryDao;
import pojo.FcenterProduct;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 11.11.2010
 * Time: 15:03:50
 * To change this template use File | Settings | File Templates.
 */
public class Fcenter extends Thread {
    private int processId;
    private String picPath;
    private boolean useProxy = true;
    private String ip = "127.0.0.1";
    private int port = 8118;

    public Fcenter(int processId, String picPath, boolean useProxy, String ip, int port) {
        this.processId = processId;
        this.picPath = picPath;
        this.useProxy = useProxy;
        this.ip = ip;
        this.port = port;
    }

    private FcenterProcessing fcenterPro = new FcenterProcessing();
    private FactoryDao fd = FactoryDao.getInstance();

    @Override
    public void run() {

        fd.getProcessDao().updateProcessStatusById("On", processId);

        if (processId == 3) {
            List<FcenterProduct> list = fcenterPro.getProductsLinks(useProxy, ip, port);
            for (FcenterProduct pro : list) {
                fcenterPro.getDescription(pro, useProxy, ip, port);
            }
            fd.getProcessDao().updateProcessStatusById("Off", processId);
        } else if (processId == 4) {

            List<String> articles = fd.getInputDataDao().getAllArticlesByShop(2);

            for (String article : articles) {
                fcenterPro.downloadPics(article, picPath, useProxy, ip, port);
            }
            fd.getProcessDao().updateProcessStatusById("Off", processId);
        }
    }
}
