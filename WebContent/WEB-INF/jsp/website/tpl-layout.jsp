<%@page contentType = "text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/portal/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/coffee/style.css">
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
				  		<a class="active" href="${pageContext.request.contextPath}/Coffee/order.do">커피주문</a>
				  	</li>
					<li>
						<a href="${pageContext.request.contextPath}/Coffee/product.do">커피종류</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/Board/list.do">게시판</a>
					</li>
			 	</ul>
			</td>
			<td valign="top" align="center">
				<!-- 본문 -->
				<h3><ul>커피 주문</ul></h3>
				
				<table id="coffee_tbl">
				
					<tr>	
						<td id="title_header">
							<span style="font-size:12px;font-weight:bold;">에소프레소</span>
						</td>
						<td id="title_header">
							<span style="font-size:12px;font-weight:bold;">커피라떼</span>
						</td>
						<td id="title_header">
							<span style="font-size:12px;font-weight:bold;">아메리카노</span>
						</td>
					</tr>
					
					<tr>	
						<td>
							<img width="300px" height="200px" src="${pageContext.request.contextPath}/resources/coffee/coffee1.jpg">
						</td>
						<td>
							<img width="300px" height="200px" src="${pageContext.request.contextPath}/resources/coffee/coffee1.jpg">
						</td>
						<td>
							<img width="300px" height="200px" src="${pageContext.request.contextPath}/resources/coffee/coffee1.jpg">
						</td>
					</tr>
					
					<tr>	
						<td colspan="3" id="price_header">
							<span style="font-size:12px;font-weight:bold;">가격</span>
						</td>
					</tr>
					<tr>	
						<td id="price_content">1,000원</td>
						<td id="price_content">1,000원</td>
						<td id="price_content">1,000원</td>
					</tr>
					
					<tr>	
						<td>
							<select name="size">
							    <option value="0">0</option>
							    <option value="1">1</option>
							    <option value="2">2</option>
							    <option value="3">3</option>
							</select>
							
							<button class="login_submit">선택</button>
						</td>
						<td>
							<select name="size">
							    <option value="0">0</option>
							    <option value="1">1</option>
							    <option value="2">2</option>
							    <option value="3">3</option>
							</select>
							
							<button class="login_submit">선택</button>
						</td>
						<td>
							<select name="size">
							    <option value="0">0</option>
							    <option value="1">1</option>
							    <option value="2">2</option>
							    <option value="3">3</option>
							</select>
							
							<button class="login_submit">선택</button>
						</td>
					</tr>
					
				</table>
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