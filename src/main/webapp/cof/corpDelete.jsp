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
<form action="corpdelete.do" method="post">
	<div class="main-w3layouts wrapper">
		<h1>CRS Delete Form</h1>
		<div class="main-agileinfo">
			<div class="agileits-top">
				<fieldset>
				<legend>탈퇴를 위해 정보를 입력해주세요</legend><br>
				  <div class="form-group">
				    <label for="exampleInputId">ID</label>
				    <input type="text" class="form-control" name="sellerid" value="${loginCorp.sellerid}" readonly="readonly" placeholder="Enter email">
				    
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword">Password</label>
				    <input type="password" class="form-control" name="password" placeholder="Password">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPhone">Phone</label>
				    <input type="text" class="form-control" name="phone"  aria-describedby="phoneHelp">
				    <small id="phoneHelp" class="form-text text-muted">'-'기호를 포함하여 넣어주세요</small>
				  </div>		
				  <input type="submit" value="전송">
				</fieldset>
			</div>
		</div>
	</div>
	</form>
</body>
</html>