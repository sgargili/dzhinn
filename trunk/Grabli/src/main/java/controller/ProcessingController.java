package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pojo.FcenterProduct;
import pojo.Shop;
import processing.FcenterProcessing;
import processing.NixProcessing;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 10.11.2010
 * Time: 15:00:30
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ProcessingController {
    private NixProcessing nix = new NixProcessing();
    private FcenterProcessing fcenter = new FcenterProcessing();

    @RequestMapping(value = "/process.html", method = RequestMethod.POST)
    @ResponseBody
    public String setProcess(@RequestParam("process") String process,
                             @RequestParam("useProxy") boolean useProxy,
                             @RequestParam("proxyIp") String proxyIp,
                             @RequestParam("proxyPort") String proxyPort) {
//        List<FcenterProduct> products = fcenter.getProductsLinks();
//        for (FcenterProduct fp : products) {
//            fcenter.getDescription(fp);
//        }
        return process + " - " + useProxy + " - " + proxyIp + " - " + proxyPort;
    }

    @RequestMapping(value = "/status.html", method = RequestMethod.POST)
    @ResponseBody
    public String getStatus(@RequestParam("process") String process) {
        return process;
    }


    @RequestMapping("/csv.html")
    public ModelAndView getCsvByShop(HttpSession httpSession,
                                     @RequestParam("shopId") String shopId) {
        FcenterProcessing fcenter = new FcenterProcessing();

        Map<String, Object> model = new HashMap<String, Object>();

        CsvView csvView = new CsvView(fcenter.getFcenterDescriptionInCsv().getAbsolutePath(), shopId);

        return new ModelAndView(csvView, model);
    }
}
