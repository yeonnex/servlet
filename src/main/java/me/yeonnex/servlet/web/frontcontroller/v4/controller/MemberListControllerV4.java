package me.yeonnex.servlet.web.frontcontroller.v4.controller;

import me.yeonnex.servlet.domain.Member;
import me.yeonnex.servlet.domain.MemberRepository;
import me.yeonnex.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<Member> members = memberRepository.findAll();
        model.put("members", members);

        return "member-list";
    }
}
