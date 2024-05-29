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
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">
<link href="${cpath}/static/css/formInsert.css" rel="stylesheet">
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

// 설명 사각형을 보이게 하는 함수
function showExplanation() {
    document.getElementById('explanationBox').style.display = 'block';
}

// 설명 사각형을 숨기게 하는 함수
function hideExplanation() {
    document.getElementById('explanationBox').style.display = 'none';
}
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

/* 설명 사각형 스타일 */
#explanationBox {
  display: none; /* 초기에는 숨김 */
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 300px;
  padding: 20px;
  border: 2px solid #000;
  border-radius: 10px;
  background-color: #fff;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);
}

#explanationBox button {
  display: block;
  margin: 20px auto 0;
  padding: 10px;
  background-color: #04AA6D;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

#explanationBox button:hover {
  background-color: #037d50;
}
</style>
</head>
<body>
	<div class="main-w3layouts wrapper">
		<h1>CRS SignUp Form</h1>
		<div class="main-agileinfo">
			<div class="agileits-top">
				<form action="#" method="post">
				<fieldset>
				<legend>Account Information</legend><br>
					ID<input class="text" type="text" name="customerid" placeholder="아이디를 입력해주세요!" required="required">
					Password<input class="text" type="password" name="password" id="password" placeholder="영문/숫자포함 4글자 이상" pattern="[A-Za-z0-9]{4,}$" required="required">
					Confirm Password<span class="passwordtest" id="passwordMatchError" style="color: red; display: none;">비밀번호가 틀립니다.</span>
					<input class="text w3lpass" type="password" name="password" id="confirm_password" required="required">
					Nickname<input class="text" type="text" name="nickname" required="required">
					Phone<input class="text" type="text" name="phone" placeholder="-를 포함해주세요" pattern="010-[0-9]{4}-[0-9]{4}" required="required">
				</fieldset>
				<fieldset>
				<legend>커피추천을 위해 선호도를 입력해주세요! <span style="color: blue; cursor: pointer;" onclick="showExplanation()">선호도란?</span></legend><br>
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
					
				</div>			
				</fieldset>
					<div class="wthree-text">
						<label class="anim">
							<input type="checkbox" class="checkbox" required="">
							<span>I Agree To The Terms & Conditions</span>
						</label>
						<div class="clear"> </div>
					</div>
					<input type="submit" value="SIGNUP">
				</form>
				<p>Do you have an Account already?<br><a href="${cpath}/cof/customerlogin.do"> Login Now!</a></p>
			</div>
		</div>
		<div class="colorlibcopy-agile">
			<p>© 2024 Project Coffee Recommend Service</p>
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
	<!-- 설명 사각형 -->
	<div id="explanationBox">
		<p style="color:black">선호도란 가격, 일일 섭취량을 기준으로 한 카페인 양과 설탕, 원두의 품질검사 결과를 통해 커피를 추천할 수 있게 하는 기준이 됩니다.</p>
		<p style="color:black">기준에 맞게 0 ~ 10으로 나눌 수 있으며, Quality의 경우 품질이 좋을수록 수치가 높습니다.</p>
		<p style="color:black">가격 : 1000 ~ 10000(won)</p>
		<p style="color:black">카페인 : 0 ~ 400(mg)</p>
		<p style="color:black">당분 : 0 ~ 50(g)</p>
		<p style="color:black">원두품질 : 0 ~ 10</p>
		<button onclick="hideExplanation()">나가기</button>
	</div>
	<%-- //main --%>
</body>
</html>
