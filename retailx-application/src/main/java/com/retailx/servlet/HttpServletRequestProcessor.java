package com.retailx.servlet;

import com.retailx.entity.PersistableObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HttpServletRequestProcessor {

    public static String CLASS = "class";

    public boolean isApplicable(HttpServletRequest request);

    public PersistableObject process(HttpServletRequest request, HttpServletResponse response);

}
