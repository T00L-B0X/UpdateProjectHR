package com.bswill.common;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/*")
public class CommonController {

	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

	@Inject
	private CommonService cService;

	@Inject
	private PasswordEncoder pwEncoder;

	// 권한 없을 때
	@RequestMapping(value = "/accesserror", method = RequestMethod.GET)
	public void accessDenied(Authentication auth, Model model) throws Exception {
		logger.debug("CommonController - accessDenied() 호출");

		model.addAttribute("message", "Access Denied!");
	}

	// 로그인
	@RequestMapping(value = "/loginbswill", method = RequestMethod.GET)
	public void loginbswill(String error, String logout, Model model) throws Exception {
		logger.debug("CommonController - loginInput() 호출");

		logger.debug("error:" + error);
		logger.debug("logout:" + logout);

		if (error != null) {
			model.addAttribute("error", "로그인 실패! 계정을 확인해주세요.");
		}

		if (logout != null) {
			model.addAttribute("logout", "로그아웃되었습니다.");
		}
	}

	// 로그아웃
	@RequestMapping(value = "/logoutbswill", method = RequestMethod.GET)
	public void loginbswill() throws Exception {
		logger.debug(" customLogout() 호출 ");
		logger.debug(" 로그아웃 ");
	}

	// 메인
	// http://localhost:8088/main
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void main(Model model) throws Exception {
		logger.debug("CommonController - main() 호출");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		int employee_id = Integer.parseInt(authentication.getName());

		model.addAttribute("PASSWD", cService.getPasswd(employee_id));
	}

	// 비밀번호 변경
	// http://localhost:8088/common/chagePw
	@RequestMapping(value = "/changePw", method = RequestMethod.GET)
	public void changePasswdGET() throws Exception {
		logger.debug(" changePasswdGET() 호출 ");
	}

}
