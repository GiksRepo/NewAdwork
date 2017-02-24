<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="tab-content">
					<div class="tab-pane fade in active" id="messages">
                          <h3 class="head text-center"> <spring:message code="student-fee.title" text="Fee Details"/> </h3>
                          <div class="col-md-12 col-xs-12">
								<div class="mar-auto text-center">
<!-- Student Fee Details -->
									<div id="data_fees" class="col-md-12 col-sm-12 col-xs-12 table_fee">
											<div class="divdata">
												<div class="col-md-4 col-sm-8 col-xs-8">
													<span style="font-weight:bold"><spring:message code="student-fee.student.admissionFee" text="Admission Fee"/> </span>
												</div>
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span>10000 Rs.</spans>
												</div>
											</div>
											<div class="divdata">
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span style="font-weight:bold"><spring:message code="student-fee.student.tutionFee" text="Tution Fee"/> </span>
												</div>
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span>8000 Rs.</span>
												</div>
											</div>
											<div class="divdata">
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span style="font-weight:bold"><spring:message code="student-fee.student.transportCharges" text="Transportation Charges"/> </span>
												</div>
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span>5000 Rs.</span>
												</div>
											</div>
											<div class="divdata">
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span style="font-weight:bold"><spring:message code="student-fee.student.buildingCharges" text="Building Charges"/> </span>
												</div>
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span>2500 Rs.</span>
												</div>
											</div>
											<div class="divdata">
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span style="font-weight:bold"><spring:message code="student-fee.student.computerCharges" text="Computer Charges"/> </span>
												</div>
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span>1000 Rs.</span>
												</div>
											</div>
											<div class="divdata">
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span style="font-weight:bold"><spring:message code="student-fee.student.penaltyCharges" text="Penalty Charges"/></span>
												</div>
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span>500 Rs.</span>
												</div>
											</div>
											<div class="divdata">
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span style="font-weight:bold"><spring:message code="student-fee.student.miscCharges" text="Miscellaneous Charges"/> </span>
												</div>
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span>250 Rs.</span>
												</div>
											</div>
											<div class="divdata">
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span style="font-weight:bold"> <spring:message code="student-fee.student.totalPayment" text="Total"/> </span>
												</div>
												<div class="col-md-4 col-sm-6 col-xs-12">
													<span>27250 Rs.</span>
												</div>
											</div>
										</div >
									<!--Student Fee Details end -->
									
									</div>
							</div>
                          
                          	<p class="text-center">
                    			<a href="" class="btn btn-success btn-outline-rounded green"> <spring:message code="student-fee.onlinePayment" text="Online Payment"/> <span style="margin-left:10px;" class="glyphicon glyphicon-send"></span></a>
                			</p>
                      </div>
                      <div class="clearfix"></div>
</div>
		