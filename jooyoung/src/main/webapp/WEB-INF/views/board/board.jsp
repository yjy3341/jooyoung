 q<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- <style type="text/css">
	body{
		background-color: @gray-darker: lighten(#000, 13.5%);
		}
</style> -->
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
			<c:if test="${user != null }">
			<div class="box">
			<div class="box-header with-border">
				<a href="${pageContext.request.contextPath}/board/register"><h3 class="box-title">영화추천 작성</h3></a>
			</div>

			</div>
			</c:if>
			
			<div class="box-body">
				<table class="table table-hover">
				<c:forEach var="vo" items="${map.list}">
			
				 <tr>
					<td rowspan="3">
					<a href="detail?bno=${vo.bno}&page=${map.pageMaker.criteria.page}&perPageNum=${map.pageMaker.criteria.perPageNum}
						&searchType=${map.pageMaker.criteria.searchType}&keyword=${map.pageMaker.criteria.keyword}">
							<img src="${pageContext.request.contextPath}/image/${vo.image}" width="200" height="150"/> 
							</a>
					</td> 	
					<!-- 상세보기 링크: 상세보기 한 후 이전 목록으로 돌아가도록 할려면
						현재 페이지 번호와 페이지당 출력개수를 가지고 가야 합니다. -->
					<td align="left">
						<a href="detail?bno=${vo.bno}&page=${map.pageMaker.criteria.page}&perPageNum=${map.pageMaker.criteria.perPageNum}
						&searchType=${map.pageMaker.criteria.searchType}&keyword=${map.pageMaker.criteria.keyword}">${vo.title}&nbsp;&nbsp;
						<span class="badge badge-danger">${vo.readcnt}</span></a>
					</td>
					<td>
						장르 : ${vo.genre}
					</td>
				</tr>
				
						<tr>
							<td>작성자 : &nbsp;${vo.nickname}</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${vo.dispDate}</td>
							
						</tr>
						<tr>
							<td>
								<button class="btn btn-info" id="reviewbtn">리뷰보기</button>
							</td>
						</tr>
					
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
						"board?page=${map.pageMaker.startPage-1}&perPageNum=${map.pageMaker.criteria.perPageNum}
						&searchType=${map.pageMaker.criteria.searchType}&keyword=${map.pageMaker.criteria.keyword}">이전</a></li>
					</c:if>		
					<!-- 페이지 번호 -->
					<c:forEach var="idx" 
						begin="${map.pageMaker.startPage}" 
						end="${map.pageMaker.endPage}">
						<li class="page-item active"><a class="page-link" href="board?page=${idx}&perPageNum=${map.pageMaker.criteria.perPageNum}
						&searchType=${map.pageMaker.criteria.searchType}&keyword=${map.pageMaker.criteria.keyword}">${idx}</a></li>
					</c:forEach>
					<!-- 다음 링크 -->
					<c:if test="${map.pageMaker.next}">
						<li class="page-item"><a class="page-link" href="board?page=${map.pageMaker.endPage+1}&perPageNum=${map.pageMaker.criteria.perPageNum}
						&searchType=${map.pageMaker.criteria.searchType}&keyword=${map.pageMaker.criteria.keyword}">다음</a></li>
					</c:if>				
		 	 	</c:if>  
			</ul>
		</div>
		
		<!-- 검색창 -->
		<div class="box-body text-center">
			<select name="searchType" id="searchType">
				<option value="n"
		 			<c:out value="${map.pageMaker.criteria.searchType==null?'selected':''}"/>
				>--</option>

				<option value="t"
					 <c:out value="${map.pageMaker.criteria.searchType=='t'?'selected':''}"/>
				>제목</option> 
	
				<option value="c"
					 <c:out value="${map.pageMaker.criteria.searchType=='c'?'selected':''}"/>
				>내용</option>
				
				<option value="tc"
					 <c:out value="${map.pageMaker.criteria.searchType=='tc'?'selected':''}"/>
				>제목+내용</option>  
			</select>

			<input type="text" name="keyword" id="keyword" value="${map.pageMaker.criteria.keyword}"/>
			<input type="button" class="btn btn-warning" value="검색" id="searchBtn"/>	
		</div>
	
			</div>
			
			<div class="col-md-4">
			 <%@include file="../include/login.jsp"%>	
		</div>
		
	 </div> 

	 
<!-- 	 <div class="box-body" style="display:none" id="review">
	 	
		<label for="nickname">작성자</label>
		<input class="form-control" type="text" id="nickname" value="zz" readonly="readonly" />
		<label for="replytext">댓글내용</label>
		<input type="text" class="form-control" id="replytext"
		placeholder="댓글 내용을 작성하세요!" />
	</div> -->

</body>
<script>

//검색 버튼 클릭시 수행
$('#searchBtn').on("click", function(event){
	var searchType = $("select[name=searchType]").val();
	var keyword = $("input[name=keyword]").val();
	
	location.href =
		"board?page=1&perPageNum=${map.pageMaker.criteria.perPageNum}"
		+ "&searchType=" + searchType + "&keyword=" + keyword;
});


/* //리뷰보기 버튼 눌렀을 때
document.getElementById("reviewbtn").addEventListener(
		"click", function(){
			$.ajax({
				url:"../review/register",
				data:{
					"bno" : '${vo.bno}'
				},
				dataType:"json",
				success:function(data){
 					//댓글을 출력하는 함수를 호출
					getReview();
				}
			})
			$("#reviewform").dialog({
			      resizable: false,
			      height: "auto",
			      width: 600,
			      modal: true,
			      buttons: {
				        "취소": function() {
				          $(this).dialog("close");
				        }
				      }
			    });
						
	});

//리뷰 목록 가져오는 함수
function getReview(){
	$.ajax({
		url:"../review/review",
		data:{"bno" : '${vo.bno}'},
		dataType:"json",
		success:function(data){
			//출력 내용을 저장할 변수
			disp = '';
			//data 배열을 순회 - idx는 인덱스이고 item은 실제 내용
			$(data).each(function(idx, itemm){
				disp += "<br>";
				disp += "<ul class='list-grop'";
				disp += itemm.nickname;
				disp += "<li class='list-group-item'>" + "zz" + "</li>";
				disp += "<li class='list-group-item'>" + itemm.reviewtext + "</li>";
				
			});
			document.getElementById("reviewdisp").innerHTML = disp;
		}
	})
} */

</script>
</html>