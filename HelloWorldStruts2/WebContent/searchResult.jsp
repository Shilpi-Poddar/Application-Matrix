<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'>
</script>
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'>
</script>
<script src='js/excel.js'></script>
<title>Lowe's India Pvt Ltd</title>
<style>
   a {
        color:blue;
     }
</style>
</head>

<body>
  <br>
<div class="pull-right">
        <a href="#" onclick="fnExcelReport()">
          <span class="glyphicon glyphicon-download-alt">Export</span> 
        </a>
</div>
<a data-toggle="modal" href="#" data-target="#myModal">To Search More</a>

<div class="modal fade" id="myModal">
	<div class="modal-dialog">
	<div class="modal-content">
	<div style="background-color:#add8e6">
	<s:form method="get" action="ApplicationServlet">
	<br>
	    <div class="dropdown">
	        Select Type: 
	     <s:select list="#{'0':'Federation','1':'Reverse Proxy','2':'Agent Based','3':'All'}" name="type"></s:select>    
	    </div>
		<br> Search: <s:textfield name="search" placeholder="Search.."/>
		<br><br><s:submit  name="submit" value="Submit" class="btn btn-primary" ></s:submit>
	
	</s:form>
	<br>
    </div>
    </div>
    </div>
</div>
<div class='container-fluid'>
<table id="myTable" class='table table-striped table-bordered table-hover table-condensed' style='width:1000%'>
	<thead>
		  <tr class='success'>
				<s:iterator value="headerList">
		 				<th> <s:property /> </th>
				</s:iterator>
		  </tr>
	</thead>
	<tbody>
	
		<s:iterator value="matrixList">
		
			<tr class='small' class='info'>
			<td><s:property value="applicationName"/></td>
			<td><s:property value="vendor"/></td>
			<td><s:property value="description"/></td>
			<td><s:property value="businessArea"/></td>
			<td><s:property value="said"/></td>
			<td><s:property value="internal"/></td>
			<td><s:property value="external"/></td>
			<td><s:property value="applicationOwner"/></td>
			<td><s:property value="contactDetails"/></td>
			<td><s:property value="rcAppLevel"/></td>
			<td><s:property value="applicationType"/></td>
			<td><s:property value="applicationStatus"/></td>
			<td><s:property value="apm"/></td>
			<td><s:property value="brm"/></td>
			<td><s:property value="toc"/></td>
			<td><s:property value="partnershipName_prod"/></td>
			<td><s:property value="spid_prod"/></td>
			<td><s:property value="entityName_prod"/></td>
			<td><s:property value="acs_prod"/></td>
			<td><s:property value="sso_prod"/></td>
			<td><s:property value="encryption_prod"/></td>
			<td><s:property value="spid_qa"/></td>
			<td><s:property value="entityName_qa"/></td>
			<td><s:property value="acs_qa"/></td>
			<td><s:property value="sso_qa"/></td>
			<td><s:property value="encryption_qa"/></td>
			</tr>
		
		</s:iterator> 
		
	</tbody>
</table>

<br>
<table  id="myTable_reverse"  class='table table-striped table-bordered table-hover table-condensed' style='width:1000%'>
	<thead>
	  <tr class='success'>
			<s:iterator value="header">
	 				<th> <s:property /> </th>
			</s:iterator>
	  </tr>
	</thead>
	<tbody>
		<s:iterator value="matrixList1">
		
			<tr class='small' class='info'>
			<td><s:property value="applicationName_prod"/></td>
			<td><s:property value="poc_prod"/></td>
			<td><s:property value="appCode_prod"/></td>
			<td><s:property value="lowesLink_prod"/></td>
			<td><s:property value="backendApp_prod"/></td>
			<td><s:property value="applicationName_qa"/></td>
			<td><s:property value="poc_qa"/></td>
			<td><s:property value="appCode_qa"/></td>
			<td><s:property value="lowesLink_qa"/></td>
			<td><s:property value="backendApp_qa"/></td>
			</tr>
		
		</s:iterator> 
	</tbody>
</table>
</div>
</body>
</html>

