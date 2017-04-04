<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>
    	<tiles:getAsString name="PageTitle"/>
    </title>
	<spring:url value="resources/assets/js/jquery.min.js" var="jqueryjs"/>	
   <script src="${jqueryjs }"></script>
   <spring:url value="resources/assets/js/bootstrap.min.js" var="bootstrapjs"/>	
   <script src="${bootstrapjs }"></script>
    <!-- Bootstrap -->
	<spring:url value="resources/assets/css/bootstrap.min.css" var="bootstrapCss"/>
	<link rel="stylesheet" href="${bootstrapCss}">
    <spring:url value="resources/assets/css/style.css" var="styleCss"/>
	<link rel="stylesheet" href="${styleCss}">
	<spring:url value="resources/assets/css/custom.css" var="customCss"/>
	<link rel="stylesheet" href="${customCss}">
	<spring:url value="resources/assets/css/font-awesome.min.css" var="faCss"/>
	<link rel="stylesheet" href="${faCss}">
	<spring:url value="resources/assets/css/myStyle.css" var="myCss"/>
	<link rel="stylesheet" href="${myCss}">
	<spring:url value="resources/assets/css/error.css" var="errorCss"/>
	<link rel="stylesheet" href="${errorCss}">
  </head>
  <body style="background:#efefe9;">
 <!--  <section style="background:#efefe9;">  -->
  	<div class="container">
  		<div class="row">
               <div class="board">
               		<tiles:insertAttribute name="headerMenu"/>
					<tiles:insertAttribute name="content"/>
               </div>
         </div>
  	</div>
  <!--  </section> -->
   <spring:url value="resources/assets/js/custom.js" var="customjs"/>
   <script src="${customjs }"></script>
   <spring:url value="resources/assets/js/app.js" var="appjs"/>
   <script src="${appjs }"></script>
  </body>
  </html>