function validateForm() {
	const eveSubject = document.getElementById('eve_subject');
	const eveDate = document.getElementById('eve_date');
	const eveAmount = document.getElementById('eve_amount');

	if (eveSubject.value.length < 2) {
		alert("대상자명은 2자 이상이어야 합니다.");
		eveSubject.focus();
		return false;
	}

	if (eveDate.value === "") {
		alert("경조일자를 입력해주세요.");
		eveDate.focus();
		return false;
	}

	const eveAmountPattern = /^\d+$/;

	if (!eveAmountPattern.test(eveAmount.value)) {
		alert('신청금액은 숫자로만 입력해주세요.');
		eveAmount.focus();
		return false;
	}

	alert("경조비 신청이 완료되었습니다.");
	return true;
}