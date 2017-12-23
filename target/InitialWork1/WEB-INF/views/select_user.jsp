<%--
  Created by IntelliJ IDEA.
  User: fanghl
  Date: 2017/12/7
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>搜索页面</title>
</head>
<body>
<center style="margin-top: 140px">
    <th>${message}</th>
    <table border="1">
        <tr bgcolor="#a9a9a9">
            <th>用户编号</th><th>用户名</th><th>密码</th>
        </tr>
        <c:forEach items="${}" var="user" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td>${user.user_name}</td>
                <td>${user.password}</td>

            </tr>
        </c:forEach>
        <tr>
            <td colspan="6" align="center"><a href="${website}main">返回</a></td>
        </tr>

    </table>
</center>

</body>
</html>
