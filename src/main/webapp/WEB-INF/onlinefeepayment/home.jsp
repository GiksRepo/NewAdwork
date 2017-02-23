<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="tab-content">
	<div class="tab-pane fade in active" id="home">

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
					<form class="form-horizontal" method="post" action="#"style="padding: 0 30px;">
						
							<div class="form-group">
								<label for="name" class="cols-sm-2 control-label"><spring:message code="home.student.admissionNo" text="Student Admission No"/> </label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
										<input type="text" class="form-control" name="admissionno" id="admissionno"  placeholder="Enter student admission no"/>
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
										<input type="text" class="form-control" name="studentName" id="studentName"  placeholder="Enter student name"/>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="email" class="cols-sm-2 control-label"><spring:message code="home.student.fatherName" text="Father Name"/> </label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
										<input type="text" class="form-control" name="fatherName" id="fatherName"  placeholder="Enter student father name"/>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="username" class="cols-sm-2 control-label"> <spring:message code="home.student.class" text="Class"/></label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
										<input type="text" class="form-control" name="studentClass" id="studentClass"  placeholder="Enter student class"/>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="password" class="cols-sm-2 control-label"> <spring:message code="home.student.section" text="Section"/></label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
										<input type="password" class="form-control" name="studentSection" id="studentSection"  placeholder="Enter student section"/>
									</div>
								</div>
							</div>
							
							<div class="form-group text-center">
								<a href="" class="btn btn-success btn-outline-rounded green"> <spring:message code="home.student.search" text="Search Student Infromation"/> <span style="margin-left:10px;" class="glyphicon glyphicon-send"></span></a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
                          
 	</div>
 	<div class="clearfix"></div>
</div>