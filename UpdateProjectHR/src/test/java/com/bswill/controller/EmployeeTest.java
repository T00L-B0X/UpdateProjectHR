package com.bswill.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class EmployeeTest {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeTest.class);

	@Inject
	BCryptPasswordEncoder pwEncoder;

	@Test
	public void test() {
		logger.debug("make pw");

		String pass = pwEncoder.encode("00000000");

		logger.debug("pass: " + pass);
	}

}
