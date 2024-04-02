package com.bswill.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	private static final Logger logger = LoggerFactory.getLogger(CustomLoginSuccessHandler.class);

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		logger.warn("Login Success");

		List<String> roleNames = new ArrayList<>();

		auth.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		});

		logger.warn("ROLE NAMES: " + roleNames);

		String path = "";

		if (roleNames.contains("ROLE_ADMIN")) {
			logger.warn("관리자 아이디 로그인");

			path = "/main";
		}

		if (roleNames.contains("ROLE_MANAGER")) {
			logger.warn("매니저 아이디 로그인");

			path = "/main";
		}

		if (roleNames.contains("ROLE_MEMBER")) {
			logger.warn("사용자 아이디 로그인");

			path = "/main";
		}

		response.sendRedirect(path);
	}

}
