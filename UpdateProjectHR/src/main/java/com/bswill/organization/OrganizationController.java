package com.bswill.organization;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bswill.domain.Criteria;

@Controller
@RequestMapping("/organization/*")
public class OrganizationController {

	private static final Logger logger = LoggerFactory.getLogger(OrganizationController.class);

	@Inject
	private OrganizationService orgService;

	@RequestMapping(value = "/getOrgList", method = RequestMethod.GET)
	public String getOrgListGET(Criteria cri, Model model) throws Exception {
		logger.debug("OrginazationController - getOrgListGET() 호출");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		int anonymous = authentication.getAuthorities().toString().indexOf("ROLE_ANONYMOUS");

		String path = "redirect:/accessError";

		if (authentication != null && anonymous == -1) {
			int employee_id = Integer.parseInt(authentication.getName());

			if (cri.getSort() == null) {
				cri.setSort("employee_id");
			}

			if (cri.getOrder() == null) {
				cri.setOrder("ASC");
			}

			model.addAttribute("getOrgList", orgService.getOrgList(cri));
			model.addAttribute("getEmpFavors", orgService.getEmpFavors(employee_id));
			model.addAttribute("cri", cri);

			path = "/organization/getOrgList";
		}

		return path;
	}

	@RequestMapping(value = "/updateFavors", method = RequestMethod.POST)
	public String updateFavorsPOST(@RequestParam(name = "favors", required = false) String[] favors,
			@RequestParam(name = "orgFavor", required = false) String orgFavor) throws Exception {
		logger.debug("updateFavorsPOST() 호출");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		int employee_id = Integer.parseInt(authentication.getName());

		String FAVORS = "";

		if (favors != null) {
			for (String favor : favors) {
				FAVORS += favor + ",";
			}

			if (FAVORS.endsWith(",")) {
				FAVORS = FAVORS.substring(0, FAVORS.length() - 1);
			}

			logger.debug("FAVORS:" + FAVORS);
		}
		orgService.modifyFavors(employee_id, FAVORS);

		String path = "redirect:/organization/getOrgList";

		if (orgFavor != null) {
			path = "redirect:/organization/getOrgFavor";
		}

		return path;
	}

}
