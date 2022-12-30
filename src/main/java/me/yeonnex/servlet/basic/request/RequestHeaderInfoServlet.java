package me.yeonnex.servlet.basic.request;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "requestInfoServlet", urlPatterns = "/header-info")
public class RequestHeaderInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        printStartLine(req);
        printHeaders(req);
        resp.getWriter().write("OK");
    }

    private void printHeaders(HttpServletRequest req) {
        System.out.println("--- REQUEST-HEADER ---");
        req.getHeaderNames()
                .asIterator()
                .forEachRemaining((headerName) -> System.out.println(headerName + ":" + req.getHeader(headerName)));
        System.out.println("--- REQUEST-HEADER ---");
    }

    private void printStartLine(HttpServletRequest req) {
        System.out.println("--- REQUEST-LINE ---");
        System.out.println("req.getMethod() = " + req.getMethod()); // GET
        System.out.println("req.getProtocol() = " + req.getProtocol()); // HTTP/1.1
        System.out.println("req.getScheme() = " + req.getScheme()); // http
        System.out.println("req.getRequestURL() = " + req.getRequestURL()); // http://localhost:8080/header-info
        System.out.println("req.getRequestURI() = " + req.getRequestURI()); // /header-info
        System.out.println("req.getQueryString() = " + req.getQueryString()); // username=seoyeon
        System.out.println("req.isSecure() = " + req.isSecure()); // false
        System.out.println("--- REQUEST-LINE ---");
    }
}
