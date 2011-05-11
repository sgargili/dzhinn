package com.sitronics.voa.backend;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PdfController {

    @RequestMapping("/order.html")
    public ModelAndView getPaymentBill(HttpSession httpSession) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("reportFile", "main_bill.jasper");
        PdfView pdfView = new PdfView();
        return new ModelAndView(pdfView, model);
    }
}