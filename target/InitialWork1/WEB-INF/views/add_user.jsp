<%--
  Created by IntelliJ IDEA.
  User: fanghl
  Date: 2017/11/7
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>增加用户</title>
</head>
<body>
<div>
    <center style="margin-top: 140px">
        <form action="${website}register" method="post">
            <table border="0" >
                <tr>
                    <td>用户名</td>
                    <td><input type="text" name="userName"/></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input type="text" name="password"/></td>
                </tr>

                    <td colspan="2" align="center">
                        <input type="submit" name="submit" value="确定"/>
                        <a href="${website}main"><input type="button" value="取消" ></a>
                    </td>
                </tr>
            </table>
        </form>
    </center>
</div>
</body>
</html>
