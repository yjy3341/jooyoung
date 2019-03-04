<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<%@include file="../include/header.jsp"%>	
<body>
<div class="row">
<div class="col-md-2">
	</div>
	
<div class=" col-md-6">
<form action="register" method="post" onsubmit="return check()">
	 	<h3 class="text-center">회원가입</h3>
	 	
		<div class="form-group">
			<label for="exampleInputId">아이디 : </label>
			<input type="text" onblur="confirmId()" class="form-control" id="id" name="id" placeholder="아이디를 입력하세요" required="required">
		</div>
		<div id="iddiv"></div>
		
		<div class="form-group">
			<label for="password">비밀번호 : </label>
			<input type="password" name="pw" id="pw" placeholder="비밀번호를 입력하세요" class="form-control" required="required">
		</div>
		
		<div class="form-group">
		<label for="exampleInputPassword1">비밀번호 확인: </label> 
			<input type="password" class="form-control" id="pwconfirm" placeholder="비밀번호를 입력하세요">
		</div>
		
		<div class="form-group">
			<label for="exampleInputPassword1">이름:</label> 
			<input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력하세요">
		</div>		
		
		<div class="form-group">
			<label>성별</label><br/>
				<input type="radio" id="gender" name="gender" value="남자" checked="checked"/>남자<br/>
				<input type="radio" id="gender" name="gender" value="여자"/>여자<br/>
		</div>	
		
		<div class="form-group">
			<label for="exampleInputEmail1">닉네임:</label> 
			<input type="text" onblur="confirmNickname()" class="form-control" id="nickname" name="nickname" placeholder="닉네임을 입력하세요"  required="required">
		</div>
		<div id="nicknamediv"></div>	
		<div class="form-group">
			<input type="submit" class="btn btn-primary btn-login-submit btn-block m-t-md" value="작성 완료" id="register"/>
		</div>
		
		<!-- 권한 구별 -->
		<!-- <input type="hidden" id="authority" name="authority" value=0>  -->
		
	</form>
	</div>
	<div class="col-md-4">
		<%@include file="../include/login.jsp"%>	
	</div>
	</div>
	
</body> 
<script
	src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js">
</script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
//id,nickname 중복 검사 통과 여부를 저장할 변수
var idcheck = false;
var nicknamecheck = false;


//id 중복체크 위한 함수
function confirmId() {
	//id에 입력된 값 가져오기 
	val = document.getElementById("id").value;
	//메시지 출력 영역 가져오기
	iddiv = document.getElementById("iddiv");
	$.ajax({
		url : 'idcheck',
		data : {'id' : val},
		dataType : 'json',
		success : function(data) {				
			if (data.result == true) {
				iddiv.innerHTML = "사용 가능한 아이디";
				iddiv.style.color = 'blue';
				idcheck = true;
			}
			//id중복
			else  {
				iddiv.innerHTML = "사용 불가능한 아이디";
				iddiv.style.color = 'red';
				idcheck = false;
			}
		}
	});
}

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
	//idcheck 의 값이 false 이면 서버로 전송하지 않도록
	if (idcheck == false) {
		alert("아이디를 입력해야 합니다.")
		/* document.getElementById("iddiv").innerHTML = "id 를 입력해야 합니다.";
		document.getElementById("iddiv").style.color = 'red'; */
		document.getElementById("id").focus();
		return false;
	}
	
	//nicknamecheck 의 값이 false 이면 서버로 전송하지 않도록
	if (nicknamecheck == false) {
		alert("닉네임을 입력해야 합니다.")
		/* document.getElementById("nicknamediv").innerHTML = "nickname 를 입력해야 합니다.";
		document.getElementById("nicknamediv").style.color = 'red'; */
		document.getElementById("nickname").focus();
		return false;
	}
	
	var id = document.getElementById("id");
	if (id.value.indexOf(" ") >= 0) {
        alert("아이디에 공백을 사용할 수 없습니다.")
       id.focus();
        return false;
    }
	
	var name = document.getElementById("name");
	if(name.value == ""){
		alert("이름을 입력하셔야 합니다.")
		name.focus();
		return false;
	}
	
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
	//비밀번호는 숫자, 영문자, 특수문자 1개이상으로 8자 이상
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

