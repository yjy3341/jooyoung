<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
 <%@include file="../include/header.jsp"%>
<body>

<div class="row">
<div class=" col-md-2"></div>
			<div class=" col-md-6">
				<section class="box-header">
					<form role="form" method="post">
					<!-- 현재 페이지 번호와 페이지 당 출력 개수 -->
						<input type="hidden" name="page" value="${criteria.page}"/>
						<input type="hidden" name="perPageNum" value="${criteria.perPageNum}"/>
						<!-- 데이터 수정을 할 때 기본키의 값이 있어야 해서 필요하고
						작업이 끝나고 결과 페이지로 이동할 때
						상세보기로 이동하려면 글번호가 필요합니다. -->
						<input type="hidden" name="bno" value="${vo.bno}" />
							<div class="box-body">
								<div class="form-group">
									<label>제목</label> 
									<input type="text" name='title'	class="form-control" value="${vo.title}">
								</div>
								<div class="form-group">
								<label>내용</label>
									<textarea class="form-control" name="content" rows="5">${vo.content}</textarea>
								</div>

								<div class="form-group">
								<label>작성자</label> <input type="text" name="nickname" value="${user.nickname}" class="form-control" readonly="readonly">
								</div>
							</div>

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