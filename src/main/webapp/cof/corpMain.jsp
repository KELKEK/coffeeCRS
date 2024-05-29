<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.servletContext.contextPath}/cof" />
<c:set var="cpath" value="${pageContext.request.servletContext.contextPath}" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" href="${cpath}/static/css/coffeeMenuStyle.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
    font-family: "Jua", sans-serif;
    height: 100vh; /* 뷰포트 높이만큼 설정 */
    background-color: #B5906D;
    background-image: url('../static/css/coffeeback.jpg');
    background-blend-mode: multiply;
    background-size: cover; /* 배경 이미지를 커버하도록 설정 */
    background-position: center; /* 배경 이미지를 가운데 정렬 */
    background-repeat: no-repeat;
}

/* 작은 해상도에 대한 스타일 */
@media (max-width: 768px) {
    body {
        background-size: contain; /* 배경 이미지를 화면에 맞게 조정 */
    }
}

a{
	color: white;
	font-size: 15px;
}
/* demo */
</style>
</head>
<body>
	<h2 style="color:white">${loginCorp.nickname }님 어서오세요!</h2>
	<a href="${cpath}/cof/corplogout.do" style="color:white">로그아웃</a>
	 <button onclick="goBack()">뒤로 가기</button>
    <script>
        function goBack() {
            window.history.back();
        }
    </script>
	<aside class="side-bar">
		<section class="side-bar__icon-box">
			<section class="side-bar__icon-1">
				<div></div>
				<div></div>
				<div></div>
			</section>
		</section>
		<ul>
			<li><a href="${cpath}/cof/coffeemanage.do?coffee_brandid=${loginCorp.coffee_brandid}"><i class="fa-solid fa-cat"></i> 커피관리</a></li>
			<li><a href="${cpath}/cof/corpdelete.do"><i class="fa-solid fa-cat"></i> 회원탈퇴</a></li>
		</ul>
	</aside>
	
</body>
</html>