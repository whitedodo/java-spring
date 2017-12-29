<%@page contentType = "text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

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
				<h3>게시판</h3>
				
				<table id="board_list_tbl">
				
					<tr>
						<td id="title_header" style="width:10%">
							<span style="font-size:12px;font-weight:bold;">번호</span>
						</td>
						
						<td id="title_header" style="width:50%">
							<span style="font-size:12px;font-weight:bold;">글제목</span>
						</td>
						
						<td id="title_header" style="width:15%">
							<span style="font-size:12px;font-weight:bold;">작성자</span>
						</td>
						
						<td id="title_header" style="width:15%">
							<span style="font-size:12px;font-weight:bold;">등록일자</span>
						</td>
						
						<td id="title_header" style="width:10%">
							<span style="font-size:12px;font-weight:bold;">조회수</span>
						</td>
						
					</tr>
					
					<!-- 출력 -->
					<c:set var="cnt" value="1" />
                    <c:forEach var="content" items="${listView}">
                    <c:if test="${cnt % 2 != 0 }">
	                <tr>	
						<td id="content_odd">
							<span>${content.id}</span>
						</td>
						<td id="content_odd">
							<span><a href="view.do?id=${board_id}&content_id=${content.id}">${content.subject}</a></span>
						</td>
						<td id="content_odd">
							<span>${content.writer}</span>
						</td>
						<td id="content_odd">
							<span><fmt:formatDate pattern = "yyyy-MM-dd H:m:ss" value="${content.regidate}" /></span>
						</td>
						<td id="content_odd">
							<span>${content.count}</span>
						</td>
					</tr>
					</c:if>
					
					<c:if test="${cnt % 2 == 0 }">
					<tr>	
						<td id="content_even">
							<span>${content.id}</span>
						</td>
						<td id="content_even">
							<span><a href="view.do?id=${board_id}&content_id=${content.id}">${content.subject}</a></span>
						</td>
						<td id="content_even">
							<span>${content.writer}</span>
						</td>
						<td id="content_even">
							<span><fmt:formatDate pattern = "yyyy-MM-dd H:m:ss" value="${content.regidate}" /></span>
						</td>
						<td id="content_even">
							<span>${content.count}</span>
						</td>
					</tr>
					
					</c:if>
	                <c:set var="cnt" value="${cnt + 1}" />
	                
	                </c:forEach>
					
				</table>
				
				<!-- 게시판 목록 기능 -->
				<div id="board_list_func">
					
				<table id="board_list_func_tbl">
					<tr>	
						<td colspan="3">
							<!-- 게시판 페이지네이션 -->
							<ul class="pagination">
					    	 <c:forEach var="pager" items="${pagerLeft }">
					    	 	${pager }
					    	 </c:forEach>
					    	 <c:forEach var="pager" items="${pagerNav }">
					    	 	${pager }
					    	 </c:forEach>
					    	 <c:forEach var="pager" items="${pagerRight }">
					    	 	${pager }
					    	 </c:forEach>
							</ul>
						</td>
					</tr>
					
					<tr>
						<td style="width:20%; text-align:left">	
							<a href="write.do" class="board_list_btn board_list_btn_font">글작성</a>
							<a class="board_list_btn board_list_btn_font">목록</a>
						</td>
						<td>
						
						</td>
						<td style="width:20%">
							
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