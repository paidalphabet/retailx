package com.retailx.servlet;

import com.retailx.entity.PersistableObject;
import com.retailx.entity.Product;
import com.retailx.util.RetailxReflectionHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.util.Map;

public class ProductHttpServletRequestProcessor implements HttpServletRequestProcessor {

    @Override
    public boolean isApplicable(HttpServletRequest request) {
        boolean isApplicable = false;
        String clazz = (String) HttpServletRequestWrapperImpl.getInstance().getAttribute(request, CLASS, String.class);
        if(clazz.equals(Product.class.getName())){
            isApplicable = true;
        }
        return isApplicable;
    }

    @Override
    public PersistableObject process(HttpServletRequest request, HttpServletResponse response) {
        Product product = createProductObjectFromRequest(request);
        return product;
    }

    private Product createProductObjectFromRequest(HttpServletRequest request) {
        Map<String, Field> fieldMap = RetailxReflectionHelper.getFieldDataMap(Product.class);
        Product product = null;
        try {
            product = (Product) RetailxReflectionHelper.populatePersistableObject(fieldMap, request, Product.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return product;
    }
}
