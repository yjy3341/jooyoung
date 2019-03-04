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
	
	<div class="col-md-6">
		<section class="content">
			<div class="box-header">
				<h3 class="box-title">게시판 글쓰기</h3>
			</div>
			
			<form role="form" method="post" onsubmit="return chect()">
				<div class="form-group">
					<label>제목 : </label> 
					<input type="text" name='title' class="form-control" placeholder="제목을 입력하세요" required="required">
				</div>
					
				<div class="form-group">
					<label>내용 : </label>
						<textarea class="form-control" name="content" rows="5" 
									  placeholder="내용을 입력하세요" required="required"></textarea>
				</div>
				
				<div class="form-group">
					<label>닉네임 : </label> 
					<input type="text" name="nickname" value="${user.nickname}" 
						   class="form-control" readonly="readonly">
				</div>
				
				<input type="hidden" name="type" id="type" value="notice"/>
			
				<div class="box-footer">
					<button type="submit" class="btn btn-primary">작성완료</button>
				</div>
			</form> 
		</section>
	</div>
	
	
	<div class="col-md-4">
		<%@include file="../include/login.jsp"%>	
	</div>

</div>
</body>
</html>