package controller;

import factories.FactoryDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import processing.*;

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
    FactoryDao fd = FactoryDao.getInstance();

    @RequestMapping(value = "/process.html", method = RequestMethod.POST)
    @ResponseBody
    public String setProcess(@RequestParam("processId") int processId,
                             @RequestParam("picPath") String picPath,
                             @RequestParam("useProxy") boolean useProxy,
                             @RequestParam("ip") String ip,
                             @RequestParam("port") int port) {
        if (processId == 1 || processId == 2) {
            Nix nix = new Nix(processId, picPath, useProxy, ip, port);
            nix.run();
            return "Done!";
        } else if (processId == 3 || processId == 4) {
            Fcenter fc = new Fcenter(processId, picPath, useProxy, ip, port);
            fc.run();
            return "Done!";
        } else {
            Orion orion = new Orion(processId, picPath, useProxy, ip, port);
            orion.run();
            return "Done!";
        }
    }

    @RequestMapping(value = "/status.html", method = RequestMethod.POST)
    @ResponseBody
    public String getStatus(@RequestParam("processId") int processId) {
        return fd.getProcessDao().getProcessStatusById(processId);
    }


    @RequestMapping("/csv.html")
    public ModelAndView getCsvByShop(HttpSession httpSession,
                                     @RequestParam("shopId") int shopId) {
        FcenterProcessing fcenter = new FcenterProcessing();
        Map<String, Object> model = new HashMap<String, Object>();

        CsvView csvView = new CsvView(fcenter.getFcenterDescriptionInCsv(shopId).getAbsolutePath(), shopId);

        return new ModelAndView(csvView, model);
    }
}
