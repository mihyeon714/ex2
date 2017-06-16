<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
table, th, td{
	text-align: center;
	font-size: 15px;	
}

input{
	border-style: none;
	width:50%;
	height: 100%;
}
</style>
<title>noticeWrite</title>
</head>
<body>
	<h1>noticeWrite Form PAGE</h1>
	<form action="notice${path}" method="POST">
		<input type="hidden" name="num" value="${dto.num}">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>TITLE</th>
					<th>WRITER</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" name="title" value="${dto.title}"></td>
					<td><input type="text" name="writer" value="${dto.writer}"></td>
				</tr>
			</tbody>
			<thead>
				<tr>
					<th colspan="2">CONTENTS</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="2"><input type="text" name="contents" value="${dto.contents}"></td>
				</tr>
				<tr>
					<td colspan="2"><button>글쓰기</button></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>