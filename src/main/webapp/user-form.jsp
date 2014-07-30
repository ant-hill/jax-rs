<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<form action="rest/issue/add" method="post">
    <p>
        Name : <input type="text" name="name"/>
    </p>

    <p>
        Age : <input type="text" name="age"/>
    </p>
    <input type="submit" value="Add User"/>
</form>
</body>
</html>
