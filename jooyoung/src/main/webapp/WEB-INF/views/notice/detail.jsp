<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/bootstrap/themes/bootstrap.min.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<%@include file="../include/header.jsp"%>	
<body>
<div class="row">
	<div class="col-md-2">	
	</div>
	
	<div class=" col-md-6">
	<label>${vo.title}</label>
	
	<div class="form-group">
		<label>내용</label>
		<textarea name="content" rows="5"
			readonly="readonly" class="form-control">${vo.content}</textarea>
	</div>
	
	<div class="form-group">
		<label>작성자</label>
		<input type="text" class="form-control" value="${vo.nickname}"
		readonly="readonly" />
	</div>
	
	<div class="box-footer">
	<c:if test = "${user.id == 'admin'}">
	<button class="btn btn-warning" id="updatebtn">수정</button>
	<button class="btn btn-danger" id="deletebtn">삭제</button>
	</c:if>
	<button class="btn btn-primary" id="listbtn">목록</button><br/>
	
	</div>
	
	
	</div>
	<div class="col-md-4">
			 <%@include file="../include/login.jsp"%>	
		</div>
		
</div>	

	 <!-- 삭제 대화상자 영역 -->
<c:if test="${user.id == vo.id}">
	<link rel="stylesheet"
		href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

	<div id="dialog-confirm" title="정말로 삭제?" style="display: none">
		<p>삭제하시면 복구할 수 없습니다. 그래도 삭제하실 건가요?</p>
	</div>
</c:if>

<!-- 댓글 작성 및 수정 대화상자 영역 -->
	<div class="box-body" style="display:none" id="replyform">
		<label for="nickname">작성자</label>
		<input class="form-control" type="text" id="nickname"
		value="${user.nickname}" readonly="readonly" />
		<label for="replytext">댓글내용</label>
		<input type="text" class="form-control" id="replytext"
		placeholder="댓글 내용을 작성하세요!" />
	</div>

		
</body>
<script>
id = "${user.id}";

//목록보기 버튼 눌렀을때 처리
document.getElementById("listbtn").addEventListener("click", function(){
		location.href="notice?page=${criteria.page}&perPageNum=${criteria.perPageNum}";
	});
	
	
	
<c:if test = "${user.id == 'admin'}">
//삭제 버튼을 눌렀을 때 처리
document.getElementById("deletebtn").addEventListener(
	"click", function(){
	$("#dialog-confirm").dialog({
	      resizable: false,
	      height: "auto",
	      width: 400,
	      modal: true,
	      buttons: {
	        "삭제": function() {
	          $(this).dialog("close");
	          location.href="delete?nno=${vo.nno}";
	        },
	        "취소": function() {
	          $(this).dialog("close");
	        }
	      }
	    });
				
});
//수정 버튼 눌렀을 떄
document.getElementById("updatebtn").addEventListener("click", function(){
	location.href="update?nno=" + ${vo.nno} + "&page=${criteria.page}&perPageNum=${criteria.perPageNum}";
});
</c:if>
	
</script>
</html>