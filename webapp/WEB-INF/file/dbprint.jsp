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
	<img src="/springExam/res/img/pic1.jpg"/>
<%

List<SpringPracDTO> list = (List<SpringPracDTO>)request.getAttribute("dblist"); // controller에서는 model로 줬어도 받을때는 request로 받는


for(int i=0; i<list.size(); i++){
	%>
	
	<div><%=list.get(i).getId()%></div>
	<div><%=list.get(i).getName()%></div>
	<div><%=list.get(i).getGender()%></div>
	<div><%=list.get(i).getEmail()%></div>
	<div><%=list.get(i).getCellnum()%></div>
	<div>
	<a href="/springExam/deletedata?&id=<%=list.get(i).getId()%>"><input type="button" name="deletebtn" value="삭제"></a>
	<a href="/springExam/insert"><input type="button" name="insertbtn" value="등록"></a>
	<a href="/springExam/updateform?id=<%=list.get(i).getId()%>"><input type="button" name="updatebtn" value="수정"></a>
	</div>

		<%
}
%>

<!--  http://localhost:8080/springExam/ 웹 구동시 최초의 url은 wabapp이다. -->
</body>
</html>