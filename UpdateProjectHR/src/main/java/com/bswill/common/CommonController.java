package com.bswill.common;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/*")
public class CommonController {

	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

	@Inject
	private CommonService cService;

	@Inject
	private PasswordEncoder pwEncoder;

	// 권한 없을 때
	@RequestMapping(value = "/accessError", method = RequestMethod.GET)
	public String accessDeniedGET(Authentication auth, Model model) throws Exception {
		logger.debug("CommonController - accessDeniedGET() 호출");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		int anonymous = authentication.getAuthorities().toString().indexOf("ROLE_ANONYMOUS");

		String path = "redirect:/loginBswill";

		if (authentication != null && anonymous == -1) {
			model.addAttribute("message", "Access Denied!");

			path = "/accessError";
		}

		return path;
	}

	// 로그인
	// http://localhost:8088/loginBswill
	@RequestMapping(value = "/loginBswill", method = RequestMethod.GET)
	public String loginbswillGET(String error, String logout, Model model) throws Exception {
		logger.debug("CommonController - loginbswillGET() 호출");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		int anonymous = authentication.getAuthorities().toString().indexOf("ROLE_ANONYMOUS");

		String path = "loginBswill";

		if (authentication != null && anonymous == -1) {
			path = "redirect:/main";
		}

		logger.debug("error:" + error);
		logger.debug("logout:" + logout);

		if (error != null) {
			model.addAttribute("error", "로그인 실패! 계정을 확인해주세요.");
		}

		if (logout != null) {
			model.addAttribute("logout", "로그아웃되었습니다.");
		}

		return path;
	}

	// 메인
	// http://localhost:8088/main
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainGET(Model model, HttpSession session) throws Exception {
		logger.debug("CommonController - mainGET() 호출");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		int anonymous = authentication.getAuthorities().toString().indexOf("ROLE_ANONYMOUS");

		String path = "redirect:/accessError";

		if (authentication != null && anonymous == -1) {
			int employee_id = Integer.parseInt(authentication.getName());

			session.setAttribute("getEmpInfo", cService.getEmpInfo(employee_id));
			model.addAttribute("getJobInfo", cService.getJobInfo());
			model.addAttribute("getDeptInfo", cService.getDeptInfo());
			model.addAttribute("getEmpCount", cService.getEmpCount());
			model.addAttribute("getCurrentEmpcount", cService.getCurrentEmpCount());
			model.addAttribute("getNewEmpCount", cService.getNewEmpCount());

			path = "/main";
		}

		return path;
	}

	// 비밀번호 변경
	// http://localhost:8088/changePassword
	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public String changePasswordGET(String error, Model model) throws Exception {
		logger.debug(" changePasswordGET() 호출 ");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		int anonymous = authentication.getAuthorities().toString().indexOf("ROLE_ANONYMOUS");

		String path = "redirect:/accessError";

		if (authentication != null && anonymous == -1) {
			if (error != null) {
				model.addAttribute("error", "비밀번호 변경 실패! 비밀번호를 확인해주세요.");
			}

			path = "/changePassword";
		}

		return path;
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public String changePasswordPOST(@RequestParam("currentPassword") String currentPassword,
			@RequestParam("newPassword") String newPassword, @RequestParam("confirmPassword") String confirmPassword)
			throws Exception {
		logger.debug(" changePasswordPOST() 호출 ");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		int employee_id = Integer.parseInt(authentication.getName());

		String password = cService.getPassword(employee_id);

		String path = "";

		if (pwEncoder.matches(currentPassword, password) && newPassword.equals(confirmPassword)) {
			cService.modifyPassword(employee_id, pwEncoder.encode(newPassword));

			path = "redirect:/main";
		} else {
			path = "redirect:/changePassword?error=1";
		}

		return path;
	}

}
