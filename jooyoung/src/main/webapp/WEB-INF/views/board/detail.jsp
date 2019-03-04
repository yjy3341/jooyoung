<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 	<link href="${pageContext.request.contextPath}/resources/bootstrap/themes/bootstrap.min.css" rel="stylesheet" type="text/css" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script> -->
	<!-- jQuery 설정 -->
 <script src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
		<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<%@include file="../include/header.jsp"%>	
<body>

<div class="row">
	<div class="col-md-2">	
		</div>
		
			<div class=" col-md-6">
			
			<div class="form-group">
			<img src="${pageContext.request.contextPath}/image/${vo.image}" width="200" height="250"> 
				<label>${vo.title}</label>
				
			
			</div>
			<div class="form-group">
				<label>장르</label>
				<input type="text" name="title" class="form-control" value="코미디" readonly="readonly"/>
			</div>
			<div class="form-group">
				<label>내용</label>
				<textarea name="content" rows="5"
					readonly="readonly" class="form-control">${vo.content}</textarea>
			</div>
				
			<div class="form-group">
				<label>작성자</label>
				<input type="text" 
				class="form-control" value="${vo.nickname}"
				readonly="readonly" />
				</div>
				
			<div class="box-footer">
			<c:if test = "${user.id == vo.id}">
			<button class="btn btn-warning" id="updatebtn">수정</button>
			<button class="btn btn-danger" id="deletebtn">삭제</button>
			</c:if>
			
			<c:if test = "${user != null }">
			<button class="btn btn-info" id="replyadd">댓글작성</button>
		 	<button class="btn btn-info" id="reviewadd">리뷰작성</button>
		 	</c:if>
			<button class="btn btn-primary" id="listbtn">목록</button><br>

			<div class="container">
				<ul class="nav nav-tabs">
 					<li class="nav-item">
   						<a class="nav-link active" data-toggle="tab" href="#home" id="rep">댓글 보기</a>
 					</li>
					<li class="nav-item">
   						<a class="nav-link" data-toggle="tab" href="#profile" id="rev">리뷰 보기</a>
 					</li>
				</ul>
				
			<div id="myTabContent" class="tab-content">
  				<div class="tab-pane fade active show" id="home">
  				<!--  댓글 출력 영역 -->
 					 <div id="replydisp"></div>
  				</div>
  				<div class="tab-pane fade active show" id="profile">
  					<!--  리뷰 출력 영역 -->
  					<div id="reviewdisp"></div> 
 				</div>
			</div>
			</div>
			</div>
		</div> 
			<div class="col-md-4">
			 <%@include file="../include/login.jsp"%>	
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

	<!-- 리뷰 작성 및 수정 대화상자 영역 -->
	<div class="box-body" style="display:none" id="reviewform">
		<label for="nickname">작성자</label>
  		<input type="radio" name="rating" id="rating" value="1"/>★☆☆☆☆<!-- <span id="1" class="starR on"> --><!-- <input type="hidden" value="1"/></span> -->
 		<input type="radio" name="rating" id="rating" value="2"/>★★☆☆☆<!-- <span id="2" class="starR"><input type="hidden" value="2"/></span> -->
  		<input type="radio" name="rating" id="rating" value="3"/>★★★☆☆<!-- <span id="3" class="starR"><input type="hidden" value="3"/></span> -->
 		<input type="radio" name="rating" id="rating" value="4"/>★★★★☆<!-- <span id="4" class="starR"><input type="hidden" value="4"/></span> -->
 		<input type="radio" name="rating" id="rating" value="5"/>★★★★★<!-- <span id="5" class="starR"><input type="hidden" value="5"/></span> -->
		
		<label for="replytext">리뷰내용</label>
		<input type="text" class="form-control" id="reviewtext"
		placeholder="댓글 내용을 작성하세요!" />
		</div>	
		
	</div>
	
</body>

<script>
id = "${user.id}";

document.getElementById("rep").addEventListener("click", function(){
	getReply(); 
});

document.getElementById("rev").addEventListener("click", function(){
	getReview();
});

	
//목록보기 버튼 눌렀을때 처리
document.getElementById("listbtn").addEventListener("click", function(){
		location.href="board?page=${criteria.page}&perPageNum=${criteria.perPageNum}";
	});
	
<c:if test = "${user.id == vo.id}">
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
	          location.href="delete?bno=${vo.bno}";
	        },
	        "취소": function() {
	          $(this).dialog("close");
	        }
	      }
	    });
				
});
//수정 버튼 눌렀을 떄
document.getElementById("updatebtn").addEventListener("click", function(){
	location.href="update?bno=" + ${vo.bno} + "&page=${criteria.page}&perPageNum=${criteria.perPageNum}";
});
</c:if>

//댓글 작성 버튼을 눌렀을 때 수행할 내용
document.getElementById("replyadd").addEventListener(
	"click", function(){
	$('#replyform').dialog({
		resizable:false,
		height:'auto',
		width:400,
		model:true,
		buttons:{
			"저장":function(){
				$(this).dialog("close");
				//입력한 내용 가져오기
				replytext = document.getElementById("replytext").value;
				$.ajax({
					url:"../reply/register",
					data:{
						"bno":'${vo.bno}',
						"id":'${user.id}',
						"nickname":'${user.nickname}',
						"replytext": replytext
					},
					dataType:"json",
					success:function(data){
						//댓글 출력하는 함수
						getReply();
					}
				});
			},
			"취소":function(){
				$(this).dialog("close");
			}
		}
	});
});

 function getReply(){
	//댓글 목록을 가져오는 ajax 요청
	$.ajax({
		url: "../reply/reply",
		data:{"bno":'${vo.bno}'},
 		dataType:"json",  
		success:function(data){
			dispreply(data);
		}
	});
} 

function dispreply(data){
	//출력 내용을 저장할 변수를 생성
	disp = '';
	//data 배열을 순회 - idx는 인덱스이고 item은 실제 내용
	$(data).each(function(idx, item){
		disp += "<br>";
		disp += "<div class='card border-primary mb-3' style='max-width: 20rem;'>";
		disp += "<div class='card-header'>닉네임 : "+ item.nickname + "</div>";
		disp += "<div class='card-body'>";
		disp += "<p class='card-text'>"+ item.replytext + "</p>";
		disp += "</div> </div>"; 
			

		//접속한 유저와 댓글을 작성한 유저가 동일인이면
		 if(id == item.id){
			//삭제 버튼을 생성
			//삭제 버튼이 여러 개 될 수 있는 경우 
			//버튼의 id를 구분할 수 있는 값으로 만들면
			//나중에 id를 가지고 구분할 수 있습니다.
			disp += "<button type='submit' class='btn btn-danger'";
			disp += " id='del" + item.rno + "' ";
			disp += "style='float:right' ";
			disp += "onclick = 'del(this)'>댓글삭제</button>";
		 }
		 if(id == item.id){
			disp += "<button type='submit' class='btn btn-warning'";
			disp += " id='mod" + item.rno + "' ";
			disp += "style='float:right' ";
			disp += "onclick = 'mod(this)'>댓글수정</button>";
		 }
	});
	
	document.getElementById("replydisp").innerHTML = disp;
}
 
//댓글 삭제를 눌렀을 때 호출될 함수
function del(btn){
	//댓글 번호 가져오기
	id = btn.id;
	//댓글번호 만들기 - 앞의 3글자 제외한 부분
	rno = id.substr(3);
	//삭제를 위한 대화상자를 출력
	$('#dialog-confirm').dialog({
		resizable:false,
		height:'auto',
		width:400,
		modal:true,
		buttons:{
			"삭제":function(){
				$(this).dialog("close");
				
				$.ajax({
					url:"../reply/delete",
					data:{"rno": rno},
					dataType:"json",
					success:function(data){
						getReply();
					}
				});
				
			},
			"취소":function(){
				$(this).dialog("close");
			}
		}
	});
}

//댓글 수정 버튼을 눌렀을 때 수행할 내용
function mod(btn){
	id = btn.id;
	rno = id.substr(3);
	
	$('#replyform').dialog({
		resizable:false,
		height:'auto',
		width:400,
		model:true,
		buttons:{
			"수정":function(){
				$(this).dialog("close");
				//입력한 내용 가져오기
				replytext = document.getElementById("replytext").value;
				$.ajax({
					url:"../reply/update",
					data:{
						"replytext": replytext,
						"rno": rno
					},
					dataType:"json",
					success:function(data){
						//댓글을 출력하는 함수를 호출
						getReply();
					}
				});
			},
			"취소":function(){
				$(this).dialog("close");
			}
		}
	});
}




//리뷰 작성
document.getElementById("reviewadd").addEventListener(
	"click", function(){
	$("#reviewform").dialog({
	      resizable: false,
	      height: "auto",
	      width: 600,
	      modal: true,
	      buttons: {
		        "리뷰 저장": function() {
		        	$(this).dialog("close");
		        	rating = $("input[name=rating]:checked").val(); 
		      		reviewtext = document.getElementById("reviewtext").value;
		        	$.ajax({
						url:"../review/register",
						data:{
							"bno" : '${vo.bno}',
							"id":'${user.id}',
							"nickname":'${user.nickname}',
							"reviewtext": reviewtext,
							"rating" : rating
						},
						dataType:"json",
						success:function(data){
							//댓글을 출력하는 함수를 호출
							getReview();
						}
					});
		        },
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
			dispreview(data)
		}
	})
}

function dispreview(data){
	disp = '';
	$(data).each(function(idx, item){
		disp += "<br>";
		disp += "<div class='card border-primary mb-3' style='max-width: 20rem;'>";
		disp += "<div class='card-header'>닉네임 : " + item.nickname + "&nbsp;&nbsp;"; 
		if(item.rating == "1"){
			disp += "★☆☆☆☆";
			}else if(item.rating == "2"){
			disp += "★★☆☆☆";
			}else if(item.rating == "3"){
			disp += "★★★☆☆";
			}else if(item.rating == "4"){
			disp += "★★★★☆";
			}else if(item.rating == "5"){
			disp += "★★★★★";
			}
		disp += "</div>";
		disp += "<div class='card-body'>";
		disp += "<p class='card-text'>"+ item.reviewtext + "</p>";
		disp += "</div> </div>";
		
		
			
		if(id == item.id){
			//삭제 버튼을 생성
			//삭제 버튼이 여러 개 될 수 있는 경우 
			//버튼의 id를 구분할 수 있는 값으로 만들면
			//나중에 id를 가지고 구분할 수 있습니다.
			disp += "<button type='submit' class='btn btn-danger'";
			disp += " id='rdel" + item.rvno + "' ";
			disp += "style='float:right' ";
			disp += "onclick = 'del(this)'>리뷰삭제</button>";
		 }
		 if(id == item.id){
			disp += "<button type='submit' class='btn btn-warning'";
			disp += " id='rmod" + item.rvno + "' ";
			disp += "style='float:right' ";
			disp += "onclick = 'mod(this)'>리뷰수정</button>";
		 }
	});
	document.getElementById("reviewdisp").innerHTML = disp
}

//댓글 삭제를 눌렀을 때 호출될 함수
function rdel(btn){
	//댓글 번호 가져오기
	id = btn.id;
	//댓글번호 만들기 - 앞의 3글자 제외한 부분
	rvno = id.substr(3);
	//삭제를 위한 대화상자를 출력
	$('#dialog-confirm').dialog({
		resizable:false,
		height:'auto',
		width:400,
		modal:true,
		buttons:{
			"삭제":function(){
				$(this).dialog("close");
				
				$.ajax({
					url:"../review/delete",
					data:{"rvno": rvno},
					dataType:"json",
					success:function(data){
						getReview();
					}
				});
				
			},
			"취소":function(){
				$(this).dialog("close");
			}
		}
	});
}

//댓글 수정 버튼을 눌렀을 때 수행할 내용
function rmod(btn){
	id = btn.id;
	rvno = id.substr(3);
	
	$('#reviewform').dialog({
		resizable:false,
		height:'auto',
		width:400,
		model:true,
		buttons:{
			"수정":function(){
				$(this).dialog("close");
				//입력한 내용 가져오기
				replytext = document.getElementById("reviewtext").value;
				$.ajax({
					url:"../review/update",
					data:{
						"replytext" : replytext,
						"rating" : rating,
						"rvno" : rvno
					},
					dataType:"json",
					success:function(data){
						//댓글을 출력하는 함수를 호출
						getReview();
					}
				});
			},
			"취소":function(){
				$(this).dialog("close");
			}
		}
	});
}


</script>
</html>