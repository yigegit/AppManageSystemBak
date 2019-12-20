<%--
  Created by IntelliJ IDEA.
  User: Mercer
  Date: 2019/4/14
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>开发者登陆</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/plugins/layui/css/layui.css">
    <style>
        body{
            width: 300px;
            margin: auto;
            margin-top: 100px;
        }
    </style>
</head>
<body>
    ${errMsg}
    <div class="layui-container">
        <form action="${pageContext.request.contextPath}/dev/login" method="post" class="layui-form">
            <div class="layui-form-item">
                <div class="layui-input-inline">
                    <input type="text" name="devCode" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-inline">
                    <input type="password" name="devPassword" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-inline">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">登陆</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重填</button>
                </div>
            </div>
        </form>

    </div>

<%--js--%>
<script src="${pageContext.request.contextPath}/static/plugins/layui/layui.js"></script>
</body>
</html>

