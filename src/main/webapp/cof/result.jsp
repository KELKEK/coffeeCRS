<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<meta http-equiv="refresh" content="2;customerlogin.do">
</head>
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
   	
</style>
<body>
<main class="main">
<h1>${message}</h1>
</main>
</body>
</html>