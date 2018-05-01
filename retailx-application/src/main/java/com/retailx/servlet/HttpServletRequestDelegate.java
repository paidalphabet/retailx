package com.retailx.servlet;

import com.retailx.entity.PersistableObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;

public class HttpServletRequestDelegate {

    private static HttpServletRequestDelegate INSTANCE = new HttpServletRequestDelegate();
    private static HttpServletRequestProcessor productProcessor = new ProductHttpServletRequestProcessor();

    public static HttpServletRequestDelegate getInstance() {
        return INSTANCE;
    }

    public ResponseEntity<List<PersistableObject>> processHttpRequest(HttpServletRequest request, HttpServletResponse response) {
        return new ResponseEntity(Collections.singletonList(productProcessor.process(request, response)), HttpStatus.OK);
    }
}
