package me.yeonnex.servlet.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import me.yeonnex.servlet.domain.Member;
import me.yeonnex.servlet.domain.MemberRepository;

import java.io.IOException;

@WebServlet(name = "memberSaveServlet", urlPatterns = "/servlet/members/save")
@RequiredArgsConstructor
public class MemberSaveServlet extends HttpServlet {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        Integer age = Integer.parseInt(req.getParameter("age"));
        Member member = new Member();
        member.setUsername(username);
        member.setAge(age);
        memberRepository.save(member);

        resp.getWriter().write("OK");
    }
}
