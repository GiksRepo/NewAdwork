<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="background:brown;padding-top:2px;text-align:center;">
	<h1>
		<span>Exception Occured</span>
	</h1>
</div>
<div style="padding-top:2px;padding-bottom:5px;text-align:center;">
	<h3>
		<c:if test="${not empty errorMessage}">
			<span>Error Caused by : ${errorMessage}</span>
			<br>Please report to dpun.dinesh@gmail.com
		</c:if>
	</h3>
</div>
