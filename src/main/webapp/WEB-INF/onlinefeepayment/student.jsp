<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="tab-content">
					<div class="tab-pane fade in active" id="messages">
						<div class="col-md-12 col-xs-12">
							  <c:if test="${not empty error}">
							  		<div class="alert alert-danger">
	  									<strong>${error}</strong>
									</div>
							  </c:if>
						</div>
						 
						 <c:if test="${empty error}"> 
                          <h3 class="head text-center"><spring:message code="student.student.header" text="Student Details"/> </h3>
                          <div class="col-md-12 col-xs-12">
								<div class="mar-auto text-center">
									<!-- Student info details -->
									<div id="std_data" class="row">
										<div id="data" class="col-md-9 col-sm-8 col-xs-12">
											<div class="divdata">
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span style="font-weight:bold"><spring:message code="home.student.admissionNo" text="Student Admission No"/></span>
												</div>
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span>${studentDetails.admissionNo } </span>
												</div>
											</div>
											<div class="divdata">
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span style="font-weight:bold"><spring:message code="home.student.name" text="Student Name"/></span>
												</div>
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span>${studentDetails.studentName } </spans>
												</div>
											</div>
											<div class="divdata">
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span style="font-weight:bold"><spring:message code="home.student.fatherName" text="Father Name"/></span>
												</div>
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span>${studentDetails.fatherName }</span>
												</div>
											</div>
											<div class="divdata">
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span style="font-weight:bold"><spring:message code="home.student.class" text="Class"/></span>
												</div>
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span>${studentDetails.studentClass }</span>
												</div>
											</div>
											<div class="divdata">
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span style="font-weight:bold"><spring:message code="home.student.section" text="Section"/></span>
												</div>
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span>${studentDetails.studentSection }</span>
												</div>
											</div>
										</div >
										<div id="std_pic" class="col-md-3 col-sm-4 col-xs-12">
											<spring:url value="resources/assets/images/image.jpg" var="studentPhoto"/>
											<img src="${studentPhoto }" class="img-thumbnail img-responsive"/>
										</div>
									</div>
									<!-- Student info details end -->
									
							</div>
							</div>
                          
                          	<p class="text-center">
                    			<a href="" class="btn btn-success btn-outline-rounded green" style="background-color:#4386FC;"> <spring:message code="common.next" text="Next"/> </a>
                			</p>
                			</c:if>
                      </div>
                      <div class="clearfix"></div>
</div>