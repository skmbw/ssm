<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
<script type="text/javascript" src="${ctx}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/bootstrap/js/modal.js"></script>
<link rel="stylesheet" href="${ctx}/bootstrap/css/bootstrap.min.css">
<script type="text/javascript">
	function deleteUser(id) {
		var del = confirm('你确定要删除该用户？');
		if (del) {
			$.ajax({
	            type:"post",
	            dataType:"text",
	            url: '${ctx}/user/delete.htm?id=' + id,
	            success: function(msg){
	                //$('#modalAlter').modal('show');
	                window.location.reload();
	            },
	            error: function (msg) {
	                alert(msg.responseText);
	            }
	        });
		}
	}
	$(document).ready(function(){
		$('#add_user').click(function(){
			window.location.href="${ctx}/user/add.htm";
		});
	});
</script>
</head>
<body>
<div class="container">
<div class="row" style="margin-top:20px; margin-bottom:20px;">
	<button type="button" id="add_user" class="btn btn-primary">新增用户</button>
<!-- <table> -->
<%-- 	<tr><td><a href="${ctx}/user/add.htm">新增用户</a></td><td></td><td></td></tr> --%>
<!-- </table> -->
</div>
<div class="row">
<table class="table table-bordered table-hover table-condensed" >
<tr>
<td>用户ID</td>
<td>用户名</td>
<td>用户账户</td>
<td>用户电话</td>
<td>注册时间</td>
<td>权限</td>
<td>操作</td>
</tr>
<c:forEach items="${userList}" var="user" varStatus="i">
<tr style="${i.count%2==0?'background:#f3f3f3':''}">
<td>${user.id}</td>
<td>${user.userName}</td>
<td>${user.userAccount}</td>
<td>${user.telephone}</td>
<td><fmt:formatDate value="${user.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
<td>${user.superAdmin}</td>
<td><a href="${ctx}/user/detail.htm?id=${user.id}">详情</a> <a href="${ctx}/user/edit.htm?id=${user.id}">编辑</a> <a href="javascript:void(0);" onclick="javascript:deleteUser('${user.id}');">删除</a></td>
</tr>

</c:forEach>
</table>
</div>

</div>

<div id="modalAlter" class="modal hide fade in" style="display: none; ">
	<div class="modal-header">
		<a class="close" data-dismiss="modal">×</a>
		<h3>温馨提示您：</h3>
	</div>
	<div class="modal-body">
		<h4>Text in a modal</h4>
		<p>You can add some text here.</p>		        
	</div>
	<div class="modal-footer">
		<a href="#" class="btn btn-success">Call to action</a>
		<a href="#" class="btn" data-dismiss="modal">Close</a>
	</div>
</div>
</body>
</html>