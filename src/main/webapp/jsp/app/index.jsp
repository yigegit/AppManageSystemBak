<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>App管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/plugins/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/static/plugins/layui/layui.js"></script>
</head>
<body class="layui-layout-body">

<div class="layui-layout layui-layout-admin">

    <jsp:include page="/jsp/common/header.jsp"/>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <form class="layui-form" action="${pageContext.request.contextPath}/app/query" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">软件名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="softwareName"  placeholder="请输入软件名称" value="${appInfoDTO.softwareName}" autocomplete="off" class="layui-input">
                    </div>

                    <div class="layui-input-inline">
                        <input type="hidden" name="pageNum" value="1">
                    </div>

                    <label class="layui-form-label">APP状态</label>
                    <div class="layui-input-inline">
                        <select name="appStatus" >
                            <option value="">-请选择-</option>
                            <c:forEach items="${appStatus}" var="obj">
                                <option value="${obj.valueId}" <c:if test="${obj.valueId eq appInfoDTO.appStatus}">selected</c:if>>${obj.valueName}</option>
                            </c:forEach>

                        </select>
                    </div>

                    <label class="layui-form-label">所属平台</label>
                    <div class="layui-input-inline">
                        <select name="appFlatform" >
                            <option value="">-请选择-</option>
                            <c:forEach items="${appFlatforms}" var="obj">
                                <option value="${obj.valueId}" <c:if test="${obj.valueId eq appInfoDTO.appFlatform}">selected</c:if> >${obj.valueName}</option>
                            </c:forEach>
                        </select>
                    </div>


                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">一级分类</label>
                    <div class="layui-input-inline">
                        <select name="levelOne" lay-filter="levelOne" id="levelOne">
                                <option value="">-请选择-</option>
                                <c:forEach items="${appCategoriesLevelOne}" var="obj">
                                    <option value="${obj.id}" <c:if test="${obj.id eq appInfoDTO.levelOne}">selected</c:if>>${obj.categoryName}</option>
                                </c:forEach>
                        </select>
                    </div>

                    <label class="layui-form-label">二级分类</label>
                    <div class="layui-input-inline">
                        <select name="levelTwo" lay-filter="levelTwo" id="levelTwo">
                            <option value="">-请选择-</option>
                        </select>
                    </div>

                    <label class="layui-form-label">三级分类</label>
                    <div class="layui-input-inline">
                        <select name="levelThree" lay-filter="levelThree" id="levelThree">
                            <option value="">-请选择-</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn"  lay-filter="formDemo">查询</button>
                    </div>
                </div>
            </form>
            <div class="layui-input-block">
                <a class="layui-btn" href="${pageContext.request.contextPath}/app/toAdd"  lay-filter="formDemo">新增APP基础信息</a>
            </div>
            <table class="layui-table">
                <thead>
                    <tr>
                        <th>软件名称</th>
                        <th>APK名称</th>
                        <th>软件大小(单位:M)</th>
                        <th>所属平台</th>
                        <th>所属分类(一级分类、二级分类、三级分类)</th>
                        <th>状态</th>
                        <th>下载次数</th>
                        <th>最新版本号</th>
                        <th width=100px>操作</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${page.list}" var="obj">
                        <tr>
                            <td>${obj.softwareName}</td>
                            <td>${obj.APKName}</td>
                            <td>${obj.softwareSize}</td>
                            <td>${obj.flatform.valueName}</td>
                            <td>
                                ${obj.categoryLevel1.categoryName}->${obj.categoryLevel2.categoryName}->${obj.categoryLevel3.categoryName}
                            </td>
                            <td>${obj.appStatus.valueName}</td>
                            <td>${obj.downloads}</td>
                            <td>${obj.newAppVersion.versionNo}</td>
                            <td>
                                <%--<a href="${pageContext.request.contextPath}/app/toEdit/${obj.id}" class="layui-btn layui-btn-normal"><span class="layui-icon">&#xe642;</span></a>
                                <a href="${pageContext.request.contextPath}/app/delete/${obj.id}" class="layui-btn layui-btn-danger"><span class="layui-icon">&#xe640;</span></a>
                                <a href="${pageContext.request.contextPath}/app/queryById/${obj.id}" class="layui-btn"><span class="layui-icon">&#xe615;</span></a>--%>
                                <a href="${pageContext.request.contextPath}/app/toEdit/${obj.id}" class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
                                <a href="${pageContext.request.contextPath}/app/delete/${obj.id}" class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                                <a href="${pageContext.request.contextPath}/app/queryById/${obj.id}"class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                        <tr>
                            <td>
                                共${page.total}条记录 第${page.pageNum}/${page.pages}页
                            </td>
                            <td colspan="8">
                                <a href="javascript:void(0);" page="first">首页</a>
                                <a href="javascript:void(0);" page="prev">上一页</a>
                                <a href="javascript:void(0);" page="next">下一页</a>
                                <a href="javascript:void(0);" page="last">尾页</a>
                            </td>
                        </tr>
                </tbody>
            </table>
        </div>
    </div>
    <jsp:include page="/jsp/common/footer.jsp"/>
</div>

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

        //分页功能start=================================================
        $('a[page]').click(function () {
            var pageNum=1;
            var currPage='${page.pageNum}';
            var totalPages='${page.pages}';
            var v = $(this).attr('page');
            switch (v) {
                case 'first':
                    pageNum=1; 
                    break;
                case 'prev':
                    pageNum=parseInt(currPage)-1;
                    if (pageNum<0){
                        pageNum=1;
                    }
                    break;
                case 'next':
                    pageNum=parseInt(currPage)+1;
                    if (pageNum>totalPages){
                        pageNum=totalPages;
                    }
                    break;
                case 'last':
                    pageNum=totalPages;
                    break;
            }
            //更新隐藏域里的值
            $('input[name=pageNum]').val(pageNum);
            //提交表单
            $('form').submit();

        })
        //分页功能end=================================================

        //非手动更新select的值
        $(function () {
            //1.取出一级分类的值
            var levelOne = $('#levelOne').val();
            if(levelOne!=''&&levelOne!=null){
                var levelTwo = '${appInfoDTO.levelTwo}';
                if (levelTwo!=null && levelTwo!=undefined && levelTwo!=''){
                    //就重新请求二级分类
                    $.ajax({
                        url:'${pageContext.request.contextPath}/category/queryLevelTwoByLevelOne/'+levelOne,
                        type:'get',
                        success:function (data) {
                            //根据data修改数据，重新渲染
                            var html = '<option value="">-请选择-</option>';
                            var len = data.length;
                            var levelTwo = '${appInfoDTO.levelTwo}';
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
                    
                    var levelThree = '${appInfoDTO.levelThree}';
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