<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="tab-content">
<div class="tab-pane fade in active" id="profile">
<div class="col-md-12 col-xs-12">
							  <c:if test="${not empty studentDetails.error}">
							  		<div class="alert alert-danger">
	  									<strong>${studentDetails.error}</strong>
									</div>
							  </c:if> 
						</div>
	<h3 class="head text-center"><spring:message code="payment-month.title" text="Select Month"/> </h3>
    	<p class="narrow text-center">
        <!-- this text will appear from Db -->	Admission No:${studentDetails.admissionNo } 
        </p>
		
	<form:form modelAttribute="studentDetails" action="payment-month" method="POST">
				<div class="row">
					<div class="col-md-12 col-xs-12">
						<div class="mar-auto text-center">
							<c:set var="months" value="${['select','April','May','June','July','August','September','October','November','December','January','February','March']}"></c:set>
							<h3>From 
									<c:out value="${months[studentDetails.fromMonth - 3]}"></c:out>	
								To
									
								<div class="btn-group" id="myDropdown2">
									<a class="btn dropdown-toggle" data-toggle="dropdown" href="javascript:void(0)">
										<%-- <form:label path=""></form:label> --%>
										<form:select path="toMonth" style="color:blue;">
											<c:forEach var="month" items="${months}" varStatus="loop">
												<c:if test="${loop.index ge studentDetails.fromMonth - 3}">
		   											 <form:option value="${loop.index + 3}">${month }</form:option>
		   										</c:if>
											</c:forEach>
										</form:select>
									</a>
								</div>
							</h3>
					</div>
				</div>
			</div>
		                          
		    <%-- <p class="text-center">
		    	<a href="" class="btn btn-success btn-outline-rounded green"> <spring:message code="common.next" text="Next"/> </a>
		    </p>   --%>
		    <div class="form-group text-center">
										<%-- <a href="javascript:void(0);" id="searchStudentBtn" class="btn btn-success btn-outline-rounded green"> <spring:message code="home.student.search" text="Search Student Infromation"/> <span style="margin-left:10px;" class="glyphicon glyphicon-send"></span></a> --%>
										<input type="submit" id="searchStudentBtn" value="<spring:message code="common.next" text="Next"/>" class="btn btn-success btn-outline-rounded green">
										<div id="loadingDiv" style="display:none;">
											<spring:url value="resources/assets/images/ajax_loader.gif" var="loadingImage"/>
											<img src="${loadingImage }"/>
										</div><div id="totalDiv"><b>Total selected months :</b> <span id = "totalMonths" Style="color:blue;"></span></div>
									</div>         
		  </div>
		  <div class="clearfix"></div>                        
		</div>
</form:form>

<script>
	var fromMonth = parseInt(${studentDetails.fromMonth});
	var toMonth = parseInt($('#toMonth').val());
	var monthsToPay = (toMonth - fromMonth) + 1;
	$('#totalMonths').text(monthsToPay);
	$('#toMonth').on('change', function(){
		toMonth = parseInt($(this).val());
		monthsToPay = (toMonth - fromMonth) + 1;
		$('#totalMonths').text(monthsToPay);
	});
</script>