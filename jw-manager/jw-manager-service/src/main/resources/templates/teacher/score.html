<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 导入jquery核心类库 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/jquery-1.8.3.js"></script>
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
	function doAdd() {
		//alert("增加...");
		var rows = $("#grid").datagrid("getSelected");
		if (rows == null) {
			$.messager.alert("提示信息", "请选择一名学生", "warning");
		} else {
			var sid = rows.students.sid;
			var cid = rows.courseId;
			$("#sid").val(sid);
			$("#cid").val(cid);
			$('#addStaffWindow').window("open");
		}
	}
	//工具栏
	var toolbar = [ {
		id : 'button-add',
		text : '增加成绩',
		iconCls : 'icon-add',
		handler : doAdd
	}];
	// 定义列
	var columns = [ [ {
		field : 'id',
		title : '编号',
		width : 100,
		checkbox : true
	}, {
		field : 'collegeName',
		title : '所属学院',
		width : 120,
		align : 'center',
		formatter : function(data, row, index) {
			return row.students.classes.tSpecialty.college.name;
		}
	}, {
		field : 'class',
		title : '所属专业',
		width : 120,
		align : 'center',
		formatter : function(data, row, index) {
			return row.students.classes.tSpecialty.name;
		}
	}, {
		field : 'class',
		title : '所属班级',
		width : 120,
		align : 'center',
		formatter : function(data, row, index) {
			return row.students.classes.classname;
		}
	}, {
		field : 'sname',
		title : '学生姓名',
		width : 120,
		align : 'center',
		formatter : function(data, row, index) {
			return row.students.sname;
		}
	}, {
		field : 'absent',
		title : '旷课次数',
		width : 120,
		align : 'center',
		formatter : function(data, row, index) {
			return row.students.absent;
		}
	}, {
		field : 'peaceTime',
		title : '平时成绩',
		width : 120,
		align : 'center'
	}, {
		field : 'endTime',
		title : '期末成绩',
		width : 120,
		align : 'center'
	}, {
		field : 'score',
		title : '总成绩',
		width : 120,
		align : 'center'
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
							pageList : [ 30, 50, 100 ],
							pagination : true,
							singleSelect : true,
							toolbar : toolbar,
							url : "${pageContext.request.contextPath}/score/findTeacherCourseStudent.action",
							idField : 'id',
							columns : columns,
							onDblClickRow : doDblClickRow
						});

		// 添加取派员窗口
		$('#addStaffWindow').window({
			title : '添加专业',
			width : 400,
			modal : true,
			shadow : true,
			closed : true,
			height : 400,
			resizable : false
		});

		$('#editStaffWindow').window({
			title : '修改专业',
			width : 400,
			modal : true,
			shadow : true,
			closed : true,
			height : 400,
			resizable : false
		});

	});

	function doDblClickRow(rowIndex, rowData) {
		$("#editStaffWindow").window("open");
		$("#editSpecialtyForm").form("load", rowData);
	}
</script>
</head>
<body class="easyui-layout" style="visibility: hidden;">
	<div region="center" border="false">
		<table id="grid"></table>
	</div>

	<div class="easyui-window" title="对学院进行添加或者修改" id="addStaffWindow"
		collapsible="false" minimizable="false" maximizable="false"
		style="top: 20px; left: 200px">
		<div region="north" style="height: 31px; overflow: hidden;"
			split="false" border="false">
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="#" class="easyui-linkbutton"
					plain="true">保存</a>
				<script type="text/javascript">
					$("#save").click(function() {
						$("#addScoreForm").submit();
					});
				</script>
			</div>
		</div>

		<div region="center" style="overflow: auto; padding: 5px;"
			border="false">
			<form id="addScoreForm" action="/score/addStudentScore.action" method="post">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">添加成绩</td>
					</tr>
					<input type="hidden" name="studentId" id="sid" />
					<input type="hidden" name="courseId" id="cid" />
					<tr>
						<td>平时成绩</td>
						<td><select name="peacetime" id="peaceTime"
							class="easyui-combobox" style="width: 150px;">
								<option value="" checked="checked">-------请选择--------</option>
								<option value="A+">A+</option>
								<option value="A">A</option>
								<option value="B">B+</option>
								<option value="B">B</option>
								<option value="C+">C+</option>
								<option value="C">C</option>
								<option value="D+">D+</option>
								<option value="D">D</option>
								<option value="F">F</option>
						</select></td>
					</tr>
					<tr>
						<td>期末成绩</td>
						<td><select name="endtime" id="endTime"
							class="easyui-combobox" style="width: 150px;">
								<option value="end" checked="checked">-------请选择--------</option>
								<option value="A+">A+</option>
								<option value="A">A</option>
								<option value="B">B+</option>
								<option value="B">B</option>
								<option value="C+">C+</option>
								<option value="C">C</option>
								<option value="D+">D+</option>
								<option value="D">D</option>
								<option value="F">F</option>
						</select></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

</body>
</html>
