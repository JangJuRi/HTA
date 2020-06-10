<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple Board</title>
<link rel="stylesheet" type="text/css" href="../resources/css/style.css">
<style type="text/css">
	.field-error {
		border: 1px solid red;
	}
</style>
</head>
<body>
<div class="wrapper">
	<div class="navi">
		<%@ include file="../common/navibar.jsp" %>
	</div>
	<div class="header">
		<h1>심플한 커뮤티니 게시판</h1>
	</div>
	<div class="body">
		<%
			String error = request.getParameter("error");
		%>
		
		<%
			if("dup".equals(error)) {
		%>
			<p>이미 사용중인 아이디입니다.</p>
		<%
			} else {
		%>
		<p>사용자 정보를 입력하세요</p>
		<%
			}
		%>
		<div class="well">
			<form id="user-form" method="post" action="register.jsp" onsubmit="checkField(event)">
				<div class="form-group">
					<label>이름</label>
					<div><input type="text" name="name" /></div>
				</div>
				<div class="form-group">
					<label>이메일</label>
					<div><input type="text" name="email" /></div>
				</div>
				<div class="form-group">
					<label>아이디</label>
					<div><input type="text" name="id" /></div>
				</div>
				<div class="form-group">
					<label>비밀번호</label>
					<div><input type="text" name="pwd" /></div>
				</div>
				<div class="text-right">
					<button type="submit">회원가입</button>
				</div>
			</form>
		</div>
	</div>
	<div class="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
</div>
<script type="text/javascript">
	function checkField() {
		clearErrorField();
		
		var nameField = document.querySelector("input[name=name]");
		var emailField = document.querySelector("input[name=email]");
		var idField = document.querySelector("input[name=id]");
		var pwdField = document.querySelector("input[name=pwd]");
		
		var isPassed = true;
		if(!nameField.value) {
			nameField.classList.add("field-error");
			isPassed = false;
		}
		if(!emailField.value) {
			emailField.classList.add("field-error");
			isPassed = false;
		}
		if(!idField.value) {
			idField.classList.add("field-error");
			isPassed = false;
		}
		if(!pwdField.value) {
			pwdField.classList.add("field-error");
			isPassed = false;
		}
		
		if(!isPassed) {
			event.preventDefault();
		}
		
	}
	
	function clearErrorField() {
		var fields = document.querySelectorAll(".form-group input");
		for(var i=0; i<fields.length; i++) {
			var input = fields[i];
			input.classList.remove("field-error");
		}
	}
</script>
</body>
</html>