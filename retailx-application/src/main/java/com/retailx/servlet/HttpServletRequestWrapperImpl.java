package com.retailx.servlet;

import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;

public class HttpServletRequestWrapperImpl implements HttpServletRequestWrapper {


    private static final HttpServletRequestWrapper INSTANCE = new HttpServletRequestWrapperImpl();

    private HttpServletRequestWrapperImpl() {

    }

    public static HttpServletRequestWrapper getInstance() {
        return INSTANCE;
    }

    @Override
    public Object getAttribute(HttpServletRequest request, String attributeName, Class clazz) {
        Assert.notNull(request);
        Assert.notNull(attributeName);
        return (clazz.cast(request.getAttribute(attributeName)));
    }

    @Override
    public void setAttribute(HttpServletRequest request, String attributeName, String attributeValue) {
        Assert.notNull(request);
        Assert.notNull(attributeName);
        Assert.notNull(attributeValue);
        request.setAttribute(attributeName, attributeValue);
    }
}
