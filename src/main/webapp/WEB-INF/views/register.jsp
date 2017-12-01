<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/12/1
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script type="text/javascript">
    //注册失败提示
    var register_err = '<%=request.getAttribute("register_err") == null ? "" : request.getAttribute("register_err")%>'

    if(register_err != null && register_err != '') {
        alert(register_err);
    }
</script>
<html>
<head>
    <title>Register</title>

</head>
<body>

<form action="${website}register" method="post">
       用户名: <input type="text" name="userName" /> <br />
      密码： <input type="password" name="password" /> <br />
        <input type="submit" value="注册" />
      <input type="reset" value="重置" />
    </form>
</body>
</html>
