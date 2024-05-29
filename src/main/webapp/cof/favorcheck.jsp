<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.request.servletContext.contextPath}" />
<link rel="stylesheet" href="${cpath}/static/css/formInsert.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	document.addEventListener("DOMContentLoaded", function() {
		// 각 range input 요소들을 가져옵니다.
		var rangeInputs = document.querySelectorAll('input[type="range"]');

		// 각 range input의 값이 변경될 때마다 호출되는 함수를 정의합니다.
		function updateSliderValue() {
			// 각 range input의 값을 가져옵니다.
			var value1 = document.getElementById('myRange1').value;
			var value2 = document.getElementById('myRange2').value;
			var value3 = document.getElementById('myRange3').value;
			var value4 = document.getElementById('myRange4').value;
			var value5 = document.getElementById('myRange5').value;

			// 각 output 요소에 해당 값들을 업데이트합니다.
			document.getElementById('value1').textContent = value1;
			document.getElementById('value2').textContent = value2;
			document.getElementById('value3').textContent = value3;
			document.getElementById('value4').textContent = value4;
			document.getElementById('value5').textContent = value5;
		}

		// 각 range input에 대해 이벤트 리스너를 추가합니다.
		rangeInputs.forEach(function(input) {
			input.addEventListener('input', updateSliderValue);
		});

	});
</script>
<style>
.slidecontainer {
	width: 100%;
}

.slider {
	-webkit-appearance: none;
	width: 100%;
	height: 10px;
	border-radius: 5px;
	background: #d3d3d3;
	outline: none;
	opacity: 0.7;
	-webkit-transition: .2s;
	transition: opacity .2s;
}

.slider:hover {
	opacity: 1;
}

.slider::-webkit-slider-thumb {
	-webkit-appearance: none;
	appearance: none;
	width: 23px;
	height: 24px;
	border-radius: 50%;
	background: #04AA6D;
	cursor: pointer;
}

.slider::-moz-range-thumb {
	width: 23px;
	height: 24px;
	border-radius: 50%;
	background: #04AA6D;
	cursor: pointer;
}
</style>
</head>
<body>
	<form action="favor.do" method="post">
	<div class="main-w3layouts wrapper">
		<h1>CRS InsertFavor Form</h1>
		<div class="main-agileinfo">
			<div class="agileits-top">
				<fieldset>
				<legend>커피추천을 위해 선호도를 입력해주세요!</legend><br>
				<div class="slidecontainer">
					Price<input type="range" min="0" max="10" value="" class="slider" id="myRange1" name="price" required="required">
					<p>Value: <output id="value1"></output></p>
					Caffeine<input type="range" min="0" max="10" value="" class="slider" id="myRange2" name="caffeine" required="required">
					<p>Value: <output id="value2"></output></p>
					Sugar<input type="range" min="0" max="10" value="" class="slider" id="myRange3" name="sugar" required="required">
					<p>Value: <output id="value3"></output></p>
					Quality<input type="range" min="0" max="10" value="" class="slider" id="myRange4" name="quality" required="required">
					<p>Value: <output id="value4"></output></p>
					Distance<input type="range" min="0" max="10" value="" class="slider" id="myRange5" name="distance" required="required">
					<p>Value: <output id="value5"></output></p>
					<input type="hidden" name="customerid" value="${loginCus.customerid}">
					<input type="submit" value="전송">
				</div>			
				</fieldset>
			</div>
		</div>
		<ul class="colorlib-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>
	</form>
</body>
</html>
