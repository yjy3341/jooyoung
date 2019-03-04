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
	<div class=" col-md-2"></div>
	
	<div class=" col-md-6">
	<c:if test="${user.id == 'admin'}">
		<div class="box">
			<div class="box-header with-border">
				<a href="${pageContext.request.contextPath}/notice/register"><h3 class="box-title">공지사항 작성</h3></a>
			</div>
		</div>
	</c:if>
	
		<div class="box-body">
			<table class="table table-hover">
				<tr>
					<th width="11%">공지</th>
					<th width="46%">제목</th>
					<th width="16%">작성자</th>
					<th width="16%">작성일</th>
					<th width="11%">조회수</th>
				</tr>
				
				<c:forEach var="ad" items="${map.list}">
				
				<tr>
				<td align="center"><공지></공지>
				<td><a href="detail?nno=${ad.nno}&page=${map.pageMaker.criteria.page}&perPageNum=${map.pageMaker.criteria.perPageNum}">
				&nbsp;${ad.title}
				</a></td>
				<td>&nbsp;${ad.nickname}</td>
				<td>&nbsp;${ad.dispDate}</td>
				<td align="right">${ad.readcnt}</td>
				
				</c:forEach>
				
			</table>
		</div>
		
				<!-- 페이지 번호 출력 영역 -->
		<div class="box-footer text-center">
			<ul class="pagination pagination-lg">
			
				 <c:if test="${map.pageMaker.totalCount > 0 }"> 
					<!-- 이전 링크 -->
					<c:if test="${map.pageMaker.prev}">
						<li class="page-item disabled"><a class="page-link" href=
						"notice?page=${map.pageMaker.startPage-1}&perPageNum=${map.pageMaker.criteria.perPageNum}">이전</a></li>
					</c:if>		
					<!-- 페이지 번호 -->
					<c:forEach var="idx" 
						begin="${map.pageMaker.startPage}" 
						end="${map.pageMaker.endPage}">
						<li class="page-item active"><a class="page-link" href="notice?page=${idx}&perPageNum=${map.pageMaker.criteria.perPageNum}">${idx}</a></li>
					</c:forEach>
					<!-- 다음 링크 -->
					<c:if test="${map.pageMaker.next}">
						<li class="page-item"><a class="page-link" href="notice?page=${map.pageMaker.endPage+1}&perPageNum=${map.pageMaker.criteria.perPageNum}">다음</a></li>
					</c:if>				
		 	 	</c:if>  
			</ul>
		</div>
		
	</div>
	<div class="col-md-4">
		 <%@include file="../include/login.jsp"%>	
	</div>
		

</div>

</body>
<script>

</script>
</html>