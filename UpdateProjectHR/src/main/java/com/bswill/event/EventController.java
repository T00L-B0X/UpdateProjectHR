package com.bswill.event;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bswill.domain.Criteria;
import com.bswill.domain.EventVO;
import com.bswill.domain.PageCri;

@Controller
@RequestMapping("/event/*")
public class EventController {

	private static final Logger logger = LoggerFactory.getLogger(EventController.class);

	@Inject
	private EventService eveService;

	// http://localhost:8088/event/applyEvent
	@RequestMapping(value = "/applyEvent", method = RequestMethod.GET)
	public String applyEventGET(Model model) throws Exception {
		logger.debug("EventController - applyEventGET() 호출");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		int anonymous = authentication.getAuthorities().toString().indexOf("ROLE_ANONYMOUS");

		String path = "redirect:/loginBswill";

		if (authentication != null && anonymous == -1) {
			model.addAttribute("employee_id", Integer.parseInt(authentication.getName()));

			path = "/event/applyEvent";
		}

		return path;
	}

	@RequestMapping(value = "/applyEvent", method = RequestMethod.POST)
	public String applyEventPOST(EventVO evo) throws Exception {
		logger.debug("EventController - applyEventPOST() 호출");

		logger.debug("evo: " + evo);

		eveService.applyEvent(evo);

		return "redirect:/event/getEmpEvent";
	}

	// http://localhost:8088/emp/getEmpEvent
	@RequestMapping(value = "/getEmpEvent", method = RequestMethod.GET)
	public void getEmpEventGET(Criteria cri, Model model) throws Exception {
		logger.debug("EventController - getEmpEventGET() 호출");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		int anonymous = authentication.getAuthorities().toString().indexOf("ROLE_ANONYMOUS");

		String path = "redirect:/loginBswill";

		if (authentication != null && anonymous == -1) {
			int employee_id = Integer.parseInt(authentication.getName());

			if (cri.getSearch() == null) {
				cri.setSearch("eve_class");
			}

			if (cri.getSort() == null) {
				cri.setSort("req_date");
			}

			if (cri.getOrder() == null) {
				cri.setOrder("DESC");
			}

			cri.setEmployee_id(employee_id);
			logger.debug("cri.emp: " + cri.getEmployee_id());

			model.addAttribute("getEmpEvent", eveService.getEmpEvent(cri));
			model.addAttribute("pageCri", new PageCri(cri, eveService.countEmpEvent(cri)));
			model.addAttribute("cri", cri);

			path = "";
		}

	}

}
