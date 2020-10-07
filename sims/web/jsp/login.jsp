<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.css" />
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <fieldset>
        <legend>欢迎使用学生信息管理系统</legend>
        <table>
            <tr>
                <td>账号：</td>
                <td><input type="text" required="required" name="mcode" autocomplete="off" /></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" required="required" name="mpassword" autocomplete="off" /></td>
            </tr>
        </table>
        <input type="reset" value="重置" />
        <input type="submit" value="登录" />
    </fieldset>
</form>
<p>&copy;梨枣工作室2020</p>
<span id="msg">${msg}</span>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
</body>
</html>
