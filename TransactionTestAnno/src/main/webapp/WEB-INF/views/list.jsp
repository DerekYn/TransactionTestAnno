<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<jsp:include page="header.jsp" />

<style type="text/css">
	table, th, td {border: solid gray 1px;}
	
	#table {border-collapse: collapse;
	 		width: 80%;
	 		}
	#table th, #table td{padding: 5px; text-align: center;}
	#table th{background-color: #DDDDDD;}
</style>

<div>
	<h1>공지게시판 : 글목록</h1>
	<table id="table">
		<thead>
			<tr>
				<th style="width: 25%">글번호</th>
				<th style="width: 25%">작성자</th>
				<th style="width: 50%">글제목</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="3">데이터가 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="map" items="${list}" varStatus="status">
					<tr>
						<td>${map.SEQ}</td>
						<td>${map.NAME}</td>
						<td>${map.TITLE}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	
	<div style="border: 0px solid gray; width: 50%; margin-top: 3%; margin-left: 20%;">
		<button type="button" onClick="javascript:location.href='add_notransaction.action'">글쓰기(트랜잭션처리안함)</button>
		&nbsp;&nbsp;
		<button type="button" onClick="javascript:location.href='add_transaction.action'">글쓰기(트랜잭션처리함)</button>
	</div>
	
</div>
	
<jsp:include page="footer.jsp" />