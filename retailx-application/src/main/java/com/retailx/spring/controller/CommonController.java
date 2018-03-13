package com.retailx.spring.controller;

import com.retailx.entity.BaseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class CommonController<BaseObject> extends  BaseController{

    public ResponseEntity<BaseObject >getPersistableObjeect(HttpServletRequest request, HttpServletResponse response){
        return  new ResponseEntity<BaseObject>(HttpStatus.OK);
    }
}
