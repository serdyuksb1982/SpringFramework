<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Uzer
  Date: 26.10.2021
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
    <header>

    </header>
<body>
<h2 title="List Employees">All Employees</h2>
<table>
    <tr>
        <th title="Name">Name</th>
        <th title="Lastname">Lastname</th>
        <th title="Surname">Surname</th>
        <th title="Department name">Department</th>
        <th title="Salary usd">Salary</th>
        <th title="Phone number type: XXX-XX-XX">Phone Number</th>
        <th title="Operations">Operations</th>
    </tr>
    <c:forEach var="emp" items="${allEmployees}">

        <c:url var="updateButton" value="/updateInfo">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>
        <c:url var="deleteButton" value="/deleteEmployee">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>

        <tr>
            <td>${emp.name}</td>
            <td>${emp.lastname}</td>
            <td>${emp.surname}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
            <td>${emp.phoneNumber}</td>
            <td>
                <input type="button" value="Update"
                onclick="window.location.href = '${updateButton}'"/>

                <input type="button" value="Delete"
                onclick="window.location.href = '${deleteButton}'"/>
            </td>

        </tr>

    </c:forEach>


</table>
<br>
<input type="button" value="Add"
     onclick="window.location.href = 'addNewEmployee'"/>

</body>

</html>
