<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<!-- 부트스트랩 스타일시트 파일 링크 설정 contextPath는 절대 경로를 만들기 위해서 추가 -->
<%--  <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" /> --%>
  	<link href="${pageContext.request.contextPath}/resources/bootstrap/themes/bootstrap.min.css" rel="stylesheet" type="text/css" />

		<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<%@include file="include/header.jsp"%>	
	<body>


		<div class="row">
			<div class=" col-md-4">
				<div class="jumbotron">
  <h1 class="display-3">개발환경</h1>
  <p class="lead">운영체제: Windows7<br/>
  				    데이터베이스: Oracle<br/>
  				    프로그래밍 언어: Java 1.8, JavaScript<br/>
  				  WAS: Tomcat 8<br/>
  				  Framework: Spring(Java), MyBatis(Java – Oracle)<br/>
  				  Library: jquery, bootstrap.js<br/>
  				  IDE: STS(Java), sql developer(Oracle), Ex-ERD<br/>
  			   	    빌드도구: Maven<br/>
  				    형상(버전)관리도구: Git Hub </p>
  <hr class="my-4">
</div>	
		</div>
		
		
			<div class=" col-md-4">
			</div>

			<div class="col-md-4">
			 <%@include file="include/login.jsp"%>	
		</div>
	 
	 </div> 
	 
	 <c:if test="${registermsg != null }">
		 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
 		 <link rel="stylesheet" href="/resources/demos/style.css">
  		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  		<script>
 		 $( function() {
   			 $( "#dialog-message" ).dialog({
     			modal: true,
      			buttons: {
     			Ok: function() {
       		   $( this ).dialog( "close" );
      			}
     		 }
    		});
		  });
 	 </script>

	<body>
 
	<div id="dialog-message" title="회원가입 성공">
 		 <p>
   	 <span class="ui-icon ui-icon-circle-check" style="float:left; margin:0 7px 50px 0;"></span>
	회원가입에 성공하셨습니다.
  </p>
</div>
</c:if>

	 <c:if test="${updatemsg != null }">
		 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
 		 <link rel="stylesheet" href="/resources/demos/style.css">
  		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  		<script>
 		 $( function() {
   			 $( "#dialog-message" ).dialog({
     			modal: true,
      			buttons: {
     			Ok: function() {
       		   $( this ).dialog( "close" );
      			}
     		 }
    		});
		  });
 	 </script>

	<body>
 
	<div id="dialog-message" title="비밀번호 수정 성공">
 		 <p>
   	 <span class="ui-icon ui-icon-circle-check" style="float:left; margin:0 7px 50px 0;"></span>
	비밀번호 수정이 완료되었습니다.
  </p>
</div>
</c:if>

</body>

 </html>

