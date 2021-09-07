<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/springExam/insertdata" method="post">
		
		<div>ID :<input type="text" name ="id"></div>
		<div>NAME :<input type="text" name ="name"></div>
		<div>GENDER :<input type="text" name ="gender"></div>
		<div>E-MAIL :<input type="text" name ="email"></div>
		<div>CELLNUM :<input type="text" name ="cellnum"></div>
		<div><input type="submit" value="데이터 입력"></div>
		
	</form>
</body>
</html>