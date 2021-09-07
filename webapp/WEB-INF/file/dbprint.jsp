<%@page import="com.green.spring.vo.SpringPracDTO"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

<%

List<SpringPracDTO> list = (List<SpringPracDTO>)request.getAttribute("dblist"); // controller에서는 model로 줬어도 받을때는 request로 받는


for(int i=0; i<list.size(); i++){
	%>
	
	<div><%=list.get(i).getId()%></div>
	<div><%=list.get(i).getName()%></div>
	<div><%=list.get(i).getGender()%></div>
	<div><%=list.get(i).getEmail()%></div>
	<div><%=list.get(i).getCellnum()%></div>
	<div><input type="button" name="deletebtn" value="삭제"></div>

		<%
}
%>
</body>
</html>