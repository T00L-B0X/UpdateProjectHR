package com.bswill.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/*")
public class CommonController {

	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

	// http://localhost:8088/main
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void main() {
		logger.debug("CommonController - main() 호출");
	}

}
