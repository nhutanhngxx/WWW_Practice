<%--
  Created by IntelliJ IDEA.
  User: VoVanHai
  Date: 17/08/2024
  Time: 14:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>COunt</title>
</head>
<body>
<%
    long count = 0;
    Object obj = request.getServletContext().getAttribute("count");
    String s = "";
    if (obj == null)
        s = "0";
    else
        s=obj.toString();
    count = Long.parseLong(s) + 1;
    request.getServletContext().setAttribute("count", count);
%>
<h1>Your visit count =
    <%=count%>
</h1>
</body>
</html>
