<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Uzer
  Date: 31.10.2021
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Information for all employees</h3>
<br><br>
<security:authorize access="hasRole('HR')">
<input type="button" value="Salary"
       onclick="window.location.href = 'hr_info'"/>
Only for HR sfaff
</security:authorize>
<br><br>
    <security:authorize access="hasRole('MANAGER')">
<input type="button" value="Performance"
       onclick="window.location.href = 'manager_info'"/>
Only for Manager
</security:authorize>
</body>
</html>
