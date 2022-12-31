package me.yeonnex.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import me.yeonnex.servlet.basic.HelloData;

import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
@RequiredArgsConstructor
public class ResponseJsonServlet extends HttpServlet {
    private final ObjectMapper objectMapper;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");
        HelloData data = new HelloData();
        data.setUsername("seoyeon");
        data.setAge(24);
        // {"username":"seoyeon", "age":24}
        String result = objectMapper.writeValueAsString(data);

        resp.getWriter().write(result);
    }
}
