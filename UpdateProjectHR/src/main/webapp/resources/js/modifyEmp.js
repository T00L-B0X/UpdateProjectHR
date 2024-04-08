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

function validateForm() {
	const empNameInput = document.getElementById('emp_name');
	const birthInput = document.getElementById('birth');
	const empTelInput = document.getElementById('emp_tel');
	const empMailInput = document.getElementById('emp_mail');
	const startDateInput = document.getElementById('start_date');
	const empAddrInput = document.getElementById('emp_addr');

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

	if (empAddrInput.value === "") {
		alert("주소를 입력해주세요.");
		empAddrInput.focus();
		return false;
	}

	alert('사원정보를 수정하였습니다.');
	return true;
}
