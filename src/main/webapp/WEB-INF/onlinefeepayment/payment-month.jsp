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
		
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<div class="mar-auto text-center">
					<h3>Fee From 
						<div class="btn-group" id="myDropdown">
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								Month
								<span class="caret"></span>
							</a>
							April
							 <!-- <ul class="dropdown-menu">
								<li><a href="#">January</a></li>
								<li><a href="#">February</a></li>
								<li><a href="#">March</a></li>
								<li><a href="#">April</a></li>
								<li> <a href="#">May </a></li>
								<li> <a href="#">June</a> </li>
								<li> <a href="#">July</a> </li>
								<li> <a href="#">August</a> </li>
								<li> <a href="#">September</a></li>
								<li> <a href="#">October</a></li>
								<li> <a href="#">November</a> </li>
								<li> <a href="#">December</a></li>
							</ul> -->
						</div>
										
										
						To
							
						<div class="btn-group" id="myDropdown2">
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								Month
								<span class="caret"></span>
							</a>
							<form:form modelAttribute="studentDetails">
								<form:label path=""></form:label>
								<form:select path="admissionNo">
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
							</form:form>
							<!-- <ul class="dropdown-menu">
								<li><a href="#">January</a></li>
								<li><a href="#">February</a></li>
								<li><a href="#">March</a></li>
								<li><a href="#">April</a></li>
								<li> <a href="#">May </a></li>
								<li> <a href="#">June</a> </li>
								<li> <a href="#">July</a> </li>
								<li> <a href="#">August</a> </li>
								<li> <a href="#">September</a></li>
								<li> <a href="#">October</a></li>
								<li> <a href="#">November</a> </li>
								<li> <a href="#">December</a></li>
							</ul> -->
						</div>
					</h3>
			</div>
		</div>
	</div>
                          
    <p class="text-center">
    	<a href="" class="btn btn-success btn-outline-rounded green"> <spring:message code="common.next" text="Next"/> </a>
    </p>           
  </div>
  <div class="clearfix"></div>                        
</div>