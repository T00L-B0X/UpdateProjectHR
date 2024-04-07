function previewImage(event) {
	const input = event.target;
	const profile = input.files[0];

	if (profile) {
		if (profile.type.startsWith('image/')) {
			const preview = document.getElementById('preview');

			preview.style.display = 'block';

			const reader = new FileReader();

			reader.onload = function() {
				preview.src = reader.result;
			};

			reader.readAsDataURL(profile);

			document.getElementById('errorMessage').style.display = 'none';
		} else {
			document.getElementById('errorMessage').style.display = 'block';
			input.value = '';
			resetPreview();
		}
	} else {
		resetPreview();
	}
}

function resetPreview() {
	const preview = document.getElementById('preview');
	preview.style.display = 'none';
	preview.src = '';
}

let licenseNo = 0;
let appointmentNo = 0;

function addRow(tableId) {
	let table = document.getElementById(tableId);
	let newRow = table.insertRow();

	// Create cells for the new row
	let cell1 = newRow.insertCell();
	let cell2 = newRow.insertCell();
	let cell3 = newRow.insertCell();

	// Populate cells based on tableId
	if (tableId === "licenseTable") {
		cell1.innerHTML = "<input type='text' name='lList[" + licenseNo
				+ "].license'>";
		cell2.innerHTML = "<input type='text' name='lList[" + licenseNo
				+ "].li_org'>";
		cell3.innerHTML = "<input type='date' name='lList[" + licenseNo
				+ "].li_date' max='9999-12-31'>";
		licenseNo++;
	} else if (tableId === "appointmentTable") {
		cell1.innerHTML = "<select name='aList["
				+ appointmentNo
				+ "].app_issue'><option value='입사'>입사</option><option value='승진'>승진</option><option value='부서이동'>부서 이동</option><option value='퇴사'>퇴사</option><option value='휴직'>휴직</option><option value='복직'>복직</option></select>";
		cell2.innerHTML = "<input type='text' name='aList[" + appointmentNo
				+ "].app_content'>";
		cell3.innerHTML = "<input type='date' name='aList[" + appointmentNo
				+ "].app_date' max='9999-12-31'>";
		appointmentNo++;
	}

	// Create delete button cell
	let deleteCell = newRow.insertCell();
	deleteCell.innerHTML = "<input type='button' value='행 삭제' onclick='deleteRow(this);'>";
}

function deleteRow(btn) {
	let row = btn.closest("tr");
	row.parentNode.removeChild(row);
}

function validateForm() {
	const profileInput = document.getElementById('profile');
	const empNameInput = document.getElementById('emp_name');
	const birthInput = document.getElementById('birth');
	const empTelInput = document.getElementById('emp_tel');
	const empMailInput = document.getElementById('emp_mail');
	const startDateInput = document.getElementById('start_date');
	const empAddrInput = document.getElementById('emp_addr');

	if (profileInput.files.length === 0) {
		alert("프로필을 선택해주세요.");
		profileInput.focus();
		return false;
	}

	if (empNameInput.value.length < 2) {
		alert("사원명은 2자 이상이어야 합니다.");
		empNameInput.focus();
		return false;
	}

	if (birthInput.value === "") {
		alert("생년월일을 입력해주세요.");
		birthInput.focus();
		return false;
	}

	const empTel = empTelInput.value;
	const empMail = empMailInput.value;

	const telPattern = /^\d{7,13}$/;
	const mailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

	if (!telPattern.test(empTel)) {
		alert('연락처는 7~13자의 숫자만 입력 가능합니다.');
		empTelInput.focus();
		return false;
	}

	if (!mailPattern.test(empMail)) {
		alert('올바른 이메일 형식이 아닙니다.');
		empMailInput.focus();
		return false;
	}
	
	if (startDateInput.value === "") {
		alert("입사일을 입력해주세요.");
		startDateInput.focus();
		return false;
	}

	if (empAddrInput.value === "") {
		alert("주소를 입력해주세요.");
		empAddrInput.focus();
		return false;
	}

	return true;
	alert('신규 사원을 등록하였습니다.');
}
