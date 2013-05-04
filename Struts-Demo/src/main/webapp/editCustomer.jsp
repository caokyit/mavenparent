<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
</head>
 
<body>
<div class="container" >
<h1>Struts 2 + Hibernate integration example</h1>

<s:property value="customer.address"/>
<s:form action="saveCustomer" >
  <s:textfield cssStyle="display:none" name="customer.customerId"   />
  <s:textfield name="customer.name"  label="Name"  />
  <s:textarea name="customer.address"  label="Address"  cols="50" rows="5"/>
  <%--  <s:textfield name="name" value ="name" label="Name"  />
   
  <s:textarea name="address" value ="<s:property value = 'address' />" label="Address"  cols="50" rows="5"/> --%>
  <s:submit />
</s:form>

<br/>
<br/>

</div>
</body>
</html>