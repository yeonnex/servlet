<%@ page import="me.yeonnex.servlet.domain.MemberRepository" %>
<%@ page import="me.yeonnex.servlet.domain.Member" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
  // jsp 도 최종적으로 서블릿으로 자동으로 변환되기 때문에 문법상 HttpServletRequest 와 HttpServletResponse 를 쓸 수 있다
  MemberRepository memberRepository = MemberRepository.getInstance();
  String username = request.getParameter("username");
  Integer age = Integer.parseInt(request.getParameter("age"));

  Member member = new Member(username, age);
  memberRepository.save(member);
%>
<html>
<head>
  <title>Title</title>
</head>
<body>
<p>성공</p>
<ul>
  <li>id=<%=member.getId()%></li>
  <li>username=<%=member.getUsername()%></li>
  <li>age=<%=member.getAge()%></li>
</ul>
</body>
</html>
