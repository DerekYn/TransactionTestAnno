<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="header.jsp" />

<script type="text/javascript">
	alert("${msg}");
	location.href="${loc}";
</script>
    
<jsp:include page="footer.jsp" />    