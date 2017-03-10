<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="tab-content">
	<div class="tab-pane fade in active" id="home">
		<div class="col-md-12 col-xs-12">
							  <c:if test="${not empty home.error}">
							  		<div class="alert alert-danger">
	  									<strong>${home.error}</strong>
									</div>
							  </c:if>
						</div>
						 
						 

    	<h3 class="head text-center"> <spring:message code="giks.appName" text="default app name"/> </h3>
            <p class="narrow text-center">
            	<i class="fa fa-envelope" style="color:#5CB85C" aria-hidden="true"></i> : <spring:message code="giks.appEmailId" text="default email Id"/>
            </p>
            <p class="narrow text-center">
            	<i class="fa fa-phone-square" style="color:#5CB85C" aria-hidden="true"></i> : <spring:message code="giks.appPhoneNo" text="default phone no"/>
            </p>
						  
		<div class="row" >
			<div class="col-md-12 col-xs-12">
				<div class="main  mar-auto" style="border:1px solid #ddd; margin-bottom:20px">
				
				<div class="panel-heading">
	               <div class="panel-title text-center">
	               		<h4 class="title"> <spring:message code="home.title" text="default title"/> </h4>
	               		<hr />
	               	</div>
	            </div> 
				<div class="main-login main-center">
					<spring:url value="/search-Details" var="target"/>
					<form:form modelAttribute="home" id="formHome" action="${target}" class="form-horizontal" method="post" style="padding: 0 30px;" >
							
							<div class="form-group">
								<label for="name" class="cols-sm-2 control-label"><spring:message code="home.student.admissionNo" text="Student Admission No"/> </label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
										<form:input placeholder="Enter student admission no" path="admissionNo" type="text" class="form-control" value = "${studentAdmissionNO}"/>
									</div>
								</div>
							</div>
							
							<div class="form-group">
								<label for="name" class="cols-sm-2 control-label">Or</label>
							</div>

							
							<div class="form-group">
								<label for="name" class="cols-sm-2 control-label"><spring:message code="home.student.name" text="Student Name"/> </label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
										<form:input placeholder="Enter student name" path="studentName" type="text" class="form-control"/>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="email" class="cols-sm-2 control-label"><spring:message code="home.student.fatherName" text="Father Name"/> </label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
										<form:input placeholder="Enter student father name" path="fatherName" type="text" class="form-control"/>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="username" class="cols-sm-2 control-label"> <spring:message code="home.student.class" text="Class"/></label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
										<%-- <form:select path="studentClass" items="standardList" class="form-control"/> --%>
										<form:select path="studentClass" class="form-control">
											<form:option value="">Select Standard</form:option>
										    <form:options items="${home.standardList}" />
										</form:select>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="password" class="cols-sm-2 control-label"> <spring:message code="home.student.section" text="Section"/></label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
										<form:input placeholder="Enter student section" path="studentSection" type="text" class="form-control"/>
									</div>
								</div>
							</div>
							
							<div class="form-group text-center">
								<%-- <a href="javascript:void(0);" id="searchStudentBtn" class="btn btn-success btn-outline-rounded green"> <spring:message code="home.student.search" text="Search Student Infromation"/> <span style="margin-left:10px;" class="glyphicon glyphicon-send"></span></a> --%>
								<input type="submit" id="searchStudentBtn" value="<spring:message code="home.student.search" text="Search Student Infromation"/>" class="btn btn-success btn-outline-rounded green">
								<div id="loadingDiv" style="display:none;">
									<spring:url value="resources/assets/images/ajax_loader.gif" var="loadingImage"/>
									<img src="${loadingImage }"/>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
 	</div>
 	<div class="clearfix"></div>
</div>