package com.retailx.product;

import com.retailx.config.HttpRequestUtil;
import com.retailx.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductsController {

    private String ALL_PRODUCTS = "product/allProducts";

    @Autowired
    private HttpRequestUtil<Product> requestUtil;

    @RequestMapping(value="/products/", method = RequestMethod.GET)
    public ModelAndView getAllProducts(){
        List<Product> products = requestUtil.getRequest("/product/", null, Product.class);
        return new ModelAndView(ALL_PRODUCTS);
    }
}
