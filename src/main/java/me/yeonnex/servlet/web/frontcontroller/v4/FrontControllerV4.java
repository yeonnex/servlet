package me.yeonnex.servlet.web.frontcontroller.v4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.yeonnex.servlet.web.frontcontroller.MyView;
import me.yeonnex.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import me.yeonnex.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import me.yeonnex.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "fromControllerV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerV4 extends HttpServlet {
    private final Map<String, ControllerV4> controllerMap = new HashMap<>();

    public FrontControllerV4() {
        controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        controllerMap.put("/front-controller/v4/members", new MemberListControllerV4());
    }

    private static MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private static void createParamMap(HttpServletRequest req, Map<String, String> paramMap) {
        req.getParameterNames().asIterator().forEachRemaining(name -> paramMap.put(name, req.getParameter(name)));
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        ControllerV4 controller = controllerMap.get(requestURI);
        Map<String, String> paramMap = new HashMap<>();
        createParamMap(req, paramMap);

        HashMap<String, Object> model = new HashMap<>();
        String viewName = controller.process(paramMap, model);
        MyView mv = viewResolver(viewName);
        mv.render(model, req, resp);
    }
}
