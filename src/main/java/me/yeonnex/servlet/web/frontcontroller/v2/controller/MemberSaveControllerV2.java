package me.yeonnex.servlet.web.frontcontroller.v2.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.yeonnex.servlet.domain.Member;
import me.yeonnex.servlet.domain.MemberRepository;
import me.yeonnex.servlet.web.frontcontroller.MyView;
import me.yeonnex.servlet.web.frontcontroller.v2.ControllerV2;

public class MemberSaveControllerV2 implements ControllerV2 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        Integer age = Integer.parseInt(req.getParameter("age"));
        Member member = new Member(username, age);
        memberRepository.save(member);

        req.setAttribute("member", member);

        return new MyView("/WEB-INF/views/save-result.jsp");
    }
}
