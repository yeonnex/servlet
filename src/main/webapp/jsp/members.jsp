<%@ page import="me.yeonnex.servlet.domain.MemberRepository" %>
<%@ page import="me.yeonnex.servlet.domain.Member" %>
<%@ page import="java.util.List" %><%
  MemberRepository memberRepository = MemberRepository.getInstance();
  List<Member> all = memberRepository.findAll();
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
  <title></title></head>
<body>

<table>
  <thead>
    <tr>
      <th>id</th>
      <th>username</th>
      <th>age</th>
    </tr>
  </thead>
  <tbody>
  <%
    for (Member member : all) {
      out.write("<tr>");
      out.write(" <td>" + member.getId() + "</td>");
      out.write(" <td>" + member.getUsername() + "</td>");
      out.write(" <td>" + member.getAge() + "</td>");
      out.write("</tr>");
    }
  %>
  </tbody>
</table>

</body>
</html>
