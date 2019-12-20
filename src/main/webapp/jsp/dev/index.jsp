<%--
  Created by IntelliJ IDEA.
  User: Mercer
  Date: 2019/4/14
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>App管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/plugins/layui/css/layui.css">
</head>
<body class="layui-layout-body">

<div class="layui-layout layui-layout-admin">

    <jsp:include page="../common/header.jsp"/>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            欢迎你：${sessionScope.devUser.devName} | 角色：开发者
        </div>
    </div>
    <jsp:include page="../common/footer.jsp"/>
</div>
<script src="${pageContext.request.contextPath}/static/plugins/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>
