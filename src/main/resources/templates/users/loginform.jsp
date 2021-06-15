<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/asset/css/main/loginform.css" />" />
<jsp:include page="/WEB-INF/view/include/mainheader.jsp" />
<div class=login-container>
	<form id="join-form" name="registerForm"
		action="<c:url value="/user/login"/>" method="POST">
		<label for="id" class=text>아이디</label> <br> <input type="text"
			name="id" class=form><br> <label for="password"
			class=text>패스워드</label><br> <input type="password"
			name="password" class=form><br>
		<p>
		<div class=falsetext></div>
		<br>
		<div class=falsetext></div>
		</p>

		<input type="button" value="로그인"
			onclick="checklogin(this.form,'<c:url value="/users/logincheck" />')"
			class=form />
	</form>
</div>

<jsp:include page="/WEB-INF/view/include/footer.jsp" />