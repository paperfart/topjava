<%@ page import="ru.javawebinar.topjava.util.TimeUtil" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <title>Meals</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }

        th, td {
            padding: 5px;
        }
    </style>
</head>
<body>
<h3><a href="../../index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<div>
    <table style="width:40%">
        <tr>
            <th>Date</th>
            <th>Description</th>
            <th>Calories</th>

        </tr>
        <%--@elvariable id="meals" type="java.util.List"--%>
        <c:forEach items="${meals}" var="meal">

            <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.MealTo"/>
            <tr style="color:
                <c:out value="${meal.excess == true ? 'crimson' : 'blue'}"/> ">
                <td><%=TimeUtil.formatDate(meal.getDateTime())%>
                </td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                <td><a href="meals?time=${meal.dateTime}&action=edit">Edit</a></td>
                <td><a href="meals?time=${meal.dateTime}&action=delete">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<br/><input type="button" onclick="location.href='meals?action=new';" value="Create new"/>

</body>
</html>