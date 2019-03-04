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
			<!--  method 와 enctype은 파일을 업로드하기 위해서 설정
				    파일이 업로드되는 폼은 반드시 method는 post 로
				  enctype은 multipart/form-data로 설정  -->
				<div class="box-header">
					<h3 class="box-title">게시판 글쓰기</h3>
				</div>
			<form enctype="multipart/form-data" method="post" onsubmit="return check()">
			
				<div class="box-body">
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
						<label>영화 포스트 : </label>
							<img id="img" width="100" height="100" border="1"/>
							<input type='file' id="image" name="image" required="required"/>
					</div>
					<div class="form-group">
						<label>장르 </label><br/>
							<input type="radio" id="genre" name="genre" value="코미디" checked="checked"/>코미디 <br/>
							<input type="radio" id="genre" name="genre" value="액션"/>액션<br/>
							<input type="radio" id="genre" name="genre" value="스릴러"/>스릴러<br/>
							<input type="radio" id="genre" name="genre" value="공포"/>공포<br/>	
							<input type="radio" id="genre" name="genre" value="드라마"/>드라마<br/>	
							<input type="radio" id="genre" name="genre" value="멜로"/>멜로<br/>	
					</div>
					
					<div class="form-group">
						<label>닉네임 : </label> 
						<input type="text" name="nickname" value="${user.nickname}" 
							   class="form-control" readonly="readonly">
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
		<!-- 	</div> -->
	
		</div>
	 </div> 
</body>
<script>
	var filename = ''
	document.getElementById("image").addEventListener('change',function(){
		readURL(this);
	});
	
	function readURL(input){
		if(input.files && input.files[0]){
			filename = input.files[0].name;
			var ext = filename.substr(filename.length - 3, filename.length);
			var isCheck = false;
			if((ext.toLowerCase() == "jpg" || ext.toLowerCase() == "gif" || ext.toLowerCase() == "png")){
				isCheck = true;
			}
			if (isCheck == false) {
				alert("jpg나 gif, png 만 업로드가 가능합니다.");
				return;
			}
			var reader = new FileReader();

			reader.onload = function(e) {
				document.getElementById('img').src = e.target.result;
			}
			reader.readAsDataURL(input.files[0]);
		}
	};

	function check(){
		var img = document.getElenemtById("image")
		if(img.value = ""){
			alert("영화 포스터를 삽입해야합니다.")
			return false;
		}
		
		var content = document.getElementById("content")
		if(content.value == ""){
			alert("내용을 입력하셔야 합니다.")
			content.focus();
			return false;
		}
		
		var titlt = document.getElementById("title")
		if(title.value == ""){
			alert("영화 제목을 입력하셔야 합니다.")
			title.focus();
			return false;
		}
	}

	
</script>
</html>