<%--
  Created by IntelliJ IDEA.
  User: KRISHNA
  Date: 28-10-2015
  Time: 11:04
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Welcome to practise question set on java and groovy</title>
</head>

<body>

<h1>Welcome to practise test questions on java and groovy</h1>
<g:form action="submit">
    <g:each in="${questionAnswer}" var="q">
        <li style="list-style: none;color:darkgreen;font-size: 15px;font-family: Helvetica, Arial, san-serif">${q.key.questionName}</li>
        <g:each in="${q.value}" var="op">
            <input type="radio" name="${q.key.id}" value="${op.id}"/>
            <label>${op.optionName}</label>
        </g:each>
        <hr>
    </g:each>
    <input type="submit" value="Submit">
</g:form>
</body>
</html>