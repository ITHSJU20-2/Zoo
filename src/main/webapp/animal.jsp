<%@ page import="se.iths.grupp2.zoo.*" %>
<%@ page import="se.iths.grupp2.zoo.animals.Animal" %>
<%@ page import="se.iths.grupp2.zoo.animals.ape.Ape" %>
<%@ page import="se.iths.grupp2.zoo.animals.bird.Bird" %>
<%@ page import="se.iths.grupp2.zoo.animals.Food" %><%--
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
<p>Experience: <%=animal.getXp()%> / 5000</p>
<%if (animal.getXp() <= 999) {%>
<p><%="Level 1: Prey"%>
</p>
<%}%>
<%if (animal.getXp() >= 1000 && animal.getXp() <= 1999) {%>
<p><%="Level 2: Runt"%>
</p>
<%}%>
<%if (animal.getXp() >= 2000 && animal.getXp() <= 2999) {%>
<p><%="Level 3: Noble beast"%>
</p>
<%}%>
<%if (animal.getXp() >= 3000 && animal.getXp() <= 3999) {%>
<p><%="Level 4: Alpha specimen"%>
</p>
<%}%>
<%if (animal.getXp() >= 4000 && animal.getXp() <= 5000) {%>
<p><%="Level 5: Kingly creature"%>
</p>
<%}%>
<p>I like: <%for (Food food : animal.getLikes()) {%>
    <%=food.toString().toLowerCase()%>
    <%}%></p>
<%if (animal instanceof Ape) {%>
<p><%="Colour: " + ((Ape) animal).getColour()%>
</p>
<p><%="Size: " + ((Ape) animal).getSize()%>
</p>
<%}%>
<%if (animal instanceof Bird) {%>
<p><%="Sound: " + ((Bird) animal).getSound()%>
</p>
<p><%="Can I fly?: " + (((Bird) animal).isCanFly() ? "Yes" : "No")%>
</p>
<%}%>
<br>


<a href="../">Back</a>

</body>
</html>
