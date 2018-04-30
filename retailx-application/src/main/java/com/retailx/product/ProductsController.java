package com.retailx.product;

import com.retailx.config.HttpRequestUtil;
import com.retailx.entity.Product;
import com.retailx.http.request.ReturnStub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class ProductsController {

    private String ALL_PRODUCTS = "product/productDetails";

    @Autowired
    private HttpRequestUtil<Product> requestUtil;

    @RequestMapping(value="/view/products/", method = RequestMethod.GET)
    public Object getProductPage(HttpServletRequest request, HttpServletResponse response){
        //List<Product> products = requestUtil.getRequest("/product/", null, Product.class);
        List<Product> products = null;
        ModelMap productPageModels = new ModelMap();
        productPageModels.put("products", products);
        return new ReturnStub<Product>(ALL_PRODUCTS, products, request, productPageModels).response();
    }

    @RequestMapping(value="/product/code/", method = RequestMethod.GET)
    @ResponseBody
    public String getAllProducts(HttpServletRequest request, HttpServletResponse response){
        String code = String.valueOf(Calendar.getInstance().getTimeInMillis());
        return code;
    }
}
