package com.epam.testapp.util.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private String encoding;
    private final String UTF = "utf-8";
    private final String ENCOD = "requestEncoding";
    private final String CONT_TYPE = "text/html; charset=UTF-8";

    @Override
    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter(ENCOD);
        if (encoding == null)
            encoding = UTF;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next) throws IOException, ServletException {
        response.setContentType(CONT_TYPE);
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        next.doFilter(request, response);
    }


    //    un supported
    @Override
    public void destroy() {

    }
}