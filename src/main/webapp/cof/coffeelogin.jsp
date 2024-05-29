<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  margin: 0;
}

form {
  border: 3px solid #f1f1f1;
  display: flex;
  align-items: center; /* 내부 요소를 수평으로 가운데 정렬하기 위해 설정 */
  flex-direction: column; /* 내부 요소를 수직으로 정렬하기 위해 열 방향으로 설정 */
  height: 100vh; /* 홈페이지 창의 높이에 맞게 form 요소의 높이를 설정 */
}

img.avatar {
  width: 70%;
  border-radius: 50%;
  margin-right: 10%;
}

.container {
  width: 50%;
  padding: 16px;
  height: auto; /* 높이를 자동으로 설정하여 이미지와 일치시킴 */
  display: flex; /* 내부 요소들을 가로로 정렬하기 위해 설정 */
  align-items: center; /* 내부 요소를 세로 방향으로 가운데 정렬하기 위해 설정 */
}

.container1 {
  width: 100%;
  padding: 16px;
}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn, .joinbtn {
  width: auto;
  padding: 10px 18px;
}

.cancelbtn {
  background-color: #f44336;
}

.joinbtn {
  background-color: #04AA6D;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn, .joinbtn {
     width: 100%;
  }
}
</style>
</head>
<body>
<h2 style="text-align: center;">CRS Login Form</h2>

<form action="customerlogin.do" method="post">
    <div class="container">
        <img src="logincoffee.jpg" alt="Avatar" class="avatar">
        <div>
            <h1>CRS에 방문하신 것을 환영합니다!</h1>
            <label for="uname"><b>Username</b></label>
            <input type="text" placeholder="Enter Username" name="uname" required>
            <label for="psw"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="psw" required>
            <button type="submit">Login</button>
        </div>
    </div>
  <div class="container1" style="background-color: #f1f1f1;">
    <button type="button" class="joinbtn"  onclick="window.location.href = 'customerinsert.do'">Join</button>
  </div>
</form>

</body>
</html>

