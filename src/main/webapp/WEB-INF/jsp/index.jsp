<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head><title>SpringBoot</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }
        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>

<table>
    <tr>
        <th>Name</th>
        <th>Phone</th>
        <th>Data Hired</th>
        <th>Action</th>
    </tr>
    <c:forEach var = "list" items = "${lists3}">
        <tr>
            <td>${list[1]}</td>
            <td>${list[2]}</td>
            <td>${list[3]}</td>
            <td>
                <a href="/hire/${list[0]}">View</a>
                <a href="/fire/${list[0]}">Fire</a>
                <a href="/edit/${list[0]}">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>
<hr/>
<form method="post" action="/save">
    <input type="hidden" name="id" value=""/>
    Name:<br>
    <input type="text" name="name"/>
    <br>
    Phone:<br>
    <input type="text" name="phone" >
    <br>
    Date Hired:<br>
    <input type="date" name="dateHired" >
    <br><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>