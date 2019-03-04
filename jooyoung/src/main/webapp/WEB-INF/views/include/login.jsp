<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 	<link href="${pageContext.request.contextPath}/resources/bootstrap/themes/bootstrap.min.css" rel="stylesheet" type="text/css" />

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<div class="row">


	
	<div class="col-md-8">

<c:if test="${user == null}">
<div class="card border-primary mb-3" style="max-width: 20rem;">
  <div class="card-header">로그인</div>
  <div class="card-body">
  
<div class="login-box well"><!-- accept-charset="UTF-8"role="form" -->
		<form method="post" action="${pageContext.request.contextPath}/user/login">
						<legend>로그인</legend>
 						<div style='color: red'>${loginmsg}</div>
						<div class="form-group">
							<label for="username-email">아이디</label> 
							<input type="text" name="loginid" id="loginid" required="required" placeholder="아이디를 입력하세요" class="form-control" />
						</div>
						<div class="form-group">
							<label for="password">비밀번호</label>
							<input type="password" name="loginpw" id="loginpw" placeholder="비밀번호를 입력하세요" class="form-control" required="required"/>
						</div>
						
						<div class="form-group">
							<input type="submit" class="btn btn-primary btn-login-submit btn-block m-t-md" value="로그인" />
						</div>
					
	<div class="form-group">
		<a href="${pageContext.request.contextPath}/user/register" class="btn btn-warning btn-block m-t-md">회원가입</a> 
	</div>
	</form>
	 </div>
</div>
</div>
</c:if>





<c:if test="${user != null }">
<div class="card border-primary mb-3" style="max-width: 20rem;">
<div class="card-header">${user.nickname}님 반갑습니다</div>
 <div class="card-body">
 
	 <h4 class="card-title">영화추천사이트에 방문해주셔서 감사합니다.</h4>
	<div class="box-header with-border">
		<a href="${pageContext.request.contextPath}/user/logout"><h3 class="box-title">로그아웃</h3></a>
	</div>
</div>
</div>
</c:if>


</div>


<div class="col-md-4"></div>

</div>
</body>
</html>