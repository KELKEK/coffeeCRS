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
</script>
</head>
<body>
<div class="main-w3layouts wrapper">
		<h1>Coffee Insert</h1>
		<div class="main-agileinfo">
			<div class="agileits-top">
				<form action="coffeeinsert.do" method="post">
					Coffee_brandid<input class="text" type="text" name="coffee_brandid" id="coffee_brandid" value="${loginCorp.coffee_brandid}" readonly="readonly">
					CoffeeName<input class="text" type="text" name="coffeename" id="coffeename" required="required">
					Price<input class="text" type="text" name="price" id="price" required="required">
					Caffeine<input class="text" type="text" name="caffeine" id="caffeine" required="required">
					Sugar<input class="text" type="text" name="sugar" id="sugar" required="required">
					Quality(원두품질:검사기준표 점수 기준)<input class="text" type="text" name="quality" id="quality" placeholder="0~9 사이 정수" pattern="[0-9]{1}" required="required">
					<div class="wthree-text">
						<label class="anim">
							<input type="checkbox" class="checkbox" required="required">
							<span>모든 내용을 확인했습니다.</span>
						</label>
						<div class="clear"> </div>
					</div>
					<input type="submit" value="SIGNUP">
				</form>
			</div>
		</div>
		<div class="colorlibcopy-agile">
		</div>
</div>
</body>
</html>