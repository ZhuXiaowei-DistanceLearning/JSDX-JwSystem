<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <!-- 导入jquery核心类库 -->
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
    <!-- 导入easyui类库 -->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/js/easyui/ext/portal.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath }/css/default.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
    <script
            src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"
            type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            $("body").css({visibility: "visible"});
            $('#save').click(function () {
                if ($('#form').form("validate")) {
                    $('#form').submit();
                }
            });
        });
    </script>
</head>
<body class="easyui-layout" style="visibility:hidden;">
<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
    <div class="datagrid-toolbar">
        <a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true">保存</a>
    </div>
</div>
<div region="center" style="overflow:auto;padding:5px;" border="false">
    <form id="form" method="post" action="${pageContext.request.contextPath}/teacher/add.action">
        <table class="table-edit" width="95%" align="center">
            <tr class="title">
                <td colspan="4">基本信息</td>
            </tr>
            <tr>
                <td>用户名:</td>
                <td><input type="text" name="tname" id="username" class="easyui-validatebox" required="true"/></td>
                <td>口令:</td>
                <td><input type="password" name="password" id="password" class="easyui-validatebox" required="true"
                           validType="minLength[5]"/></td>
            </tr>
            <tr class="title">
                <td colspan="4">其他信息</td>
            </tr>
            <tr>
                <td>工资:</td>
                <td><input type="text" name="salary" id="salary" class="easyui-numberbox"/></td>
                <td>入职时间:</td>
                <td><input type="text" name="beginTime" id="birthday" class="easyui-datebox"/></td>
            </tr>
            <tr>
                <td>职员编号:</td>
                <td>
                    <input type="text" name="tid" id="tid" class="easyui-validatebox" required="true"/>
                </td>
                <td>职员职位:</td>
                <td>
                    <input type="text" name="qx" id="qx" class="easyui-validatebox" required="true"/>
                </td>
            </tr>
            <tr>
                <td>年龄:</td>
                <td colspan="3">
                    <input type="text" name="tage" id="tage" class="easyui-validatebox" required="true"/>
                </td>
            </tr>
            <tr>
                <td>性别:</td>
                <td>
                    <select name="tsex" id="gender" class="easyui-combobox" style="width: 150px;">
                        <option value="">请选择</option>
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                </td>
                <td>单位:</td>
                <td>
                    <input class="easyui-combobox" required="true"
                           name="collegeId"
                           data-options="valueField:'id',textField:'name',url:'${pageContext.request.contextPath}/college/listajax.action'"/>
                </td>
            </tr>
            <tr>
                <td>选择角色:</td>
                <td colspan="3" id="roleTD">
                    <script type="text/javascript">
                        $(function () {
                            //发送ajax请求，获取所有的角色数据，返回json，在页面中动态构造到checkbox中
                            var url = "${pageContext.request.contextPath}/role/listajax.action";
                            $.post(url, {}, function (data) {
                                //解析json数据，构造checkbox
                                for (var i = 0; i < data.length; i++) {
                                    var id = data[i].id;
                                    var name = data[i].name;
                                    $("#roleTD").append('<input type="checkbox" value="' + id + '" name="roleIds">' + name);
                                }
                            });
                        });
                    </script>

                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>