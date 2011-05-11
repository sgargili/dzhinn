package com.sitronics.voa.backend;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sitronics.voa.core.dto.PaymentDto;
import com.sitronics.voa.core.dto.pages.PaymentPage;
import com.sitronics.voa.core.service.PaymentService;

@Controller
public class PaymentController {

	private PaymentService paymentService;

	@Autowired
	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@RequestMapping(value = "/addPayment", method = RequestMethod.POST)
	@ResponseBody
	public Long addPayment(@RequestBody PaymentDto payment) {
		return paymentService.insert(payment).getMemberId();
	}

	@InitBinder
	public void initDataBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "/pays", method = RequestMethod.GET)
	@ResponseBody
	public PaymentPage getPaysByDate(@RequestParam("firstRow") Long firstRow, @RequestParam("listSize") Integer listSize,
		@RequestParam("sortColumn") String sortColumn, @RequestParam("sortOrder") String sortOrder, @RequestParam("date") Date date) {
        if (date != null){
		    Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    return paymentService.getPaymentsPage(firstRow, listSize, sortColumn, sortOrder, calendar);
        } else {
            return paymentService.getPaymentsPage(firstRow, listSize, sortColumn, sortOrder);
        }
	}
}
