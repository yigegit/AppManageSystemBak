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
            <form class="layui-form" action="${pageContext.request.contextPath}/app/edit" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">软件名称</label>
                    <input type="hidden" name="id" value="${appSingleInfo.id}">
                    <div class="layui-input-inline">
                        <input type="text" name="softwareName"  placeholder="请输入软件名称" value="${appSingleInfo.softwareName}"  autocomplete="off" class="layui-input">
                    </div>
                    <label class="layui-form-label">APK名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="APKName"  placeholder="请输入APK名称" value="${appSingleInfo.APKName}"  autocomplete="off" class="layui-input">
                    </div>
                    <label class="layui-form-label">支持ROM</label>
                    <div class="layui-input-inline">
                        <input type="text" name="supportROM"  placeholder="请输入支持ROM" value="${appSingleInfo.supportROM}"  autocomplete="off" class="layui-input">
                    </div>
                    <label class="layui-form-label">界面语言</label>
                    <div class="layui-input-inline">
                        <input type="text" name="interfaceLanguage"  placeholder="请输入界面语言" value="${appSingleInfo.interfaceLanguage}"  autocomplete="off" class="layui-input">
                    </div>

                </div>
                <div class="layui-form-item">
                         <%--TODO 应用状态--%>
                        <label class="layui-form-label">APP状态</label>
                        <div class="layui-input-inline">
                            <select name="appStatus.valueId" >
                                <option value="">-请选择-</option>
                                <c:forEach items="${appStatus}" var="obj">
                                    <option value="${obj.valueId}" <c:if test="${obj.valueId eq appSingleInfo.appStatus.valueId}">selected</c:if>>${obj.valueName}</option>
                                </c:forEach>
                            </select>
                        </div>

                       <%--TODO 一级分类--%>
                        <label class="layui-form-label">一级分类</label>
                        <div class="layui-input-inline">
                            <select name="categoryLevel1.id" lay-filter="levelOne" id="levelOne">
                                <option value="">-请选择-</option>
                                <c:forEach items="${appCategoriesLevelOne}" var="obj">
                                    <option value="${obj.id}" <c:if test="${obj.id eq appSingleInfo.categoryLevel1.id}">selected</c:if>>${obj.categoryName}</option>
                                </c:forEach>
                            </select>
                        </div>

                      <%--TODO 二级分类--%>
                        <label class="layui-form-label">二级分类</label>
                        <div class="layui-input-inline">
                            <select name="categoryLevel2.id" lay-filter="levelTwo" id="levelTwo">
                                <option value="">-请选择-</option>
                            </select>
                        </div>
                        <%--TODO 三级分类--%>
                        <label class="layui-form-label">三级分类</label>
                        <div class="layui-input-inline">
                            <select name="categoryLevel3.id" lay-filter="levelThree" id="levelThree">
                                <option value="">-请选择-</option>
                            </select>
                        </div>

                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">软件大小</label>
                    <div class="layui-input-inline">
                        <input type="text" name="softwareSize" value="${appSingleInfo.softwareSize}"  placeholder="请输入软件大小"  autocomplete="off" class="layui-input">
                    </div>
                    <label class="layui-form-label">应用简介</label>
                    <div class="layui-input-inline">
                        <input type="text" name="appInfo" value="${appSingleInfo.appInfo}"  placeholder="请输入应用简介"  autocomplete="off" class="layui-input">
                    </div>
                    <%--TODO app平台--%>
                    <label class="layui-form-label">所属平台</label>
                    <div class="layui-input-inline">
                        <select name="flatform.valueId" >
                            <option value="">-请选择-</option>
                            <c:forEach items="${appFlatforms}" var="obj">
                                <option value="${obj.valueId}"  <c:if test="${obj.valueId eq appSingleInfo.flatform.valueId}">selected</c:if>>${obj.valueName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn"  lay-filter="formDemo">修改</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <jsp:include page="/jsp/common/footer.jsp"/>
</div>
<script src="${pageContext.request.contextPath}/static/plugins/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use(['element','form','jquery'], function(){
        var element = layui.element;
        var form = layui.form;
        var $ = layui.jquery;
        //一级分类start=================================================
        form.on('select(levelOne)',function () {
            //获取id
            var levelOne = $('#levelOne').val();
            if (levelOne == ''){
                var html = '<option value="">-请选择-</option>';
                $('#levelTwo').html(html);
                form.render();
            }
            else {
                $.ajax({
                    url:'${pageContext.request.contextPath}/category/queryLevelTwoByLevelOne/'+levelOne,
                    type:'get',
                    success:function (data) {
                        //根据data修改数据，重新渲染
                        var html = '<option value="">-请选择-</option>';
                        var len = data.length;
                        for (var i=0;i<len;i++){
                            html+='<option value="'+data[i].id+'">'+data[i].categoryName+'</option>'
                        }
                        $('#levelTwo').html(html);
                        form.render();
                    }
                })
            }

        });
        //一级分类end=================================================

        //二级分类start=================================================
        form.on('select(levelTwo)',function () {
            //获取id
            var levelTwo = $('#levelTwo').val();
            if (levelTwo == ''){
                //清空
                var html = '<option value="">-请选择-</option>';
                $('#levelThree').html(html);
                form.render();
            }
            else {
                $.ajax({
                    url:'${pageContext.request.contextPath}/category/queryLevelThreeByLevelTwo/'+levelTwo,
                    type:'get',
                    success:function (data) {
                        //根据data修改数据，重新渲染
                        var html = '<option value="">-请选择-</option>';
                        var len = data.length;
                        for (var i=0;i<len;i++){
                            html+='<option value="'+data[i].id+'">'+data[i].categoryName+'</option>'
                        }
                        //更新level
                        $('#levelThree').html(html);
                        form.render();
                    }
                })
            }

        })
        //二级分类end=================================================

        //非手动更新select的值
        $(function () {
            //1.取出一级分类的值
            var levelOne = $('#levelOne').val();
            if(levelOne!=''&&levelOne!=null){
                var levelTwo = '${appSingleInfo.categoryLevel2.id}';
                if (levelTwo!=null && levelTwo!=undefined && levelTwo!=''){
                    //就重新请求二级分类
                    $.ajax({
                        url:'${pageContext.request.contextPath}/category/queryLevelTwoByLevelOne/'+levelOne,
                        type:'get',
                        success:function (data) {
                            //根据data修改数据，重新渲染
                            var html = '<option value="">-请选择-</option>';
                            var len = data.length;
                            for (var i=0;i<len;i++){
                                html+='<option value="'+data[i].id+'"';
                                if (data[i].id==levelTwo){
                                    html+=' selected ';
                                }
                                html+='>'+data[i].categoryName+'</option>';
                            }
                            $('#levelTwo').html(html);
                            form.render();
                        }
                    });

                    var levelThree = '${appSingleInfo.categoryLevel3.id}';
                    $.ajax({
                        url:'${pageContext.request.contextPath}/category/queryLevelThreeByLevelTwo/'+levelTwo,
                        type:'get',
                        success:function (data) {
                            //根据data修改数据，重新渲染
                            var html = '<option value="">-请选择-</option>';
                            var len = data.length;
                            for (var i=0;i<len;i++){
                                html+='<option value="'+data[i].id+'"';
                                if (data[i].id==levelThree){
                                    html+=' selected ';
                                }
                                html+='>'+data[i].categoryName+'</option>';
                            }
                            //更新level
                            $('#levelThree').html(html);
                            form.render();
                        }
                    })
                }
            }
        })

    });
</script>
</body>
</html>
