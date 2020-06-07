package com.lover.web.web.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 基础Servlet，用于使开发人员专注于方法，而不用写许多的Servlet
 * 该类的其他说明：
 * 1、在前端给出方法method，在BaseServlet的service方法中查询子类中有没有method名称的方法，有则执行/没有则报错没有改方法
 * 2、若method方法为null或者""，则执行默认方法 execute
 */
public class BaseServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String method = request.getParameter("method");
        if(method == null || "".equals(method) || "".equals(method.trim())){
            method = "execute";
        }
        Class<? extends BaseServlet> clazz = this.getClass();//子类字节码
        try {
            Method ms = clazz.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            if(ms != null){
                String jspPath = (String)ms.invoke(this, request,response);
                if(jspPath != null){
                    request.getRequestDispatcher(jspPath).forward(request, response);//请求转发
                }
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("在类中找不到"+method+"方法");
        } catch (IllegalAccessException e) {
            throw new RuntimeException("IllegalAccessException");
        } catch (InvocationTargetException e) {
            throw new RuntimeException("InvocationTargetException");
        }
    }

    // 默认方法
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行了默认方法...");
        return null;
    }
}
