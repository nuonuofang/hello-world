<%--
  Created by IntelliJ IDEA.
  User: fanghl
  Date: 2017/11/7
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户显示页面</title>
</head>
<body>
<div>
    <center>
        <table border="1" style="margin-top: 140px">
            <tr>
                <td>用户名</td>
                <td>${user.userName}</td>
            </tr>
            <tr>
                <td>密码</td>
                <td>${user.password}</td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <a href="${website}main"><input type="button" value="返回主页"/></a>
                </td>
            </tr>
        </table>
    </center>
</div>
</body>
</html>
