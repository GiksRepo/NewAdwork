<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="board-inner">
	<ul class="nav nav-tabs" id="myTab">
		<div class="liner"></div>
			<spring:url value="/" var="home"/>
			<li <c:if test="${curl eq 'home' }"> class="active"</c:if>>
				<a href="${home }" title="Student Information">
					<span class="round-tabs one">
						<i class="glyphicon glyphicon-home glyphicon-menu"></i>
					</span> 
				</a>
			</li>

			<spring:url value="/student-details" var="studentDetails"/>
			<li <c:if test="${curl eq 'studentDetails' }"> class="active"</c:if>>
				<a href="${studentDetails }" title="Student Data">
					<span class="round-tabs two">
						<i class="glyphicon glyphicon-gift glyphicon-menu"></i>
					</span> 
				</a>
			</li>
			
			<spring:url value="/payment-month" var="paymentMonth"/>
			<li <c:if test="${curl eq 'paymentMonth' }"> class="active"</c:if>>
				<a href="${paymentMonth }" title="Select Month">
					<span class="round-tabs three">
						<i class="glyphicon glyphicon-user glyphicon-menu"></i>
					</span> 
				</a>
			</li>
			
			<spring:url value="/student-fees" var="studentFees"/>
			<li <c:if test="${curl eq 'studentFees' }"> class="active"</c:if>>
				<a href="${studentFees }" title="Student fee Data">
					<span class="round-tabs four">
						<i class="glyphicon glyphicon-gift glyphicon-menu"></i>
					</span> 
				</a>
			</li>
			
			<spring:url value="/payment-type" var="paymentType"/>
			<li <c:if test="${curl eq 'paymentType' }"> class="active"</c:if>>
				<a href="${paymentType }" title="blah blah">
					<span class="round-tabs five">
						<i class="glyphicon glyphicon-comment glyphicon-menu"></i>
					</span> 
				</a>
			</li>

			<spring:url value="/payment-verified" var="paymentVerify"/>
			<li <c:if test="${curl eq 'paymentVerify' }"> class="active"</c:if>>
				<a href="${paymentVerify }" title="completed">
					<span class="round-tabs six">
						<i class="glyphicon glyphicon-ok glyphicon-menu"></i>
					</span> 
				</a>
			</li>
                     
      </ul>
</div>