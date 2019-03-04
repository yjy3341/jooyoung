 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title></title>
<!--  <link href="css/bootstrap.min.css" rel="stylesheet"> -->

	<!-- jQuery 설정 -->
<script src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
	<!-- 부트스트랩 스타일시트 파일 링크 설정 contextPath는 절대 경로를 만들기 위해서 추가 -->
 	<link href="${pageContext.request.contextPath}/resources/bootstrap/themes/bootstrap.min.css" rel="stylesheet" type="text/css" />
 	<!-- 부트스트랩 스타일시트 파일 링크 설정
contextPath는 절대 경로를 만들기 위해서 추가 -->	
<%-- <link
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" /> --%>
	  <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>

 <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
<div class="jumbotron">
<h1 class="display-3">영화 추천 사이트	</h1>
</div>
</nav>

 <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
<div class="collapse navbar-collapse" id="navbarColor02">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <h2><a class="nav-link" href="${pageContext.request.contextPath}/">메인&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></h2>
      </li>
      <li class="nav-item">
       <h2><a class="nav-link" href="${pageContext.request.contextPath}/board/board">영화추천&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></h2>
      </li>

	  <li class="nav-item">
       <h2> <a class="nav-link" href="${pageContext.request.contextPath}/notice/notice">
       		공지사항&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></h2>
      </li>
      <c:if test = "${user != null}">
      <c:if test = "${user.id != 'admin'}">
      <li class="nav-item">
       <h2> <a id="mypage" class="nav-link" href="${pageContext.request.contextPath}/user/update">
       		회원 정보 수정</a></h2>
      </li>
      </c:if>
      </c:if>
      
      <c:if test = "${user.id == 'admin'}">
      <li class="nav-item">
       <h2> <a class="nav-link" href="${pageContext.request.contextPath}/admin/userlist">
       		회원관리</a></h2>
      </li>
      </c:if>

    </ul>
  </div>
    
</nav>
</body>
</html>


