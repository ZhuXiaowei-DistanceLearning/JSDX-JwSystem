<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script src="${pageContext.request.contextPath }/js/custom.box.main.js"
	type="text/javascript"></script>
<script type="text/javascript">
	function doAdd() {
		$("#saveCourse").window("open");
	}
	function doInputScore() {
		var rows = $("#grid").datagrid("getSelected");
		if (rows == null) {
			$.messager.alert("提示信息", "请选择一门课程", "warning");
			$("#doInputScore").window("open");
		} else {
			var courseid = rows.id;
			createmodalwindow("成绩管理", 1200, 600,
					'${pageContext.request.contextPath}/course/addScorePage.action?courseid='
							+ courseid)
		}
	}

	function doTruant() {
		var rows = $("#grid").datagrid("getSelected");
		if (rows == null) {
			$.messager.alert("提示信息", "请选择一门课程", "warning");
		} else {
			var studentId = rows.id;
			$("#cid").val(rows.id);
			var url = "${pageContext.request.contextPath}/score/findStudent.action?studentId="
					+ studentId;
			$.post(url, {}, function(data) {
				for (var i = 0; i < data.length; i++) {
					var id = data[i].students.sid;
					var name = data[i].students.sname;
					$("#roleTD").append(
							'<input type="checkbox" value="' + id + '" name="studentId"/>'
									+ name);
				}
			});
			$("#TruantWindow").window("open");
		}
	}

	function doLate() {
		var rows = $("#grid").datagrid("getSelected");
		if (rows == null) {
			$.messager.alert("提示信息", "请选择一门课程", "warning");
		} else {
			var studentId = rows.id;
			$("#cid").val(rows.id);
			var url = "${pageContext.request.contextPath}/score/findStudent.action?studentId="
					+ studentId;
			$.post(url, {}, function(data) {
				var late = $("#lateTD");
				late.empty();
				for (var i = 0; i < data.length; i++) {
					var id = data[i].students.sid;
					var name = data[i].students.sname;
					$("#lateTD").append(
							'<input type="checkbox" value="' + id + '" name="lateStudentId"/>'
									+ name);
				}
			});
			$("#lateStaffWindow").window("open");
		}
	}

	//工具栏
	var toolbar = [ {
		id : 'button-late',
		text : '添加旷课名单',
		iconCls : 'icon-add',
		handler : doLate
	}, {
		id : 'button-input',
		text : '添加成绩',
		iconCls : 'icon-add',
		handler : doInputScore
	} ];
	// 定义列
	var columns = [ [ {
		field : 'id',
		title : '课程编号',
		width : 120,
		checkbox : true,
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
		$('#grid')
				.datagrid(
						{
							iconCls : 'icon-forward',
							fit : true,
							border : false,
							rownumbers : true,
							striped : true,
							singleSelect : true,
							pageList : [ 30, 50, 100 ],
							pagination : true,
							toolbar : toolbar,
							url : "${pageContext.request.contextPath}/course/findCourseByteacherId.action",
							idField : 'id',
							columns : columns,
							onDblClickRow : doDblClickRow
						});

		$('#TruantWindow').window({
			title : '学生名单',
			width : 400,
			modal : true,
			shadow : true,
			closed : true,
			height : 400,
			resizable : false,
			onClose : onClose
		});

		$('#lateStaffWindow').window({
			title : '学生名单',
			width : 400,
			modal : true,
			shadow : true,
			closed : true,
			height : 400,
			resizable : false
		});

	});

	function doDblClickRow(rowIndex, rowData) {
		$("#importStudent").window("open");
	}

	function onClose() {
		$("#roleTD").empty();
	}
</script>
</head>
<body class="easyui-layout" style="visibility: hidden;">
	<div region="center" border="false">
		<table id="grid"></table>
	</div>

	<!-- 添加旷课学生名单 -->
	<div class="easyui-window" title="添加旷课学生名单" id="TruantWindow"
		collapsible="false" minimizable="false" maximizable="false"
		style="top: 20px; left: 200px">
		<div region="north" style="height: 31px; overflow: hidden;"
			split="false" border="false">
			<div class="datagrid-toolbar">
				<a id="editSave" icon="icon-save" href="#" class="easyui-linkbutton"
					plain="true">保存</a>
				<script type="text/javascript">
					$("#editSave").click(function() {
						$("#TruantWindow").window("close");
					});
				</script>
			</div>
		</div>

		<div region="center" style="overflow: auto; padding: 5px;"
			border="false">
			<form id="editSpecialtyForm" action="addAbsent.action" method="post">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">学生信息</td>
					</tr>
					<tr>
						<td colspan="5" id="roleTD"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<%-- 添加迟到学生名单 --%>
	<div class="easyui-window" title="对学院进行添加或者修改" id="lateStaffWindow"
		collapsible="false" minimizable="false" maximizable="false"
		style="top: 20px; left: 200px">
		<div region="north" style="height: 31px; overflow: hidden;"
			split="false" border="false">
			<div class="datagrid-toolbar">
				<a id="lateSave" icon="icon-save" href="#" class="easyui-linkbutton"
					plain="true">保存</a>
				<script type="text/javascript">
					$("#lateSave")
							.click(
									function() {
										var r = $("#lateSpecialtyForm").form(
												"validate");
										var url = "${pageContext.request.contextPath}/score/addAbsent.action";
										var lateStudentId = $("#lateStudentId")
												.val();
										$.post(url, $("#lateSpecialtyForm")
												.serialize(), function(data) {
											alert(data);
										})
										$("#lateStaffWindow").window("close");
									});
				</script>
			</div>
		</div>

		<div region="center" style="overflow: auto; padding: 5px;"
			border="false">
			<form id="lateSpecialtyForm" action="/score/addAbsent.action"
				method="post">
				<input type="hidden" name="cid" id="cid" />
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">学生名单</td>
					</tr>
					<tr>
						<td colspan="3" id="lateTD"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
