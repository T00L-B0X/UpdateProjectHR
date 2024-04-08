package com.bswill.employee;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bswill.domain.AppointmentVO;
import com.bswill.domain.Criteria;
import com.bswill.domain.EmployeeVO;
import com.bswill.domain.LicenseVO;
import com.bswill.domain.NotificationVO;
import com.bswill.notification.NotificationService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Inject
	private EmployeeDAO edao;

	@Inject
	private PasswordEncoder pwEncoder;

	@Inject
	private NotificationService notiService;

	private String saveProfile(int employee_id, MultipartFile profile, HttpServletRequest req) throws Exception {
		String uploadDir = req.getRealPath("/upload");
		String profileName = employee_id + "." + profile.getOriginalFilename().split("\\.")[1];
		String profilePath = uploadDir + File.separator + profileName;

		File dir = new File(uploadDir);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		try (OutputStream os = new FileOutputStream(profilePath)) {
			os.write(profile.getBytes());
		}

		return profileName;
	}

	@Override
	public Map<String, Object> getEmpInfo(Integer employee_id) throws Exception {
		logger.debug("getEmpInfo(Integer employee_id) 호출");

		return edao.selectEmpInfo(employee_id);
	}

	@Override
	public List<LicenseVO> getEmpLicense(Integer employee_id) throws Exception {
		logger.debug("getEmpLicense(Integer employee_id) 호출");

		return edao.selectEmpLicense(employee_id);
	}

	@Override
	public List<AppointmentVO> getEmpAppointment(Integer employee_id) throws Exception {
		logger.debug("getEmpAppointment(Integer employee_id) 호출");

		return edao.selectEmpAppointment(employee_id);
	}

	@Override
	public int modifyEmpTelAndEmail(EmployeeVO evo) throws Exception {
		logger.debug("modifyEmpTelAndEmail(EmployeeVO evo) 호출");

		return edao.updateEmpTelAndEmail(evo);
	}

	@Override
	public void registEmp(EmployeeVO evo, MultipartFile profile, LicenseVO lList, AppointmentVO aList,
			HttpServletRequest req) throws Exception {
		logger.debug(
				"registEmp(EmployeeVO evo, MultipartFile profile, List<LicenseVO> lList, List<AppointmentVO> aList, HttpServletRequest req) 호출");

		// 입사일자에서 년도 추출
		String dateString = evo.getStart_date().toString();
		String[] parts = dateString.split("-");
		String year = parts[0];

		// 해당년도 입사순번 + 100
		int empno = edao.selectEmpnoCount(year);
		logger.debug("empno: " + empno);

		// employee_id = 입사년도 + 입사부서 + (해당년도 입사순번 + 100)
		String employee_id = "" + year + evo.getDEPTID() + empno;
		logger.debug("emp:" + employee_id);
		evo.setEmployee_id(Integer.parseInt(employee_id));

		// 최초 PASSWD = 생년월일(yyyyMMdd) + 입사일자(yyyyMMdd)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String birthFormat = evo.getBirth().replaceAll("-", "");
		logger.debug("birth:" + evo.getBirth());
		String startFormat = sdf.format(evo.getStart_date());
		String PASSWD = birthFormat + startFormat;
		logger.debug("PASSWD:" + PASSWD);

		// 비밀번호 암호화(단방향)
		String password = pwEncoder.encode(PASSWD);
		logger.debug("password:" + password);
		evo.setPASSWD(password);

		// 프로필
		String profileName = saveProfile(evo.getEmployee_id(), profile, req);
		logger.debug("profileName:" + profileName);
		evo.setPROFIL(profileName);

		edao.insertEmp(evo);
		edao.insertRole_Member(Integer.parseInt(employee_id));

		logger.debug("lList.to: " + lList.toString());
		logger.debug("aList.to: " + aList.toString());
		logger.debug("lList.to12: " + (lList.toString().indexOf("]]]") == -1));
		logger.debug("aList.to12: " + (aList.toString().indexOf("]]]") == -1));

		if (lList.toString().indexOf("]]") != -1) {
			for (LicenseVO lvo : lList.getLList()) {
				if (lvo.getLicense() != null) {
					lvo.setEmployee_id(Integer.parseInt(employee_id));

					edao.insertLicense(lvo);
				}
			}
		}

		if (aList.toString().indexOf("]]") != -1) {
			for (AppointmentVO avo : aList.getaList()) {
				if (avo.getApp_issue() != null) {
					avo.setEmployee_id(Integer.parseInt(employee_id));

					edao.insertAppointment(avo);
				}
			}
		}

		NotificationVO nvo = new NotificationVO();
		nvo.setEmployee_id(Integer.parseInt(employee_id));
		nvo.setNoti_title(evo.getEmp_name() + "님의 입사를 축하합니다.");
		nvo.setNoti_link("/employee/getEmpInfo");

		notiService.addNoti(nvo);
	}

	@Override
	public int countEmp() throws Exception {
		logger.debug("countEmp() 호출");

		return edao.selectEmpCount();
	}

	@Override
	public List<Map<String, Object>> getEmpList(Criteria cri) throws Exception {
		logger.debug("getEmpList(Criteria cri) 호출");

		if (cri.getSearch().equals("STATUS")) {
			switch (cri.getKeyword()) {
			case "재직":
				cri.setKeyword("1");
				break;
			case "휴직":
				cri.setKeyword("2");
				break;
			case "퇴직":
				cri.setKeyword("3");
				break;
			default:
				break;
			}
		}

		return edao.selectEmpList(cri);
	}

}
