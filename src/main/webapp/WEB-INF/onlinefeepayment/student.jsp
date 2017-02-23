<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="tab-content">
					<div class="tab-pane fade in active" id="messages">
                          <h3 class="head text-center"><spring:message code="student.student.header" text="Student Details"/> </h3>
                          <div class="col-md-12 col-xs-12">
								<div class="mar-auto text-center">
									<!-- Student info details -->
									<div id="std_data" class="row">
										<div id="data" class="col-md-9 col-sm-8 col-xs-12">
											<div class="divdata">
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span style="font-weight:bold">Student Name :</span>
												</div>
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span>Aayush Kumar</spans>
												</div>
											</div>
											<div class="divdata">
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span style="font-weight:bold">Father Name :</span>
												</div>
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span>Sushil Kumar</span>
												</div>
											</div>
											<div class="divdata">
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span style="font-weight:bold">Class:</span>
												</div>
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span>IV th</span>
												</div>
											</div>
											<div class="divdata">
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span style="font-weight:bold">Section :</span>
												</div>
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span>A</span>
												</div>
											</div>
											<div class="divdata">
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span style="font-weight:bold">Period :</span>
												</div>
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span>July to Sept</span>
												</div>
											</div>
											<div class="divdata">
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span style="font-weight:bold">Admission No :</span>
												</div>
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span>0123456</span>
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
                    			<a href="" class="btn btn-success btn-outline-rounded green" style="background-color:#4386FC;"> Online Payment <span style="margin-left:10px;" class="glyphicon glyphicon-send"></span></a>
                			</p>
                      </div>
                      <div class="clearfix"></div>
</div>