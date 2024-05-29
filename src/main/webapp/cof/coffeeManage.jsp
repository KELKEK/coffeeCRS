<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
<style>
body {
    font-family: "Jua", sans-serif;
    height: 100vh;
    background-color: #B5906D;
    background-image: url('../static/css/coffeeback.jpg');
    background-blend-mode: multiply;
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    margin: 0;
}
/* 작은 해상도에 대한 스타일 */
@media (max-width: 768px) {
    body {
        background-size: contain; /* 배경 이미지를 화면에 맞게 조정 */
    }
}

table {
    margin: 0 auto; /* 가로 가운데 정렬 */
    margin-top : 10vh;
    transform: scale(2); /* 가로세로 2배로 확대 */
}

.centered-content {
    display: flex;
    flex-direction: column; /* 요소를 세로로 배치 */
    align-items: center; /* 세로 가운데 정렬 */
    justify-content: center; /* 가로 가운데 정렬 */
}

#brand {
    margin-left: 10px; /* 필요한 경우 왼쪽 여백 조절 */
}

.button-container {
    display: flex;
    justify-content: center;
    margin-top: 100px;
}

th {
    background-color: orange; /* 헤더 배경색 오렌지 */
    color: white; /* 헤더 글자색 흰색 */
    padding: 8px;
}

/* 홀수 행 배경색 옅은회색 */
tr:nth-child(odd) {
    background-color: #f2f2f2;
}

/* 짝수 행 배경색 흰색 */
tr:nth-child(even) {
    background-color: white;
}
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
<div class="centered-content">
<h1>관리판</h1>
    <table border="1">
        <tr>
            <th>커피ID</th>
            <th>커피명</th>
            <th>가격</th>
            <th>카페인양</th>
            <th>당분</th>
            <th>원두품질</th>
            <th></th>
        </tr>
        <c:forEach var="coffee" items="${clist}">
            <tr>
                <td>${coffee.coffee_id }</td>
                <td>${coffee.coffee_name }</td>
                <td>${coffee.price }</td>
                <td>${coffee.caffeine }</td>
                <td>${coffee.sugar }</td>
                <td>${coffee.quality }</td>
                <td><button onclick="location.href='${cpath}/cof/coffeedelete.do?coffee_id=${coffee.coffee_id}'">삭제</button></td>
            </tr>
        </c:forEach>
    </table>
    <div class="button-container">
        <button onclick="location.href='${cpath}/cof/coffeeinsert.do'">커피등록</button>
    </div>
</div>
</body>
</html>
