<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
</head>
 
<body>
<div class="container" >
<h1>Struts 2 + Hibernate integration example</h1>

<h2>Add Customer</h2>
<s:form action="addCustomerAction" >
  <s:textfield name="name" label="Name" value="" />
  <s:textarea name="address" label="Address" value="" cols="50" rows="5" />
  <s:submit />
</s:form>

<h2>All Customers</h2>

<s:if test="customerList.size() > 0">
<table border="1px" cellpadding="8px">
	<tr>
		<th>Customer Id</th>
		<th>Name</th>
		<th>Address</th>
		<th>Created Date</th>
		<th>update</th>
		<th>delete</th>
	</tr>
	<s:iterator value="customerList" status="userStatus">
		<tr>
			<td><s:property value="customerId" /></td>
			<td><s:property value="name" /></td>
			<td><s:property value="address" /></td>
			<td><s:date name="createdDate" format="dd/MM/yyyy" /></td>
			<td><a href="updateCustomerAction?id=<s:property value ='customerId'/>">update</a></td>
			<td><a href="deleteCustomerAction?id=<s:property value ='customerId'/>">delete</a></td>
		</tr>
		
		
	</s:iterator>
</table>
</s:if>
<br/>
<br/>

</div>
</body>
</html>