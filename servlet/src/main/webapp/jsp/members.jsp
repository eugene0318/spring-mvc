<%@page import="hello.servlet.domain.Member"%>
<%@page import="java.util.List"%>
<%@page import="hello.servlet.domain.MemberRepository"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<%
MemberRepository memberRepository = MemberRepository.getInstance();
List<Member> members = memberRepository.findAll();
%>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<a href="/index.html">메인</a>
	<table>
		<thead>
			<th>id</th>
			<th>username</th>
			<th>age</th>
		</thead>
		<tbody>
			<%
			for (Member member : members) {
				out.write(" <tr>");
				out.write(" <td>" + member.getId() + "</td>");
				out.write(" <td>" + member.getUsername() + "</td>");
				out.write(" <td>" + member.getAge() + "</td>");
				out.write(" </tr>");
			}
			%>
		</tbody>
	</table>
</body>
</html>