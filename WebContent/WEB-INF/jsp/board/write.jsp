<%@page contentType = "text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/portal/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/board/style.css">
</head>

<body>
	<table id="portal_tbl" >
		<!-- 상단 -->
		<tr>
			<td style="width:20%;">
				<a href="${pageContext.request.contextPath}/Portal">
					<img src="${pageContext.request.contextPath}/resources/portal/portal-logo.jpg">
				</a>
			</td>
			<td>
				<ul id="head_nav">
				  <li style="float:right">
				  	<a href="${pageContext.request.contextPath}/Member/modify.do">개인정보수정</a>
			  	  </li>
				  <li style="float:right">
				  	<a href="${pageContext.request.contextPath}/Member/logout.do">로그아웃</a>
			  	  </li>
				</ul> 
			</td>
		</tr>
		<!-- 중간 -->
		<tr>
			<td valign="top">
				<!-- 메뉴 -->
				 <ul id="menu_ul">
				  	<li>
				  		<a href="${pageContext.request.contextPath}/Coffee/order.do">커피주문</a>
				  	</li>
					<li>
						<a href="${pageContext.request.contextPath}/Coffee/product.do">커피종류</a>
					</li>
					<li>
						<a class="active" href="${pageContext.request.contextPath}/Board/list.do">게시판</a>
					</li>
			 	</ul>
			</td>
			<td valign="top" align="center">
				<!-- 본문 -->
				<h3>글 작성</h3>
				
				<table id="board_write_tbl">
				
					<tr>
						<td id="title_header" style="width:10%">
							<span style="font-size:12px;font-weight:bold;">글 제목</span>
						</td>
						
						<td colspan="5" style="width:65%">
							<input class="inputBox" type="text">
						</td>
					</tr>
					
					<tr>	
						<td id="title_header" style="width:10%">
							<span style="font-size:12px;font-weight:bold;">작성자명</span>
						</td>
						
						<td style="width:10%">
							<input class="inputBox" type="text">
						</td>
						<td id="title_header" style="width:10%">
							<span style="font-size:12px;font-weight:bold;">비밀번호</span>
						</td>
						
						<td style="width:10%">
							<input class="inputBox" type="password">
						</td>
						
						<td id="title_header" style="width:10%">
							<span style="font-size:12px;font-weight:bold;">비밀번호 확인</span>
						</td>
						
						<td style="width:10%">
							<input class="inputBox" type="password">
						</td>
					</tr>
					
					<tr>
						<td colspan="6">
							<textarea class="textBox"></textarea>
						</td>
					</tr>
					
				</table>
				<div id="board_write_func">
				<table id="board_write_func_tbl">
					<tr>
						<td>
							<button class="board_write_btn board_write_btn_font">작성</button>
						</td>
						<td>
							<a href="list.do" class="board_write_btn board_write_btn_font">취소</a>
						</td>
					</tr>
				</table>
				</div>
			</td>
		</tr>
		<!-- 하단 -->
		<tr>
			<td colspan="2">
				<span class="gpl_license">GPL License - github.com/whitedodo</span>
			</td>
		</tr>
	</table>
</body>
</html>