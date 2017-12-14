<%@ page import="com.bigwanggang.Persion" %><%--
  Created by IntelliJ IDEA.
  User: 10183960
  Date: 2017/12/13
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:useBean id="persion" class="com.bigwanggang.Persion"/>
<%
    persion.setName(new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8"));
    persion.setId(request.getParameter("id"));
    persion.setAge(Integer.parseInt(request.getParameter("age")));
    Persion.save(persion);
%>保存成功！
<p><%out.print(persion.getName());%></p>
</body>
</html>
