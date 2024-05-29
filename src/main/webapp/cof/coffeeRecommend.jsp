<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.container {
    display: flex;
    justify-content: space-between;
}


    body {
        margin: 0;
        padding: 0;
        background-color: #DFBBAE;
        background-image: url('selectMode.png');
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

    .main{
        width: 100vw;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        position: relative;
    }
    
    h1{ 
    	font-size: 4em;
    }
   	
   	h2{
   		font-size: 3em;
   	}
</style>
</head>
<body>
	<h2 style="color:white">${loginCus.nickname }님 어서오세요!</h2>
	<a href="${cpath}/cof/logout.do">로그아웃</a>
	 <button onclick="goBack()">뒤로 가기</button>
    <script>
        function goBack() {
            window.history.back();
        }
    </script>
<main class="main">
<h1>${nickname }님을 위한 추천결과 : </h1><br>
<h2> ${coffeebrand }의 ${coffeename }</h2>

</body>
</html>