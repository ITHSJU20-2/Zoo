<%@ page import="se.iths.grupp2.animals.Main" %>
<%@ page import="se.iths.grupp2.animals.Animal" %>
<%@ page import="se.iths.grupp2.animals.Food" %>
<%@ page import="se.iths.grupp2.animals.Ape" %><%--
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
    Animal animal = Main.getController().getAnimalByName(request.getPathInfo().split("/")[1]);
%>
<h1><%=animal.getName()%>
</h1>
<p>Experience: <%=animal.getXp()%> / 10,000</p>
<p>I like: <%for (Food food : animal.getLikes()) {%>
    <%=food.toString().toLowerCase()%>
    <%}%></p>
<%if (animal instanceof Ape) {%>
<p><%="Colour: " + ((Ape) animal).getColour()%>
</p>
<p><%="Size: " + ((Ape) animal).getSize()%>
</p>
<%}%>
<br>


<a href="../">Back</a>

</body>
</html>
