<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>${loginEmp.first_name}님 환영합니다.</h1>
<a href="${pageContext.request.servletContext.contextPath}/auth/logout.do">로그아웃</a>
<hr>
<%--절대경로로 바꿔야함 --%>