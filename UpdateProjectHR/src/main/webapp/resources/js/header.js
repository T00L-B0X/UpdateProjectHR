document.addEventListener("DOMContentLoaded", function() {
    const currentUrl = window.location.href;

    if (currentUrl.includes("/employee/")) {
    	document.getElementById("employee").classList.add("active");
    }
    
    if (currentUrl.includes("/event/")) {
    	document.getElementById("event").classList.add("active");
    }
    
    if (currentUrl.includes("/salary/")) {
    	document.getElementById("salary").classList.add("active");
    }
    
    if (currentUrl.includes("/organization/")) {
    	document.getElementById("organization").classList.add("active");
    }
});