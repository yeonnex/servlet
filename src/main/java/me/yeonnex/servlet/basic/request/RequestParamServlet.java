package me.yeonnex.servlet.basic.request;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

/**
 * URL 쿼리 파라미터 뿐만 아니라, HTML FORM 방식으로 전송한 데이터도 request.getParameter(...) 로 값 추출이 가능하다.
 *
 * <ul>
 * <li>curl -X GET "http://localhost:8080/request-param?username=seoyeon&age=24"</li><br/>
 * <li>curl -X POST http://localhost:8080/request-param -H "Content-Type: application/x-www-form-urlencoded" -d "username=seoyeon&age=24"</li>
 * </ul>
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("[전체 파라미터 조회]");
        req.getParameterNames().asIterator()
                .forEachRemaining((name) -> System.out.println(name + "=" + req.getParameter(name)));

        System.out.println("[단일 파라미터 조회]");
        System.out.println(req.getParameter("username"));
        System.out.println(req.getParameter("age"));

        System.out.println("[이름이 같은 파라미터 조회]");
        String queryParam = "username";
        String[] usernames = req.getParameterValues(queryParam);
        Arrays.stream(usernames).iterator()
                .forEachRemaining((value) -> System.out.println(queryParam + "=" + value));

        resp.getWriter().write("OK");
    }
}
