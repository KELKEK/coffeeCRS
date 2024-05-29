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
    margin-top : 20vh;
    transform: scale(2); /* 가로세로 2배로 확대 */
}

.centered-content {
    display: flex;
    flex-direction: row; /* 요소를 가로로 배치 */
    align-items: center; /* 세로 가운데 정렬 */
    justify-content: center; /* 가로 가운데 정렬 */
}

#brand {
    margin-left: 10px; /* 필요한 경우 왼쪽 여백 조절 */
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
<script src="${cpath}/static/js/jquery-3.7.1.min.js"></script>
<script>
$(function(){
    $('#brand').change(function(){
        var selectedBrand = $(this).val();
        if (selectedBrand.trim() === '') {
            $('table tr').show();
            return;
        }
        $('table tr').show();
        $('table tr').not(':first-child').each(function(){
            var rowBrand = $(this).find('td:eq(1)').text();
            if (rowBrand !== selectedBrand) {
                $(this).hide();
            }
        });
    });
});
</script>
</head>
<body>
	<h2 style="color:white">${loginCus.nickname }님 어서오세요!</h2>
	<a href="${cpath}/cof/logout.do" style="color:white">로그아웃</a>
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
        <li><a href="${cpath}/cof/recommend.do?customerid=${loginCus.customerid}&nickname=${loginCus.nickname}"><i class="fa-solid fa-cat"></i> 커피 추천받기</a></li>
        <li><a href="${cpath}/cof/favor.do?customerid=${loginCus.customerid}"><i class="fa-solid fa-cat"></i> 선호도 수정</a></li>
        <li><a href="${cpath }/cof/menuboard.do"><i class="fa fa-coffee" style="font-size: 28px"></i> 메뉴판 보기</a></li>
        <li><a href="${cpath }/cof/cusdelete.do"><i class="fa-solid fa-cat"></i> 회원탈퇴</a></li>
    </ul>
</aside>
   <div class="centered-content">
        <h1>메뉴판</h1>
        <input type="text" list="coffeebrandlist" name="brand" id="brand">
        <datalist id="coffeebrandlist">
        <c:forEach var = "brandid" items="${clist}">
        	<option>${brandid.brand }</option>
        </c:forEach>
		</datalist>
<script>
//option과 관련되어 일단 스크립트를 이쪽으로 뺌
    // 중복된 값을 제거하는 함수
    function removeDuplicates() {
        var datalist = document.getElementById("coffeebrandlist");
        var options = Array.from(datalist.options); // datalist의 옵션들을 배열로 변환

        var uniqueOptions = options.filter(function (option, index, self) {
            return self.findIndex(function (t) {
                return t.value === option.value; // 중복된 값을 제거
            }) === index;
        });

        // 중복을 제거한 옵션들로 datalist 업데이트
        datalist.innerHTML = '';
        uniqueOptions.forEach(function (option) {
            datalist.appendChild(option);
        });
    }

    // 페이지 로드 시 중복된 값 제거
    removeDuplicates();
</script>
    </div>
<table border="1">
    <tr>
        <th>커피명</th>
        <th>가게명</th>
        <th>가격(won)</th>
        <th>카페인양(mg)</th>
        <th>당분(g)</th>
        <th>원두품질</th>
    </tr>
    <c:forEach var="coffee" items="${clist}">
        <tr>
            <td>${coffee.name }</td>
            <td>${coffee.brand }</td>
            <td>${coffee.price }</td>
            <td>${coffee.caffeine }</td>
            <td>${coffee.sugar }</td>
            <td>${coffee.quality }</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>