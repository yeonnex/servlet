package me.yeonnex.servlet.web.frontcontroller.v3.controller;

import me.yeonnex.servlet.domain.Member;
import me.yeonnex.servlet.domain.MemberRepository;
import me.yeonnex.servlet.web.frontcontroller.ModelView;
import me.yeonnex.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        List<Member> members = memberRepository.findAll();
        ModelView mv = new ModelView("member-list");
        mv.getModel().put("members", members);
        return mv;
    }
}
