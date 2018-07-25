<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String ctxpath = request.getContextPath();
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>트랜잭션처리 테스트</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.navbar {
    overflow: hidden;
    background-color: #333;
    font-family: Arial, Helvetica, sans-serif;
}

.navbar a {
    float: left;
    font-size: 16px;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

.dropdown {
    float: left;
    overflow: hidden;
}

.dropdown .dropbtn {
    font-size: 16px;    
    border: none;
    outline: none;
    color: white;
    padding: 14px 16px;
    background-color: inherit;
    font-family: inherit;
    margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
    background-color: red;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    float: none;
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {
    background-color: #ddd;
}

.dropdown:hover .dropdown-content {
    display: block;
}

.footer {
   position: fixed;
   left: 0.5%;
   bottom: 0;
   width: 99%;
   background-color: red;
   color: white;
   text-align: center;
}
</style>

<script type="text/javascript" src="<%=ctxpath%>/resources/js/jquery-3.3.1.min.js"></script>

</head>
<body>

<div class="navbar">
  <a href="<%=ctxpath%>/">메인</a>
  <a href="<%=ctxpath%>/mypoint.action">나의포인트</a>
  <div class="dropdown">
    <button class="dropbtn">글쓰기및목록 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="<%=ctxpath%>/add_notransaction.action">글쓰기(트랜잭션처리안함)</a>
      <a href="<%=ctxpath%>/add_transaction.action">글쓰기(트랜잭션처리함)</a>
      <a href="<%=ctxpath%>/list.action">글목록</a>
    </div>
  </div> 
</div>

<div style="margin-top: 2%; margin-right: 5%; margin-bottom: 2%; margin-left: 5%;">
   




