<%@page import="com.green.spring.vo.SpringPracDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/springExam/updatedata" method="post">
	
	<%List<SpringPracDTO> list = (List<SpringPracDTO>)request.getAttribute("dblist");  
	for(int i=0;i<list.size(); i++){
	%>
		<div>ID :<input type="text" name ="id" value = "<%=list.get(i).getId() %>" readonly></div>	
		<div>NAME :<input type="text" name ="name" value="<%=list.get(i).getName()%>"></div>
		<div>GENDER :<input type="text" name ="gender" value="<%=list.get(i).getGender()%>"></div>
		<div>E-MAIL :<input type="text" name ="email" value="<%=list.get(i).getEmail()%>"></div>
		<div>CELLNUM :<input type="text" name ="cellnum" value="<%=list.get(i).getCellnum()%>"></div>
		<div><input type="submit" value="데이터 입력"></div>
	<%	
	}
	%>
				
	</form>
</body>
</html>