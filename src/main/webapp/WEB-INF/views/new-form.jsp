<%--
  Created by IntelliJ IDEA.
  User: yeonnex
  Date: 2023/01/02
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 앞으로 재사용을 위해 상대경로 사용. [현재 URL 이 속한 계층 경로 + /save] 그러나 일반적으로 절대 경로를 쓰는 것이 더 좋다. --%>
<form action="save" method="post">
    username: <input type="text" name="username">
    age: <input type="text" name="age">
    <button type="submit">전송</button>
</form>
</body>
</html>
