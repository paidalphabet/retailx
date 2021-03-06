package com.retailx.servlet;

import com.retailx.loaders.EntityClassLoaderHelper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RequestDispatcher implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       if(servletRequest instanceof HttpServletRequest) {
           HttpServletRequest request = (HttpServletRequest) servletRequest;
           String requestURI = request.getRequestURI();
           String applicationName = request.getContextPath();
           String path = request.getServletPath();
           path = path.replaceAll("/data/", "");
           Class className = getClassFromPath("/" + path);
           if(className != null) {
               request.setAttribute("class", className);
               javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("/common/");
               dispatcher.forward(servletRequest, servletResponse);
           }
       }
       filterChain.doFilter(servletRequest, servletResponse);
    }

    private Class getClassFromPath(String path) {
        return EntityClassLoaderHelper.getClassFromPath(path);
    }

    @Override
    public void destroy() {

    }
}
