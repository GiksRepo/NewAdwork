<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="tab-content">
<div class="tab-pane fade in active" id="profile">
	<h3 class="head text-center"><spring:message code="payment-month.title" text="Select Month"/> </h3>
    	<p class="narrow text-center">
        <!-- this text will appear from Db -->	Fee Payment for Session 2017 - 2018
        </p>
		
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<div class="mar-auto text-center">
					<h3>Select  From 
						<div class="btn-group" id="myDropdown">
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								Month
								<span class="caret"></span>
							</a>
							 <ul class="dropdown-menu">
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
							</ul>
						</div>
										
										
						To
							
						<div class="btn-group" id="myDropdown2">
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								Month
								<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
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
							</ul>
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