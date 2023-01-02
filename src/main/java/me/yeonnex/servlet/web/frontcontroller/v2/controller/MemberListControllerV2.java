package me.yeonnex.servlet.web.frontcontroller.v2.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.yeonnex.servlet.domain.Member;
import me.yeonnex.servlet.domain.MemberRepository;
import me.yeonnex.servlet.web.frontcontroller.MyView;
import me.yeonnex.servlet.web.frontcontroller.v2.ControllerV2;

import java.util.List;

public class MemberListControllerV2 implements ControllerV2 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest req, HttpServletResponse resp) {
        List<Member> members = memberRepository.findAll();
        req.setAttribute("members", members);
        return new MyView("/WEB-INF/views/member-list.jsp");
    }
}
