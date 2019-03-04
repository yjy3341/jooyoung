<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<!-- jQuery 설정 -->
 <script src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/bootstrap/themes/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
	


<body>
	<a href="${pageContext.request.contextPath}/user/update" class="btn btn-link">비밀번호 변경</a><br>
	<button class="btn btn-link" id="delete">회원 탈퇴</button>



	
	<div id="dialog-confirm" title="정말로 삭제?" style="display: none">
		<p>삭제하시면 복구할 수 없습니다. 그래도 삭제하실 건가요?</p>
	</div>



</body>
<script>
//댓글 작성 버튼을 눌렀을 때 수행할 내용
document.getElementById("delete").addEventListener(
	"click", function(){
	$('#dialog-confirm').dialog({
		resizable:false,
		height:'auto',
		width:400,
		model:true,
		buttons:{
			"탈퇴":function(){
				$(this).dialog("close");
				$.ajax({
					url:"../user/delete",
					data:{
						"id":'${user.id}'
					},
					dataType:"json",
					success:function(data){
							location.href="${pageContext.request.contextPath}/";
					}
				});
			},
			"취소":function(){
				$(this).dialog("close");
			}
		}
	});
});
</script>
</html>