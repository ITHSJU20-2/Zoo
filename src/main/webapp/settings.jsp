<%@ page import="se.iths.grupp2.animals.Main" %>
<%@ page import="java.net.URISyntaxException" %><%--
  User: tobiaswadseth
  Date: 2020-12-02
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>Current Game Data</p>
<textarea class="jsongame" name="jsongame" cols="30" rows="10" readonly><%=Main.getDataManager().getData()%></textarea>
<button class="save">Save</button>
<p>Enter Game Data</p>
<textarea class="editjsongame" name="editjsongame" cols="30" rows="10"></textarea>
<button class="load">Load</button>
<a href="./" class="back">Back</a>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"
        integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script>

    $('.save').click(e => {
        $.post('./save', {}, () => {
            console.log("Saved");
        })
    });
    $('.load').click(e => {
        $.post('./load', {data: $('.editjsongame').val()}, () => {
            console.log('Loaded');
            $('.jsongame').val($('.editjsongame').val());
        });
    });
</script>

</body>
</html>
