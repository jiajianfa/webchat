<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>首页</title>
		<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
	</head>
	<body>
		<div>
			<div>
				<h2>
					用户列表
				</h2>
			</div>
			<div id="userList"></div>
		</div>

		<div>
			<div>
				<h2>
					消息列表
				</h2>
			</div>
			<div id="messageList"></div>
		</div>

		<div>
			<input type="text" id="message" />
			<input type="button" value="发送" onclick="subMsg();" />
		</div>
	</body>
</html>
<script type="text/javascript">
function handlerContent(content) {
	eval('var c=' + content);
	if(c.users){
		var html;
		html = '<ul>';
		for(var u in c.users){
			html += '<li>';
			html += c.users[u];
			html += '</li>';
		}
		html += '</ul>';
		$('#userList').html(html);
	}
	
	if(c.messages){
		var html;
		html = '<ul>';
		for(var m in c.messages){
			html += '<li>';
			html += c.messages[m];
			html += '</li>';
		}
		html += '</ul>';
		$('#messageList').html(html);
	}
}

function subMsg() {
	$.post('SendMessage', {
		'message' : $('#message').val()
	}, function(content) {
		handlerContent(content);
	});
	$('#message').val('');
}
function init() {
	$.post('Initialization', function(content) {
		handlerContent(content);
		refreshUserList();
	});
}
function refreshUserList() {
	$.post('RefreshUserList', function(content) {
		handlerContent(content);
		refreshUserList();
	});
}

window.onload = init();
</script>
