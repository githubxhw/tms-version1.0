package com.lover.web.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class GenericEncodingFilter implements Filter {

    private static String encoding = "UTF-8";//默认

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String tempEncoding = filterConfig.getInitParameter("CharacterEncoding");
        if(tempEncoding!=null){
            encoding = tempEncoding;
        }
        //System.out.println("init...\nencoding="+encoding);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //System.out.println("doFilter");
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        MyRequest myRequest = new MyRequest(request,encoding);//对request进行了增强
        filterChain.doFilter(myRequest,servletResponse);
    }

    @Override
    public void destroy() {
        //System.out.println("destroy");
    }


}

class MyRequest extends HttpServletRequestWrapper {

    private HttpServletRequest request;
    private String encoding;

    private boolean hasEncode;

    public MyRequest(HttpServletRequest request,String encoding) {
        super(request);// super必须写
        this.request = request;
        this.encoding = encoding;
    }

    // 对需要增强方法 进行覆盖
    @Override
    public Map getParameterMap() {
        // 先获得请求方式
        String method = request.getMethod();
        if (method.equalsIgnoreCase("post")) {
            // post请求
            try {
                // 处理post乱码
                request.setCharacterEncoding(encoding);
                return request.getParameterMap();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else if (method.equalsIgnoreCase("get")) {
            // get请求
            Map<String, String[]> parameterMap = request.getParameterMap();
            if (!hasEncode) { // 确保get手动编码逻辑只运行一次
                for (String parameterName : parameterMap.keySet()) {
                    String[] values = parameterMap.get(parameterName);
                    if (values != null) {
                        for (int i = 0; i < values.length; i++) {
                            try {
                                // 处理get乱码
                                values[i] = new String(values[i]
                                        .getBytes("ISO-8859-1"), encoding);
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                hasEncode = true;
            }
            //..还有其他的请求方式
            return parameterMap;
        }
        return super.getParameterMap();
    }

    @Override
    public String getParameter(String name) {
        Map<String, String[]> parameterMap = getParameterMap();
        String[] values = parameterMap.get(name);
        if (values == null) {
            return null;
        }
        return values[0]; // 取回参数的第一个值
    }

    @Override
    public String[] getParameterValues(String name) {
        Map<String, String[]> parameterMap = getParameterMap();
        String[] values = parameterMap.get(name);
        return values;
    }

}
