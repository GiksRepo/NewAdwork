<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="tab-content">
<div class="container-fluid">
  <div class="row">
    <div class="col-sm-4">
    	<spring:url value="resources/assets/images/batmanGIF.gif" var="errorImage"/>
		<img src="${errorImage }"/>
    </div>
    <div class="col-sm-8" style="color:red">
    	<br>
    	<br>
    	<br>
    	<h1 class="text-center"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i> 405</h1>
    	<h3 class="text-center">GET request is not allowed for given request.</h3>
    </div>
  </div>
</div>
</div>