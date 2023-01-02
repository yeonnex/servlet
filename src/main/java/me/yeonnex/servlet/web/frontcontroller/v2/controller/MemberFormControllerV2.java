package me.yeonnex.servlet.web.frontcontroller.v2.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.yeonnex.servlet.web.frontcontroller.MyView;
import me.yeonnex.servlet.web.frontcontroller.v2.ControllerV2;

public class MemberFormControllerV2 implements ControllerV2 {
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) {
        return new MyView("/WEB-INF/views/new-form.jsp");
    }
}
