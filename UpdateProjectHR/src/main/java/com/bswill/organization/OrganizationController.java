package com.bswill.organization;

import java.io.File;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
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

import com.bswill.domain.Criteria;

import net.coobird.thumbnailator.Thumbnails;

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

	@RequestMapping(value = "/getOrgFavorsList", method = RequestMethod.GET)
	public String getOrgFavorsListGET(Criteria cri, Model model) throws Exception {
		logger.debug("OrginazationController - getOrgFavorsListGET() 호출");

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

			logger.debug("get: " + orgService.getFavorsList(employee_id, cri));

			model.addAttribute("getEmpFavorsList", orgService.getFavorsList(employee_id, cri));
			model.addAttribute("getEmpFavors", orgService.getEmpFavors(employee_id));
			model.addAttribute("cri", cri);

			path = "/organization/getOrgFavorsList";
		}

		return path;
	}

	@RequestMapping(value = "/updateFavors", method = RequestMethod.POST)
	public String updateFavorsPOST(@RequestParam(name = "favors", required = false) String[] favors,
			@RequestParam(name = "orgFavor", required = false) String orgFavor) throws Exception {
		logger.debug("OrginazationController - updateFavorsPOST() 호출");

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
			path = "redirect:/organization/getOrgFavorsList";
		}

		return path;
	}

	@RequestMapping(value = "/getDeptList", method = RequestMethod.GET)
	public String getDeptListGET(Model model) throws Exception {
		logger.debug("OrginazationController - getDeptListGET() 호출");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		int anonymous = authentication.getAuthorities().toString().indexOf("ROLE_ANONYMOUS");

		String path = "redirect:/accessError";

		if (authentication != null && anonymous == -1) {
			model.addAttribute("getDeptInfo", orgService.getDeptInfo());

			path = "/organization/getDeptList";
		}

		return path;
	}

	@RequestMapping(value = "getOrgDeptList", method = RequestMethod.GET)
	public String getOrgDeptListGET(@RequestParam("DEPTID") int DEPTID, Criteria cri, Model model) throws Exception {
		logger.debug("OrginazationController - getOrgDeptListGET() 호출");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		int anonymous = authentication.getAuthorities().toString().indexOf("ROLE_ANONYMOUS");

		String path = "redirect:/accessError";

		if (authentication != null && anonymous == -1) {
			if (cri.getSort() == null) {
				cri.setSort("employee_id");
			}

			if (cri.getOrder() == null) {
				cri.setOrder("ASC");
			}

			model.addAttribute("getOrgDeptList", orgService.getOrgDeptList(DEPTID, cri));
			model.addAttribute("cri", cri);

			path = "/organization/getOrgDeptList";
		}

		return path;
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void fileDownload(@RequestParam("PROFIL") String PROFIL, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		logger.debug("OrginazationController - fileDownload() 호출");

		String downloadPath = req.getRealPath("/upload");
		logger.debug("다운로드할 PROFIL: " + PROFIL);

		// 다운로드할 파일
		File file = new File(downloadPath + File.separator + PROFIL);

		// 첨부파일을 전송하는 통로
		OutputStream out = resp.getOutputStream();

		// 모든 파일의 다운로드 형태를 통일
		resp.setHeader("Cache-Control", "no-cache");
		resp.addHeader("Content-disposition", "attachment; fileName=" + (URLEncoder.encode(PROFIL, "UTF-8")));

		// 썸네일 만들기
		int lastIdx = PROFIL.lastIndexOf(".");

		String thumbFileName = PROFIL.substring(0, lastIdx);
		String fileExtension = PROFIL.substring(lastIdx + 1);

		logger.debug("thumbFIleName: " + thumbFileName);
		logger.debug("fileExtension: " + fileExtension);

		if (file.exists()) {
			Thumbnails.of(file).size(25, 25).outputFormat(fileExtension).toOutputStream(out);
		}

		byte[] buffer = new byte[1024 * 8];

		out.write(buffer);

		out.close();
	}

}
