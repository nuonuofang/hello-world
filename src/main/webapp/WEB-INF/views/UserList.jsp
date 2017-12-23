<%--
  Created by IntelliJ IDEA.
  User: fanghl
  Date: 2017/12/21
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>


    <link href="my_style.css" rel="stylesheet" type="text/css" />

    <title>用户管理列表</title>
    <h3><a href="${website}/">返回首页</a></h3>
</head>
<body>
<%--<table border="0">
    <tr>
        <td>
            <form action="${website}/user/select" method="post">
                <input type="text" name="keyword"/>
                <input type="submit" name="submit" value="搜索用户"/>
            </form>
        </td>
    </tr>
</table>--%>


<table border="1">
    <tr bgcolor="#e6e6fa">
        <th>用户编号</th><th>用户名</th><th>密码</th><th colspan="2">操作</th>
    </tr>
    <c:forEach items="${userList}" var="user">
        <tr bgcolor="#e0ffff">
            <td><a href="${website}content/${user.id}">${user.id}</a>
            </td>
            <td>${user.userName}</td>
            <td>${user.password}</td>
            <td><a href="${website}del/${user.id}">删除</a>
            </td>
            <td><a href="${website}toUpdate/${user.id}">修改</a>
            </td>
        </tr>
    </c:forEach>

    <tr bgcolor="#e0ffff">
        <td colspan="6" align="right"><a href="${website}toAdd">添加</a></td>
    </tr>
</table>
</body>
</html>
