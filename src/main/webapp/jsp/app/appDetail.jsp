<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>App管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/plugins/layui/css/layui.css">
</head>
<body class="layui-layout-body">

<div class="layui-layout layui-layout-admin">

    <jsp:include page="/jsp/common/header.jsp"/>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <div class="layui-nav-title">
                <h2>软件基础信息</h2>
            </div>
            <div class="layui-form-item">
            <label class="layui-form-label">软件名称</label>
            <div class="layui-input-inline">
                <input type="text" readonly value="${appInfoDetailWithVersion.softwareName}" autocomplete="off"
                       class="layui-input">
            </div>
            <label class="layui-form-label">APK名称</label>
            <div class="layui-input-inline">
                <input type="text" readonly value="${appInfoDetailWithVersion.APKName}" autocomplete="off"
                       class="layui-input">
            </div>
            <label class="layui-form-label">支持ROM</label>
            <div class="layui-input-inline">
                <input type="text" readonly value="${appInfoDetailWithVersion.supportROM}" autocomplete="off"
                       class="layui-input">
            </div>
            <label class="layui-form-label">界面语言</label>
            <div class="layui-input-inline">
                <input type="text" readonly value="${appInfoDetailWithVersion.interfaceLanguage}" autocomplete="off"
                       class="layui-input">
            </div>
            </div>
            <div class="layui-form-item">
                <%--TODO 应用状态--%>
                <label class="layui-form-label">APP状态</label>
                <div class="layui-input-inline">
                    <input type="text" readonly value="${appInfoDetailWithVersion.appStatus.valueName}" autocomplete="off"
                           class="layui-input">
                </div>

                <%--TODO 一级分类--%>
                <label class="layui-form-label">一级分类</label>
                <div class="layui-input-inline">
                    <input type="text" readonly value="${appInfoDetailWithVersion.categoryLevel1.categoryName}"
                           autocomplete="off" class="layui-input">
                </div>

                <%--TODO 二级分类--%>
                <label class="layui-form-label">二级分类</label>
                <div class="layui-input-inline">
                    <input type="text" readonly value="${appInfoDetailWithVersion.categoryLevel2.categoryName}"
                           autocomplete="off" class="layui-input">
                </div>
                <%--TODO 三级分类--%>
                <label class="layui-form-label">三级分类</label>
                <div class="layui-input-inline">
                    <input type="text" readonly value="${appInfoDetailWithVersion.categoryLevel3.categoryName}"
                           autocomplete="off" class="layui-input">
                </div>

            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">软件大小</label>
                <div class="layui-input-inline">
                    <input type="text" readonly  value="${appInfoDetailWithVersion.softwareSize}"  autocomplete="off" class="layui-input">
                </div>
                <label class="layui-form-label">应用简介</label>
                <div class="layui-input-inline">
                    <input type="text" readonly  value="${appInfoDetailWithVersion.appInfo}"  autocomplete="off" class="layui-input">
                </div>
                <%--TODO app平台--%>
                <label class="layui-form-label">所属平台</label>
                <div class="layui-input-inline">
                    <input type="text" readonly  value="${appInfoDetailWithVersion.flatform.valueName}"  autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-nav-title">
                <h2>历史版本信息</h2>
            </div>
            <table class="layui-table">
                <thead>
                    <tr>
                        <th>版本编号</th>
                        <th>APK文件名称</th>
                        <th>APK位置</th>
                        <th>下载连接</th>
                        <th>版本大小</th>
                        <th>版本信息</th>
                    </tr>
                </thead>
                <tbody>
                   <c:forEach items="${appInfoDetailWithVersion.appVersions}" var="obj">
                       <tr>
                           <td>${obj.versionNo}</td>
                           <td>${obj.apkFileName}</td>
                           <td>${obj.apkLocPath}</td>
                           <td><a href="${obj.downloadLink}">下载</a></td>
                           <td>${obj.versionSize}</td>
                           <td>${obj.versionInfo}</td>
                       </tr>
                   </c:forEach>
                </tbody>

            </table>

        </div>


    </div>
</div>
<jsp:include page="/jsp/common/footer.jsp"/>
</div>
<script src="${pageContext.request.contextPath}/static/plugins/layui/layui.js"></script>
<script>

    layui.use(['element', 'form', 'jquery'], function () {
        var element = layui.element;
        var form = layui.form;
        var $ = layui.jquery;


    });
</script>
</body>
</html>
