<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>result</title>
</head>
<body>
<script type="text/javascript">
	alert("${message}");
	location.href="./noticeList?curPage=1"; //전부 controller에 가는 것을 기억하세요
</script>
</body>
</html>