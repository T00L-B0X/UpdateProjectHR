package com.bswill.employee;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bswill.domain.AppointmentVO;
import com.bswill.domain.Criteria;
import com.bswill.domain.EmployeeVO;
import com.bswill.domain.LicenseVO;
import com.bswill.domain.NotificationVO;
import com.bswill.domain.PageCri;

@Controller
@RequestMapping("/employee/*")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Inject
	private EmployeeService empService;

	// http://localhost:8088/employee/getEmpInfo
	@RequestMapping(value = "/getEmpInfo", method = RequestMethod.GET)
	public String getEmpInfoGET(String update, Model model) throws Exception {
		logger.debug("EmployeeController - getEmpInfoGET() 호출");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		int anonymous = authentication.getAuthorities().toString().indexOf("ROLE_ANONYMOUS");

		String path = "redirect:/loginBswill";

		if (authentication != null && anonymous == -1) {
			if (update != null && update.equals("1")) {
				model.addAttribute("update", "수정 성공!");
			}

			if (update != null && update.equals("0")) {
				model.addAttribute("update", "수정 실패! 지속적으로 문제 발생 시 관리자에게 문의주세요!");
			}

			int employee_id = Integer.parseInt(authentication.getName());

			logger.debug("getEmpInfo: " + empService.getEmpInfo(employee_id));
			logger.debug("viewEmpLicenseVO: " + empService.getEmpLicense(employee_id));
			logger.debug("viewEmpAppointmentVO: " + empService.getEmpAppointment(employee_id));

			model.addAttribute("getEmpInfo", empService.getEmpInfo(employee_id));
			model.addAttribute("getEmpLicense", empService.getEmpLicense(employee_id));
			model.addAttribute("getEmpAppointment", empService.getEmpAppointment(employee_id));

			path = "/employee/getEmpInfo";
		}

		return path;
	}

	@RequestMapping(value = "/getEmpInfo", method = RequestMethod.POST)
	public String updateEmpPOST(EmployeeVO evo, Model model) throws Exception {
		logger.debug("EmployeeController - updateEmpPOST() 호출");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		int employee_id = Integer.parseInt(authentication.getName());

		evo.setEmployee_id(employee_id);
		logger.debug("evo: " + evo);

		String path = "";

		int result = empService.modifyEmpTelAndEmail(evo);

		if (result == 1) {
			path = "redirect:/employee/getEmpInfo?update=1";
		} else {
			model.addAttribute("update", "수정 실패");
			path = "redirect:/employee/getEmpInfo?update=0";
		}

		return path;
	}

	// http://localhost:8088/employee/registEmpGET
	@RequestMapping(value = "/registEmp", method = RequestMethod.GET)
	public String registEmpGET(Model model) throws Exception {
		logger.debug("EmployeeController - registEmpGET() 호출");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		int anonymous = authentication.getAuthorities().toString().indexOf("ROLE_ANONYMOUS");
		int member = authentication.getAuthorities().toString().indexOf("ROLE_MEMBER");

		String path = "redirect:/accessError";

		if (authentication != null && anonymous == -1 && member == -1) {
			path = "/employee/registEmp";
		}

		return path;
	}

	@RequestMapping(value = "/registEmp", method = RequestMethod.POST)
	public String registEmpPOST(EmployeeVO evo, Model model, @RequestParam("profile") MultipartFile profile,
			LicenseVO lList, AppointmentVO aList, HttpServletRequest req) throws Exception {
		logger.debug("EmployeeController - registEmpPOST() 호출");

		logger.debug("evo: " + evo);
		logger.debug("profile: " + profile);
		logger.debug("lList: " + lList);
		logger.debug("aList: " + aList);

		empService.registEmp(evo, profile, lList, aList, req);

		return "redirect:/employee/listEmp";
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void fileDownload(@RequestParam("PROFIL") String PROFIL, HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		logger.debug("fileDownload() 호출");

		String downloadPath = req.getRealPath("/upload");

		logger.debug("다운로드할 fileName: " + PROFIL);

		// 다운로드할 파일
		File file = new File(downloadPath + File.separator + PROFIL);

		// 첨부파일을 전송하는 통로
		OutputStream out = resp.getOutputStream();

		// 모든 파일의 다운로드 형태를 통일
		resp.setHeader("Cache-Control", "no-cache");
		resp.addHeader("Content-disposition", "attachment; fileName=" + (URLEncoder.encode(PROFIL, "UTF-8")));

		// 파일 데이터 읽기
		FileInputStream fis = new FileInputStream(file);

		byte[] buffer = new byte[1024 * 8];

		int data = 0;
		while ((data = fis.read(buffer)) != -1) { // -1 = 파일의 끝(EOF)
			// 다운로드 출력
			out.write(buffer, 0, data);
		}

		out.flush(); // 버퍼의 여백을 공백으로 채움
		out.close();
		fis.close();
	}

	@RequestMapping(value = "/getEmpList", method = RequestMethod.GET)
	public String getEmpListGET(Criteria cri, Model model) throws Exception {
		logger.debug("EmployeeController - listEmpGET() 호출");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		int anonymous = authentication.getAuthorities().toString().indexOf("ROLE_ANONYMOUS");
		int member = authentication.getAuthorities().toString().indexOf("ROLE_MEMBER");

		String path = "redirect:/accessError";

		if (authentication != null && anonymous == -1 && member == -1) {
			if (cri.getSearch() == null) {
				cri.setSearch("employee_id");
			}

			if (cri.getSort() == null) {
				cri.setSort("employee_id");
			}
			
			if(cri.getOrder() == null) {
				cri.setOrder("ASC");
			}
			
			model.addAttribute("getEmpList", empService.getEmpList(cri));
			model.addAttribute("pageCri", new PageCri(cri, empService.countEmp()));
			model.addAttribute("cri", cri);

			path = "/employee/getEmpList";
		}

		return path;
	}

}
