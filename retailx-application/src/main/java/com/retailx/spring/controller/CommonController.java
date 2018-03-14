package com.retailx.spring.controller;

import com.retailx.entity.BaseObject;
import com.retailx.entity.PersistableObject;
import com.retailx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@Controller
public class CommonController<BaseObject> extends  BaseController{

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/common/")
    public ResponseEntity<BaseObject> getPersistableObject(HttpServletRequest request, HttpServletResponse response){
        Class clazz = (Class) request.getAttribute("class");
        List<PersistableObject> objects = userService.getObjects(clazz);
        return  new ResponseEntity<BaseObject>(HttpStatus.OK);
    }
}
