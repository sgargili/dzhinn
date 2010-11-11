package processing;

import factories.FactoryDao;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 11.11.2010
 * Time: 14:27:51
 * To change this template use File | Settings | File Templates.
 */
public class Nix extends Thread {
    private int processId;
    private String picPath;
    private boolean useProxy = true;
    private String ip = "127.0.0.1";
    private int port = 8118;

    public Nix(int processId) {
        this.processId = processId;
    }

    public Nix(int processId, String picPath) {
        this.processId = processId;
        this.picPath = picPath;
    }

    public Nix(int processId, String picPath, boolean useProxy, String ip, int port) {
        this.processId = processId;
        this.picPath = picPath;
        this.useProxy = useProxy;
        this.ip = ip;
        this.port = port;
    }

    private NixProcessing nixPro = new NixProcessing();
    private FactoryDao fd = FactoryDao.getInstance();

    @Override
    public void run() {

        fd.getProcessDao().updateProcessStatusById("On", processId);

        if (processId == 1) {
            Map<Integer, String> products;

            Set<Integer> articles;

            Map<String, String> pts = nixPro.getNixDepartments("http://www.nix.ru/price/price.html", useProxy, ip, port);

            Set<String> deps = pts.keySet();

            for (String depUrl : deps) {
                products = nixPro.getLink4AllProductLinksByUrl("http://www.nix.ru/price/" + depUrl, useProxy, ip, port);
                articles = products.keySet();
                for (int article : articles) {
                    nixPro.getProductDescFromNixHTML(article + "", pts.get(depUrl), "Nix.ru", "http://www.nix.ru" + products.get(article), useProxy, ip + ":" + port);
                }
            }
            fd.getProcessDao().updateProcessStatusById("Off", processId);
        } else if (processId == 2) {

            List<String> articles = fd.getInputDataDao().getAllArticlesByShop(1);

            for (String article : articles) {
                nixPro.downloadPics(article, picPath, useProxy, ip, port);
            }
            fd.getProcessDao().updateProcessStatusById("Off", processId);
        }
    }
}