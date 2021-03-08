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
    <form method="post" action="meals" enctype="application/x-www-form-urlencoded">

        <table style="width:40%">
            <tr>
                <th>Date</th>
                <th>Description</th>
                <th>Calories</th>

            </tr>
            <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.Meal" scope="request"/>
            <input type="hidden" name="oldtime" value="${meal.dateTime}">
            <tr>
                <td><input type="text" name="time" value="<%=TimeUtil.formatDate(meal.getDateTime())%>"></td>
                <td><input type="text" name="description" value="${meal.description}"></td>
                <td><input type="text" name="calories" value="${meal.calories}"></td>
            </tr>
        </table>
        <br/>
        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>