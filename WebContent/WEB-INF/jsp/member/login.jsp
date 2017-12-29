<%@ page contentType = "text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login - Project(Rabbit)</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/member/style.css">
</head>
<body>

<table id="member_tbl">
	<tr>
		<td align="center">
			<!-- 로그인 화면 -->
			<table style="width:70%">
				<tr>
					<td style="width:30%">
					<img src="${pageContext.request.contextPath}/resources/member/rabbit-membership.jpg">
					</td>
					<td>
						<!-- 폼(로그인) -->
						<form:form modelAttribute="loginValidated" method="POST" action="${pageContext.request.contextPath}/Member/Login">
						<table id="loginForm_tbl">
							<tr>
								<td>아이디</td>
								<td>
								<form:input id="loginInput" path="email" type ="text" placeholder="email address" />
								</td>
							</tr>
							<tr>
								<td>비밀번호</td>
								<td>
								<form:input id="loginInput" path="pwd" type ="password" placeholder="" />
								</td>
							</tr>
							<tr>
								<td colspan="2">
								<span>회원이시라면, 빈칸에 아이디와 비밀번호를 입력하세요.</span>
								</td>
							</tr>
							
							<tr>
								<td colspan="2">
									<button class="login_submit">로그인</button>
									<p>
									<span class="message">Not registered?(아직 가입 안했나요?)</span>
									<br />
						    		<a href="#">Create an account(계정 생성)</a>
						    		</p>
								</td>
							</tr>				
						</table>
						
						</form:form>
						
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<span class="gpl_license">GPL License - github.com/whitedodo</span>
		</td>
	</tr>
</table>

</body>
</html>