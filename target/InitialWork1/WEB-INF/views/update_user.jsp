<%--
  Created by IntelliJ IDEA.
  User: fanghl
  Date: 2017/12/7
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>修改页面</title>
</head>
<body>
<div>
    <center style="margin-top: 140px">
        <form action="/updateUser/${user.id}" method="post">

                    <input type="hidden" name="id" value="${user.id}">
                    用户名: <input type="text" name="userName" value="${user.userName}" /> <br />
                    密码： <input type="text" name="password" value="${user.password}" /> <br />

                        <input type="submit" name="submit" value="修改"/>
                        <a href="/main"><input type="button" value="取消" ></a>

        </form>
    </center>
</div>
</body>
</html>
