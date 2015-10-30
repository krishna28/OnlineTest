<%--
  Created by IntelliJ IDEA.
  User: KRISHNA
  Date: 29-10-2015
  Time: 08:03
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>

<g:if test="${result}">
    <h2>"Congrats you passed the test, your score percentage is ${passPercentage}"</h2>
</g:if>
<g:else>
    <h2>"Sorry you could not clear this time please try again"</h2>
</g:else>

</body>
</html>