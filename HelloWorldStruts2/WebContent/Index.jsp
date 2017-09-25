<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<%@ taglib uri="/struts-tags" prefix="s" %>
  <title>Lowe's India Pvt Ltd</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
</head>
<body>

<div class="jumbotron text-center"  style="background-color: lightblue">
  <h2 class="text-danger">APPLICATION MATRIX</h2>
</div>

<div class="container">
	<s:form method="get" action="ApplicationServlet">
	    <div class="dropdown">
	        Select Type: 
	     <s:select list="#{'0':'Federation','1':'Reverse Proxy','2':'Agent Based','3':'All'}" name="type"></s:select>    
	    </div>
		<br> Search: <s:textfield name="search" placeholder="Search.."/>
		<br><br><s:submit  name="submit" value="Submit" class="btn btn-primary" ></s:submit>
	</s:form>
	</div>
	
</body>
</html>