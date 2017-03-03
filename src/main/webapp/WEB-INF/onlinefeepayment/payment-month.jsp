<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		
								<form:form modelAttribute="studentDetails">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<div class="mar-auto text-center">
					<h3>From 
						<div class="btn-group" id="myDropdown">
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="javascript:void(0)">
								April
							</a>
							
						</div>
										
										
						To
							
						<div class="btn-group" id="myDropdown2">
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="javascript:void(0)">
								<form:label path=""></form:label>
								<form:select path="admissionNo" style="color:blue;">
									<form:option value="1">January</form:option>
									<form:option value="2">February</form:option>
									<form:option value="3">March</form:option>
									<form:option value="4">April</form:option>
									<form:option value="5">May</form:option>
									<form:option value="6">June</form:option>
									<form:option value="7">July</form:option>
									<form:option value="8">August</form:option>
									<form:option value="9">September</form:option>
									<form:option value="10">October</form:option>
									<form:option value="11">November</form:option>
									<form:option value="12">December</form:option>
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
								</div>
							</div>         
  </div>
  <div class="clearfix"></div>                        
</div>
							</form:form>