<%@ page import="com.bigwanggang.Persion" %><%--
  Created by IntelliJ IDEA.
  User: gustaov
  Date: 2017/12/13
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>select your choice</title>
</head>
<body>
<%
    String ftype = request.getParameter("ftype");
    String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
    out.println("name:" + name);
    Persion.save(name + "--" + ftype + " host:" + request.getRemoteHost() + " ip: " + request.getRemoteAddr());
%>
保存成功
</body>
</html>

