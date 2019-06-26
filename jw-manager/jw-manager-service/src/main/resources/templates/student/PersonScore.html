<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/styles/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/js/My97DatePicker/skin/WdatePicker.css"
	type="text/css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath }js/formvalidator/style/validator.css" />
<style type="text/css">
table.hovertable {
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
}

table.hovertable th {
	background-color: #c3dde0;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}

table.hovertable tr {
	background-color: #d4e3e5;
}

table.hovertable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
</style>

<script type="text/javascript">
	//工具栏
	var frozenColumns;

	var columns = [ [
			{
				field : 'id',
				hidden : true,//该列隐藏
				formatter : function(value, row, index) {
					//gysypmls对应action接收对象中list的名称，[]括号中是从0开始序号,id是list中对象属性
					return '<input type="hidden" name="gysypmlControls['+index+'].ypxxid" value="'+value+'" />';
				}
			}, {
				field : 'year',
				title : '学年',
				width : 230
			}, {
				field : 'time',
				title : '学期',
				width : 100
			}, {
				field : 'courseId',
				title : '课程代码',
				width : 130
			}, {
				field : 'className',
				title : '课程名称',
				width : 230,
				formatter : function(data, row, index) {
					return row.course.name;
				}
			}, {
				field : 'natureName',
				title : '课程性质',
				formatter : function(data, row, index) {
					return row.course.nature.name;
				}
			}, {
				field : 'course.credit',
				title : '学分',
				width : 80,
				formatter : function(data, row, index) {
					return row.course.credit;
				}
			}, {
				field : 'classroom',
				title : '绩点',
				width : 80,
				formatter : function(data, row, index) {
				}
			}, {
				field : 'score',
				title : '成绩',
				width : 80
			}, {
				field : 'secondScore',
				title : '补考成绩',
				width : 130
			}, {
				field : 'reScore',
				title : '重修成绩',
				width : 130
			}, {
				field : 'collegeName',
				title : '开课学院',
				width : 230,
				formatter : function(data, row, index) {
					return row.students.classes.tSpecialty.college.name;
				}
			} ] ];

	//datagrid加载
	function initGrid() {
		$('#gysypmllist')
				.datagrid(
						{
							striped : true,
							url : '${pageContext.request.contextPath }/score/findStudentScore.action',
							idField : 'courseid',//json数据集的主键
							columns : columns,
							pagination : true,
							rownumbers : true,
							height : 480,
							pageList : [ 15, 30, 50, 100 ],//设置每页显示个数
						});
	}
	$(function() {
		initGrid();

		/* //加载药品类型
		getDictinfoIdlist('001','ypxxCustom_lb','00101');

		//加载交易状态
		getDictinfoCodelist('003','ypxxCustom.jyzt'); */
	});

	//列表查询
	function gysypmlquery() {
		//将form中的数据组成json
		var formdata = $("#gysypmldeleteForm").serializeJson();
		//alert(formdata);
		//取消所有datagrid中的选择
		//$('#gysypmllist').datagrid('unselectAll');
		//json是datagrid需要格式数据，向服务器发送的是key/value
		$('#gysypmllist').datagrid('load', formdata);
	}
</script>
</HEAD>
<BODY>
	<div id="ypxxquery_div">
		<form id="sysuserqueryForm">
			<!-- 查询条件 -->
			<TABLE class="hovertable">
				<TBODY>
					<TR>
						<TD>学年：</td>
						<td><select name="sysuserCustom.groupid">
								<option value=""></option>
								<option value="1">2015-2016</option>
								<option value="2">2016-2017</option>
								<option value="3">2017-2018</option>
						</select></TD>
						<TD>学期：</TD>
						<td><select name="sysuserCustom.groupid">
								<option value=""></option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
						</select></TD>

						<TD>课程性质：</TD>
						<td><select name="sysuserCustom.groupid">
								<option value=""></option>
								<option value="1">公共选修课</option>
								<option value="2">全校性选修课</option>
								<option value="3">公共任选课</option>
								<option value="4">公共必修课</option>
								<option value="0">专业必修课</option>
						</select></TD>
						<td><a id="btn" href="#" onclick="queryuser()"
							class="easyui-linkbutton" iconCls='icon-search'>查询</a></td>
					</TR>


				</TBODY>
			</TABLE>
			<!-- Table goes in the document BODY -->
			<table class="hovertable" width="100%">
				<tr onmouseover="this.style.backgroundColor='#ffff66';"
					onmouseout="this.style.backgroundColor='#d4e3e5';">
					<td colspan="3" align="center" rowspan="2">长沙民政职业技术学院在校成绩</td>
				</tr>
				<tr></tr>
					<tr onmouseover="this.style.backgroundColor='#ffff66';"
						onmouseout="this.style.backgroundColor='#d4e3e5';">
						<td>学号:${PersonStudent.sid }</td>
						<td>姓名:${PersonStudent.sname }
						</td>
						<td>学院:
							<p id="scollege"></p>
						</td>
					</tr>
					<tr onmouseover="this.style.backgroundColor='#ffff66';"
						onmouseout="this.style.backgroundColor='#d4e3e5';">
						<td colspan="2">专业:
							<p id="sspeciatly"></p>
						</td>
						<td>行政班:
							<p id="sclassname"></p>
						</td>
					</tr>
			</table>
			<TABLE border=0 cellSpacing=0 cellPadding=0 width="100%" align=center>
				<TBODY>
					<TR>
						<TD>
							<table id="gysypmllist"></table>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
		</form>
	</div>
</BODY>
</HTML>

