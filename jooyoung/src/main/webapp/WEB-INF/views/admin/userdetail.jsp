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
	<div class="col-md-2">	
	<%@include file="../include/page.jsp"%>
	</div>
	
	<div class=" col-md-6">
	
	<div class="form-group">
		<label>아이디</label>
		<input type="text" class="form-control" value="${vo.id}"
		readonly="readonly" />
	</div>
	
	<div class="form-group">
		<label>닉네임</label>
		<input type="text" class="form-control" value="${vo.nickname}"
		readonly="readonly" />
	</div>
	
	<div class="form-group">
		<label>성별</label>
		<input type="text" class="form-control" value="${vo.gender}"
		readonly="readonly" />
	</div>
	
 	<div class="form-group">
		<label>가입한 날짜</label>
		<input type="text" class="form-control" value="${vo.regdate}"
		readonly="readonly" />
	</div> 

	<button class="btn btn-danger" id="deletebtn">회원 추방</button>
	<button class="btn btn-primary" id="listbtn">목록</button>
	
	
	</div>
	
	<div class="col-md-4">
			 <%@include file="../include/login.jsp"%>	
		</div>
</div>

	<c:if test="${user.id == 'admin'}">
	<link rel="stylesheet"
		href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	<div id="dialog-confirm" title="회원 추방" style="display: none">
		<p>추방하시면 복구할 수 없습니다. 그래도 추방하실 건가요?</p>
	</div>
	</c:if>

</body>
<script>
//목록보기 버튼 눌렀을때 처리
document.getElementById("listbtn").addEventListener("click", function(){
		location.href="userlist?page=${criteria.page}&perPageNum=${criteria.perPageNum}";
	});
	
//삭제 버튼을 눌렀을 때 처리
document.getElementById("deletebtn").addEventListener(
	"click", function(){
	$("#dialog-confirm").dialog({
	      resizable: false,
	      height: "auto",
	      width: 400,
	      modal: true,
	      buttons: {
	        "추방": function() {
	          $(this).dialog("close");
	          location.href="userdelete?id=${vo.id}";
	        },
	        "취소": function() {
	          $(this).dialog("close");
	        }
	      }
	    });
				
});
</script>
</html>