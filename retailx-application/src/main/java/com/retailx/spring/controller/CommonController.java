package com.retailx.spring.controller;

import com.retailx.entity.BaseObject;
import com.retailx.entity.PersistableObject;
import com.retailx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class CommonController<BaseObject> extends  BaseController{

    Logger logger = Logger.getLogger(getClass().getName());
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/common/")
    public ResponseEntity<List<PersistableObject>> getPersistableObject(HttpServletRequest request, HttpServletResponse response){
        try{
            validateResponse(request);
        }catch(AssertionError e) {
            logger.info("Class name not found in the request");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        Class clazz = (Class) request.getAttribute("class");
        List<PersistableObject> objects = userService.getObjects(clazz);
        return  new ResponseEntity<List<PersistableObject>>(objects, HttpStatus.OK);
    }

    private void validateResponse(HttpServletRequest request) {
        Class clazz = (Class) request.getAttribute("class");
        Assert.notNull(clazz);
    }


}
