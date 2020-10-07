<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>学生信息管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css" />
</head>
<body>
<nav id="#nav">
    <li>
        <form action="${pageContext.request.contextPath}/selectAll" method="post">
            <input type="submit" value="查询所有学生信息" />
        </form>
    </li>
    <li id="add">添加学生信息</li>
    <li id="update">修改学生信息</li>
    <li id="delete">删除学生信息</li>
    <a href="#top">返回顶部</a>
</nav>

<div class="content">
    <ul>
        <li>当前用户：${User.mname}</li>
        <li><a href="logout">退出登录</a></li>
    </ul>

    <ol>
        <div class="select">
            <form action="${pageContext.request.contextPath}/findByTeam" method="post">
                <div class="form-group">
                    <label>客户级别</label>
                    <select	class="form-control" id="steam" name="steam">
                        <option value="">--请选择--</option>
                        <c:forEach items="${Team}" var="item">
                            <option value="${item.steam}" <c:if test="${item.steam == steam}">selected</c:if>>
                                    ${item.steam}</option>
                        </c:forEach>
                    </select>
                </div>
                <input type="submit" value="查询" class="class_select" />
            </form>
        </div>

        <div class="ConditionQuery">
            <form action="${pageContext.request.contextPath}/likeName" method="post">
                <input type="text" required name="sname" placeholder="请输入姓名或姓氏查询" />
                <input type="submit" value="查询" />
            </form>
        </div>
    </ol>

    <table border="3">
        <tr>
            <th>学生ID</th><th>学生姓名</th><th>学号</th><th>密码</th><th>联系电话</th><th>性别</th><th>所属班级</th>
        </tr>
        <%--<c:set var="students" value="${students}" scope="request" />--%>
        <c:forEach var="s" items="${students}">
            <tr>
                <td>${s.sid}</td><td>${s.sname}</td><td>${s.scode}</td><td>${s.spassword}</td>
                <td>${s.sphone}</td><td>${s.sgender}</td><td>${s.steam}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<form action="${pageContext.request.contextPath}/addInfo" id="addSdudent" method="post">
    <fieldset>
        <legend>添加学生信息</legend>
        <div class="drag" id="drag1"></div>
        <table>
            <tr>
                <td>姓名：</td>
                <td><input type="text" name="sname" placeholder="请输入学生姓名（*必填）"
                           required autocomplete="off" /></td>
            </tr>
            <tr>
                <td>学号：</td>
                <td><input type="text" name="scode" placeholder="请输入学生学号（*必填）"
                           required autocomplete="off" /></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="text" name="spassword" placeholder="请输入学生密码（*必填）"
                           required autocomplete="off" /></td>
            </tr>
            <tr>
                <td>联系电话：</td>
                <td><input type="text" name="sphone" placeholder="请输入学生联系电话" class="common" /></td>
            </tr>
            <tr>
                <td>性别：</td>
                <td><input type="text" name="sgender" placeholder="请输入学生性别" class="common" /></td>
            </tr>
            <tr>
                <td>所属分组：</td>
                <td><input type="text" name="steam" placeholder="请输入学生所属分组（*必填）"
                           required autocomplete="off" /></td>
            </tr>
        </table>
        <input type="reset" value="重置" />
        <input type="submit" value="提交" />
    </fieldset>
    <span>&times;</span>
</form>

<form action="${pageContext.request.contextPath}/updateInfo" id="updateInfo" method="post">
    <fieldset>
        <legend>修改学生信息</legend>
        <div class="drag" id="drag2"></div>
        <table>
            <tr>
                <td>ID：</td>
                <td><input type="text" name="sid" placeholder="请输入学生ID（*必填）"
                           required autocomplete="off"/></td>
            </tr>
            <tr>
                <td>姓名：</td>
                <td><input type="text" name="sname" placeholder="请输入学生姓名"
                           class="common"autocomplete="off"/></td>
            </tr>
            <tr>
                <td>学号：</td>
                <td><input type="text" name="scode" placeholder="请输入学生学号"
                           class="common"autocomplete="off" /></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="text" name="spassword" placeholder="请输入学生密码"
                           class="common"autocomplete="off" /></td>
            </tr>
            <tr>
                <td>联系电话：</td>
                <td><input type="text" name="sphone" placeholder="请输入学生联系电话"
                           class="common"autocomplete="off" /></td>
            </tr>
            <tr>
                <td>性别：</td>
                <td><input type="text" name="sgender" placeholder="请输入学生性别"
                           class="common"autocomplete="off" /></td>
            </tr>
            <tr>
                <td>所属分组：</td>
                <td><input type="text" name="steam" placeholder="请输入学生所属分组"
                           class="common"autocomplete="off" /></td>
            </tr>
        </table>
        <input type="reset" value="重置" />
        <input type="submit" value="提交" />
    </fieldset>
    <span>&times;</span>
</form>

<form action="${pageContext.request.contextPath}/deleteInfo" id="deleteInfo" method="post">
    <fieldset>
        <legend>删除学生信息</legend>
        <div class="drag"  id="drag3"></div>
        <table>
            <tr>
                <td>学号：</td>
                <td><input type="text" name="sid" required placeholder="使用ID删除(*必填)"
                           autocomplete="off" /></td>
            </tr>
        </table>
        <input type="reset" value="重置" />
        <input type="submit" value="提交" />
    </fieldset>
    <span>&times;</span>
</form>

<span id="msg">${msg}</span>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/home.js"></script>
</body>
</html>
