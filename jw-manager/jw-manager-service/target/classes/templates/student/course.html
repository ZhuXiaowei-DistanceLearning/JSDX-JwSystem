<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 导入jquery核心类库 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/ztree/jquery-1.8.3.js"></script>
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
	function doView() {
		var rows = $("#grid").datagrid('getSelected');
		if (rows == null) {
			$.messager.alert("提示信息", "请选择一门课程", "warning");
		} else {
			var ids = rows.id;
			var peoples = rows.people;
			if (peoples > 2) {
				$.messager.alert("提示信息", "本课程人数已上限，请选择其他课程", "warning");
			} else {
				var url = "${pageContext.request.contextPath}/score/findIdExist.action?ids="
						+ ids;
				$
						.post(
								url,
								{},
								function(data) {
									if (data == "1") {
										$.messager.alert("提示信息",
												"你已经选择了此门课程，请不要重复添加！",
												"warning");
									} else {
										location.href = "${pageContext.request.contextPath}/score/save.action?ids="
												+ ids + "&&people=" + peoples;
										$("#grid").datagrid("reload");
									}
								});
			}
		}
	}

	//工具栏
	var toolbar = [ {
		id : 'button-view',
		text : '保存课程',
		iconCls : 'icon-add',
		handler : doView
	} ];
	// 定义列
	var columns = [ [ {
		field : 'id',
		title : '课程编号',
		width : 120,
		checkbox : true
	}, {
		field : 'name',
		title : '课程名称',
		width : 120,
		align : 'center'
	}, {
		field : 'credit',
		title : '学分',
		width : 120,
		align : 'center'
	}, {
		field : 'classroom',
		title : '上课教室',
		width : 120,
		align : 'center'
	}, {
		field : 'time',
		title : '上课周数',
		width : 120,
		align : 'center',
		formatter : function(data, row, index) {
			return row.week.time;
		}
	}, {
		field : 'sectionTime',
		title : '上课时间',
		width : 120,
		align : 'center',
		formatter : function(data, row, index) {
			return row.section.sectionTime;
		}
	}, {
		field : 'people',
		title : '已选人数/课程人数',
		width : 120,
		align : 'center',
		formatter : function(data, row, index) {
			return row.showpeople;
		}
	}, {
		field : 'nature_name',
		title : '课程性质',
		width : 120,
		align : 'center',
		formatter : function(data, row, index) {
			return row.nature.name;
		}
	} ] ];

	$(function() {
		// 先将body隐藏，再显示，不会出现页面刷新效果
		$("body").css({
			visibility : "visible"
		});

		// 取派员信息表格
		$('#grid').datagrid({
			iconCls : 'icon-forward',
			fit : true,
			border : false,
			rownumbers : true,
			striped : true,
			singleSelect : true,
			pageList : [ 30, 50, 100 ],
			pagination : true,
			toolbar : toolbar,
			url : "${pageContext.request.contextPath}/course/pageQuery.action",
			idField : 'id',
			columns : columns
		});
	});
</script>
</head>

<body class="easyui-layout" style="visibility: hidden;">
	<div region="center" border="false">
		<table id="grid"></table>
	</div>
</body>
</html>
