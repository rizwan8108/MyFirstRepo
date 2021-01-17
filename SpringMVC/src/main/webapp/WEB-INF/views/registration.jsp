<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>Add New User</h1>  
       <form:form method="post" action="saveUser" modelAttribute="reg" commandName = "reg">    
        <table >    
         <tr>    
          <td>Full Name : </td>   
          <td><form:input path="fullName" /></td>  
         </tr>    
         <tr>    
          <td>Mobile Number :</td>    
          <td><form:input path="mobileNumber" /></td>  
         </tr>   
         <tr>    
          <td>Email :</td>    
          <td><form:input path="email" /></td>  
         </tr>  
          <tr>    
          <td>Gender :</td>    
          <td><form:input path="gender" /></td>  
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>
</body>
</html>