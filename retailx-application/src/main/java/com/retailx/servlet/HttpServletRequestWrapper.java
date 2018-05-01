package com.retailx.servlet;

import javax.servlet.http.HttpServletRequest;

public interface HttpServletRequestWrapper {

    /**
     * @param attributeName attributeName to be retrieved.
     * @param clazz
     */
    public Object getAttribute(final HttpServletRequest request, final String attributeName, Class clazz);

    /**
     * @param attributeName attribute name whose value is to be set
     * @param attributeValue the value to be set
     */
    void setAttribute(final HttpServletRequest request, final String attributeName, final String attributeValue);

}
