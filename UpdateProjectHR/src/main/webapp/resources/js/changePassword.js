$(document).ready(function() {
    // URL에서 "error" 파라미터의 값을 가져오기
    const error = new URLSearchParams(window.location.search).get('error');

    $("#currentPassword, #newPassword, #confirmPassword").keyup(function() {
        chk_input_filter("AlphaNum", $(this));
    });

    function chk_input_filter(type, obj) {
        const str = $(obj).val();

        if (type === 'AlphaNum') {
            // 영문, 숫자만 허용
            const filteredStr = str.replace(/[^a-z0-9]/gi, "");

            if (filteredStr !== str) {
                // 입력된 값에 영문, 숫자 이외의 문자가 포함되어 있다면
                $(obj).val(filteredStr); // 필터링된 문자열로 입력값을 대체
                alert("영문자와 숫자만 입력하세요.");
            }
        }
    }

    $("#submitBtn").click(function() {
        const currentPassword = $("#currentPassword").val();
        const newPassword = $("#newPassword").val();
        const confirmPassword = $("#confirmPassword").val();

        if (currentPassword.length < 8 || newPassword.length < 8 || confirmPassword.length < 8) {
            alert("8자 이상의 비밀번호를 입력하세요.");
            return false; // 폼 제출 방지
        }
    });
});