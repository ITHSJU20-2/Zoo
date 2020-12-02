<%--
  User: tobiaswadseth
  Date: 2020-11-30
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String animal = request.getPathInfo().split("/")[1];
%>
<h1><%=animal%></h1>
<br>

<a href="../">Back</a>

</body>
</html>
