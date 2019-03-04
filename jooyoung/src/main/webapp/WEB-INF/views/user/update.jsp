<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link href="${pageContext.request.contextPath}/resources/bootstrap/themes/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<%@include file="../include/header.jsp"%>	
<body>
<div class="row">
	<div class=" col-md-2">
		<%@include file="../include/page.jsp"%>
	</div>
	
	<div class=" col-md-6">
	<h3 class="text-center">회원정보 수정</h3>
	<form action="update" method="post" onsubmit="return check()">
	<div class="form-group">
	<fieldset disabled="">
			<label for="exampleInputId">아이디 : </label>
			<input type="text" class="form-control" id="id" name="id" value="${user.id}">
	</fieldset>	
		</div>
	
	
	<div class="form-group">
			<label for="password">비밀번호 : </label>
			<input type="password" name="pw" id="pw" placeholder="비밀번호를 입력하세요" class="form-control" required="required">
		</div>
		
	<div class="form-group">
	<label for="exampleInputPassword1">비밀번호 확인: </label> 
		<input type="password" class="form-control" id="pwconfirm" placeholder="비밀번호를 입력하세요">
	</div>
	

	
	<div class="form-group">
		<input type="submit" class="btn btn-primary btn-login-submit btn-block m-t-md" value="작성 완료" />
	</div> 
	</form>
	</div>
	
	<div class="col-md-4">
		 <%@include file="../include/login.jsp"%>	
	</div>
		
		
</div>
</body>
<script>
//nickname 중복 검사 통과 여부 변수
var nicknamecheck = false;

//nickname 중복체크 위한 함수
function confirmNickname() {
	//nickname에 입력된 값 가져오기 
	val1 = document.getElementById("nickname").value;
	//메시지 출력 영역 가져오기
	nicknamediv = document.getElementById("nicknamediv");
	$.ajax({
		url : 'nicknamecheck',
		data : {'nickname' : val1},
		dataType : 'json',
		success : function(data) {				
			if (data.result == true) {
				nicknamediv.innerHTML = "사용 가능한 닉네임";
				nicknamediv.style.color = 'blue';
				nicknamecheck = true;
			}
			//닉네임중복
			else  {
				nicknamediv.innerHTML = "사용 불가능한 닉네임";
				nicknamediv.style.color = 'red';
				nicknamecheck = false;
			}
		}
	});
}

function check() {
	
	
	//비밀번호에 입력한 값과 비밀번호 확인에 입력한 값이
	//일치하지 않으면 서버로 전송하지 않도록
	var pw = document.getElementById("pw");
	var pwconfirm = document.getElementById("pwconfirm");
	if (pw.value != pwconfirm.value) {
		alert("두 개의 비밀번호는 일치해야 합니다.");
		pw.focus();
		return false;
	}

	if (pw.value == ""){
		alert("비밀번호를 입력하셔야 합니다.");
		pw.focus();
		return false;
	}
	//비밀번호는 숫자, 영문자, 특수문자 1개이상으로 5자 이상
	//만들어졌는지 검사
	//정규식 이용 - 숫자, 영문자, 특수문자
	var p1 = /[0-9]/;
	var p2 = /[a-zA-Z]/;
	//var p3 = /[~!@#$%^&*()]/;
	if (!p1.test(pw.value) || !p2.test(pw.value) || pw.value.length < 5) {
		alert("비밀번호는 5자이상 숫자, 영문자를 포함해야 합니다.");
		pw.focus();
		return false;
	}
}
</script>
</html>