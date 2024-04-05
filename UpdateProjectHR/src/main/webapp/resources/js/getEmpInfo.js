// 유효성 검사 함수
function validateForm() {
    const empTel = document.getElementById('emp_tel').value;
    const empMail = document.getElementById('emp_mail').value;

    // 연락처 검사: 7~13자의 숫자만 허용
    const telPattern = /^\d{7,13}$/;

    // 이메일 검사: 이메일 형식
    const mailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    // 연락처 유효성 검사
    if (!telPattern.test(empTel)) {
        alert('연락처는 7~13자의 숫자만 입력 가능합니다.');
        document.getElementById('emp_tel').focus();
        return false; // 유효하지 않으면 false 반환
    }

    // 이메일 유효성 검사
    if (!mailPattern.test(empMail)) {
        alert('올바른 이메일 형식이 아닙니다.');
        document.getElementById('emp_mail').focus();
        return false; // 유효하지 않으면 false 반환
    }

    // 모든 검사를 통과했을 때
    return true; // 폼 제출
    alert('연락처와 이메일을 변경하였습니다.');
}
