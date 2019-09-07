package com.ice.imooc.spring.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 异步 Servlet
 *
 * @author : ACE
 * @date : 2019/9/7
 */
@WebServlet(
        name = "asyncServlet",
        asyncSupported = true,
        urlPatterns = "/async-servlet"
)
public class AsyncServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断是否支持异步
        if (req.isAsyncSupported()) {
            // 创建 AsyncContext
            AsyncContext asyncContext = req.startAsync();
            asyncContext.setTimeout(50L);
            asyncContext.addListener(new AsyncListener() {
                @Override
                public void onComplete(AsyncEvent event) throws IOException {
                    println("执行完成");
                }

                @Override
                public void onTimeout(AsyncEvent event) throws IOException {
                    HttpServletResponse servletResponse = (HttpServletResponse) event.getSuppliedResponse();

                    servletResponse.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
                    println("执行超时");
                }

                @Override
                public void onError(AsyncEvent event) throws IOException {
                    println("执行错误");
                }

                @Override
                public void onStartAsync(AsyncEvent event) throws IOException {
                    println("开始执行");
                }
            });

            println("Hello World");

//            ServletResponse servletResponse = asyncContext.getResponse();
//
//            servletResponse.setContentType("text/plain;charset=UTF-8");
//            PrintWriter printWriter = servletResponse.getWriter();
//            printWriter.println("AsyncServlet Hello World");
//            printWriter.flush();

        }

    }

    private static void println(Object object) {
        System.out.println("AsyncServlet [" + Thread.currentThread().getName() + "]: " + object);
    }
}
