package com.bswill.employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/employee/*")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	// http://localhost:8088/employee/regist
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public void registGET(Model model) throws Exception {
		logger.debug("registGET() 호출");
	}

}
