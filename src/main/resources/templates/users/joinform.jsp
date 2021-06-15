<link rel="stylesheet" href="<c:url value="/asset/css/main/joinform.css" />" />

<jsp:include page="/WEB-INF/view/include/mainheader.jsp" />

<div class=join-container>
	<form id="join-form" name="registerForm"
		action="<c:url value="/usr/join"/>" method="POST" class="join-form">
		<input type="hidden" name="check" value="c" >
		<p>
			<label for="userName" class=text>이름</label><br> <iㅇnput type="text"
				name="userName" class = form>
		</p>
		<p>
			<label for="id" class=text>아이디</label> <br> <input type="text" name="id" class = id>

			<input type="button" value="중복 체크"
				onclick="checkid(this.form.id,'<c:url value="/users/idcheck" />')"  class=idButton/><br>
				<span class=checkId></span>
		</p>
		<p>
			<span class="text"> </span>
		</p>
		<p>
			<label for="password" class=text>패스워드</label><br> <input type="password"
				name="password" class = form><br>
		</p>
		
		<p>
		<label for="agree" class=text>약관동의</label><br> 
		<span class=text><input type="checkbox"
			name="agree" value="agree"> 서비스 약관에 동의합니다<br>
			</span>  
		</p>
		<input
			type="button" value="회원가입" onclick="checkJoinForm(this.form)" class = form>
	</form>
</div>

<jsp:include page="/WEB-INF/view/include/footer.jsp" />