package com.bswill.employee;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employee/*")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Inject
	private EmployeeService empService;

	// http://localhost:8088/employee/getEmpInfo
	@RequestMapping(value = "/getEmpInfo", method = RequestMethod.GET)
	public String getEmpInfoGET(Model model) throws Exception {
		logger.debug("getEmpInfoGET() 호출");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		String path = "";

		if (authentication != null && authentication.isAuthenticated()) {
			int employee_id = Integer.parseInt(authentication.getName());

			// logger.debug("getEmpInfo: " + eService.viewEmp(employee_id));
			// logger.debug("viewEmpLicenseVO: " + lService.viewEmpLicense(employee_id));
			// logger.debug("viewEmpAppointmentVO: " + aService.viewEmpAppointment(employee_id));

			model.addAttribute("getEmpInfo", empService.getEmpInfo(employee_id));
			model.addAttribute("getEmpLicense", empService.getEmpLicense(employee_id));
			model.addAttribute("getEmpAppointment", empService.getEmpAppointment(employee_id));

			path = "/employee/getEmpInfo";
		} else {
			path = "redirect:/accessError";
		}

		return path;
	}

	// http://localhost:8088/employee/registEmpGET
	@RequestMapping(value = "/registEmp", method = RequestMethod.GET)
	public void registEmpGET(Model model) throws Exception {
		logger.debug("registEmpGET() 호출");
	}

}
