package me.yeonnex.servlet.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.yeonnex.servlet.domain.Member;
import me.yeonnex.servlet.domain.MemberRepository;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Member> all = memberRepository.findAll();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write("""
                <table>
                    <thead>
                        <th>id</th>
                        <th>username</th>
                        <th>age</th>
                    </thead>
                    """);
        for (Member member : all) {
            writer.write("<tr><td>" + member.getId() + "</td>");
            writer.write("<td>" + member.getUsername() + "</td>");
            writer.write("<td>" + member.getAge() + "</td></tr>");
        }
        writer.write("""
                <tbody>
                </table>
                """);
    }
}
