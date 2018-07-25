<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="header.jsp" />

<style type="text/css">
	table, th, td, input, textarea {border: solid gray 1px;}
	
	#table {border-collapse: collapse;
	 		width: 50%;
	 		}
	#table th, #table td{padding: 5px;}
	#table th{width: 20%; background-color: #DDDDDD;}
	#table td{width: 80%;}
	.long {width: 98%; height: 25px;}
	.short {width: 50%; height: 25px;} 		
</style>

<script type="text/javascript">
	$(document).ready(function(){
		$("#writerid").val("${sessionScope.loginuser}");
	});

	function goWrite() {
		var frm = document.writeFrm;
		frm.action = "addEnd_notransaction.action";
		frm.method = "post";
		frm.submit();
	}
</script>

<div>
	<h1>트랜잭션처리안함 : 글쓰기</h1>
	
	<form name="writeFrm">
		<table id="table">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="writerid" id="writerid" class="short" /></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input type="text" name="title" class="long" /></td>
			</tr>
			<tr>
            	<th>내용</th>
            	<td><textarea name="content" class="long" style="height: 200px;"></textarea></td>
         	</tr>
		</table>
		<br/>
		
		<button type="button" onClick="goWrite();">완료</button>
		<button type="button" onClick="history.back();">취소</button>
		<button type="button" onClick="javascript:location.href='list.action'">글목록</button>
	</form>

</div>
<jsp:include page="footer.jsp" />
