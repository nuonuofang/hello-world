<%@ page import="com.xiaozl.initialwork1.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div>
    <center style="margin-top: 140px">
        <h3>欢迎你,${user.userName}!!!</h3>
        <h4><a href="${website}main">点此进行用户管理</a></h4>
        <table>
            <tr>
                <form action="${website}file/upload" method="post" enctype="multipart/form-data">
                    选择文件:<input type="file" name="file" width="120px">
                    <input type="submit" value="上传">
                </form>
            </tr>
            <tr>
                <form action="${website}file/down" method="get">
                    <input type="submit" value="下载">
                </form>
            </tr>

        </table>
        <center/>
</div>
</body>
</html>
