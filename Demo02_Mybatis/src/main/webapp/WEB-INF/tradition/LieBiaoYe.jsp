<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- el表达式出问题 -->
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ "/" + path;
%>
<html>
<head>
<meta charset="UTF-8">
<title>列表页</title>

<link href="<%=basePath%>/jqueryUi/jquery-ui.css" rel="stylesheet">
<script src="<%=basePath%>/jqueryUi/external/jquery/jquery.js"></script>
<script src="<%=basePath%>/jqueryUi/jquery-ui.js"></script>

<link href="<%=basePath%>/css/LieBiaoYe.css" rel="stylesheet">
</head>

<script type="text/javascript">
	$(function() {
		$( "button" ).button();
	});
	
	function commit(f) {
		if(2==f){
			$("#c1").val("");
			$("#c2").val("");
		}
		$("form").submit();
	}
</script>

<body>
	<!-- 检索用参数 -->
	<div>
		<form action="<%=basePath%>/LieBiaoYe" method="post">
			<table>
				<tr>
					<td><span class="ui-icon ui-icon-search"></span></td>
				</tr>
				<tr>
					<td><label>ID:</label></td>
					<td><input id="c1" name="c1" type="text" value="${c1}" /></td>
				</tr>
				<tr>
					<td><label>Or</label></td>
				</tr>
				<tr>
					<td><label>VALUE:</label></td>
					<td><input id="c2" name="c2" type="text" value="${c2}" /></td>
				</tr>
				<tr>
					<td><input type="button" value="查询" id="button1" onclick="commit(1);"/></td>
					<td><input type="button" value="清除" id="button2" onclick="commit(2);"/></td>
				</tr>
			</table>
		</form>
	</div>
	<hr>
	
	<!-- 显示用模块 -->
	<div style="width: 300px;">
		<div>
			<table class="data">
				<thead class="data-head">
					<tr>
						<th style="width: 33%;">INDEX</th>
						<th style="width: 33%;">ID</th>
						<th style="width: 33%;">VALUE</th>
					</tr>
				</thead>
			</table>
		</div>
		<div style="height: 300px; overflow: auto;">
			<table class="data">
				<tbody class="data-list">
					<c:forEach items="${data}" var="tmp" varStatus="status">
						<tr>
							<td style="width: 33%;">${status.index +1}</td>
							<td style="width: 33%;">${tmp.c1}</td>
							<td style="width: 33%;">${tmp.c2}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>