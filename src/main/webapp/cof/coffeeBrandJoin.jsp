<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.request.servletContext.contextPath}" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">
<link href="${cpath}/static/css/formInsert.css" rel="stylesheet">    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
document.addEventListener("DOMContentLoaded", function() {
    document.getElementById('password').addEventListener('input', function() {
        var password = this.value;
        var confirmPassword = document.getElementById('confirm_password').value;
        var passwordMatchError = document.getElementById('passwordMatchError');

        if (password !== confirmPassword) {
            passwordMatchError.style.display = 'block'; // 비밀번호가 일치하지 않으면 오류 메시지 표시
        } else {
            passwordMatchError.style.display = 'none'; // 비밀번호가 일치하면 오류 메시지 숨김
        }
    });

    document.getElementById('confirm_password').addEventListener('input', function() {
        var password = document.getElementById('password').value;
        var confirmPassword = this.value;
        var passwordMatchError = document.getElementById('passwordMatchError');

        if (password !== confirmPassword) {
            passwordMatchError.style.display = 'block'; // 비밀번호가 일치하지 않으면 오류 메시지 표시
        } else {
            passwordMatchError.style.display = 'none'; // 비밀번호가 일치하면 오류 메시지 숨김
        }
    });
});
</script>
<%
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage != null && !errorMessage.isEmpty()) {
%>
    <script>
        alert('<%= errorMessage %>');
    </script>
<%
    }
%>

</head>
<body>
<div class="main-w3layouts wrapper">
		<h1>CRS Corporation SignUp Form</h1>
		<div class="main-agileinfo">
			<div class="agileits-top">
				<form action="corpinsert.do" method="post">
					BrandName<input class="text" type="text" name="coffee_brandname" id="coffee_brandname" required="required">
					BrandID<input class="text" type="text" name="coffee_brandid" id="coffee_brandid" placeholder="4글자의 숫자로 입력해주세요" pattern="[0-9]{4}" required="required">
					Account<input class="text" type="text" name="sellerid" id="sellerid" placeholder="실제로 쓰일 계정입니다" required="required">
					Password<input class="text" type="password" name="password" id="password" placeholder="영문/숫자포함 4글자 이상" pattern="[A-Za-z0-9]{4,}$" required="required">
					Confirm Password<span class="passwordtest" id="passwordMatchError" style="color: red; display: none;">비밀번호가 틀립니다.</span>
					<input class="text w3lpass" type="password" name="password" id="confirm_password" required="required">
					Nickname<input class="text" type="text" name="nickname" id="nickname" required="required">
					Phone<input class="text" type="text" name="phone" id="phone" placeholder="-를 포함해주세요" pattern="010-[0-9]{4}-[0-9]{4}" required="required">
					location(x)<input class="text" type="text" name="dist_x" id="dist_x" placeholder="0~9 사이 정수" pattern="[0-9]{1}" required="required">
					location(y)<input class="text" type="text" name="dist_y" id="dist_y" placeholder="0~9 사이 정수" pattern="[0-9]{1}" required="required">
					
					<div class="wthree-text">
						<label class="anim">
							<input type="checkbox" class="checkbox" required="required">
							<span>모든 내용을 확인했습니다.</span>
						</label>
						<div class="clear"> </div>
					</div>
					<input type="submit" value="SIGNUP">
				</form>
				<p>Do you have an Account already?<br><a href="${cpath}/cof/corplogin.do"> Login Now!</a></p>
			</div>
		</div>
		<div class="colorlibcopy-agile">
			<p>© 2024 Project Coffee Recommend Service</p>
		</div>
</div>
</body>
</html>