package mvc.controller;

import mvc.controller.view.BusinessPlan;
import mvc.dao.DataDao;
import mvc.dto.DataRequest;
import mvc.dto.DataResponce;
import mvc.model.Data;
import mvc.service.DataService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * User: Andrey Popov
 * Date: 20.12.10
 * Time: 11:20
 */
@Controller
public class DataController {
    @Autowired
    private DataService dataService;

    @Autowired
    private DataDao dataDao;

    @RequestMapping(value = "/data/{article}", method = RequestMethod.GET)
//    @ResponseBody
    public DataResponce getData(@PathVariable String article) {
        DataRequest dataRequest = new DataRequest();
        dataRequest.setRequestType(0);
        dataRequest.setArticle(article);
//        dataRequest.setArticle("N00104079026");
        DataResponce dataResponce = dataService.getDataResponce(dataRequest);
        return dataResponce;
    }

    @RequestMapping(value = "/file", method = RequestMethod.GET)
//    @ResponseBody
    public File getFile() throws IOException {
        return new File("C://qqq.csv");
    }

    @RequestMapping(value = "/excel", method = RequestMethod.GET)
//    @ResponseBody
    public List<Data> getExcel() throws Exception {
//        BusinessPlan businessPlan = new BusinessPlan();
//        return (HSSFWorkbook) businessPlan.getWorkbook();
        return dataDao.getDataByArticle("N00104079026");
    }

}
