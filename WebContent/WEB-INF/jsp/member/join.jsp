<%@page contentType = "text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 - Project(Rabbit)</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/member/style.css">
</head>
<body>

<table id="member_tbl">
	<tr>
		<td align="center">
			<!-- 회원가입 화면 -->
			<table style="width:70%">
				<tr>
					<td style="width:30%">
					<img src="${pageContext.request.contextPath}/resources/member/logo_s.jpg">
					</td>
					<td>
						<!-- 폼(로그인) -->
						<form method="POST" action="${pageContext.request.contextPath}/Member/Join">
			    			 
						<table id="loginForm_tbl">
							<tr>
								<td colspan="2">
								<h3>회원가입</h3>
								</td>
							</tr>
							<tr>
								<td>아이디</td>
								<td>
								<input id="loginInput" type ="text" placeholder="email address" />
								</td>
							</tr>
							<tr>
								<td>비밀번호</td>
								<td>
								<input id="loginInput" type ="text" placeholder="password" />
								</td>
							</tr>
							<tr>
								<td>비밀번호 확인</td>
								<td>
								<input id="loginInput" type ="text" placeholder="password check" />
								</td>
							</tr>
							<tr>
								<td>이름</td>
								<td>
								<input id="loginInput" type ="text" placeholder="name" />
								</td>
							</tr>
							
							<tr>
								<td>이메일</td>
								<td>
								<input id="loginInput" type ="text" placeholder="name" />
								</td>
							</tr>
							
							<tr>
								<td colspan="2">
									<button class="login_submit">회원가입</button>
								</td>
							</tr>				
						</table>
						
						</form>
						
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