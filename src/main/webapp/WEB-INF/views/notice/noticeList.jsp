<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>noticeList</title>
<script type="text/javascript">
	var m = '${message}'; //redirect로 받은 message 임 
	if( m != ''){
		alert(m); // 들어있으면 알려주세요
	}
</script>
</head>
	<body>
		<h1>noticeList PAGE / 현재위치 /ex1/notice</h1>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>NUM</th>
					<th>TITLE</th>
					<th>WRITER</th>
					<th>REG_DATE</th>
					<th>HIT</th>
				</tr>
			</thead>
	   		<tbody>
				<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.num}</td>
					<td><a href="noticeView?num=${dto.num}">${dto.title}</a></td>
					<td>${dto.writer}</td>
					<td>${dto.reg_date}</td>
					<td>${dto.hit}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<a href="./noticeWrite">글쓰기</a>
		<a href="../">뒤로가기</a>
		
	</body>
</html>