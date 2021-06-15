<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value="/asset/css/main/joinform.css" />" />
<jsp:include page="/WEB-INF/view/include/mainheader.jsp" />
<div class=success>
	<p>"감사합니다. 회원 가입 및 블로그가 성공적으로 만들어 졌습니다."</p>
	<a href="<c:url value="/user/login" />">로그인하기</a>
</div>
<jsp:include page="/WEB-INF/view/include/footer.jsp" />