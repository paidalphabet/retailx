package com.retailx.http.request;

import org.apache.commons.lang.StringUtils;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ReturnStub<E> {

    private List<E> data;

    private E datum;

    private String responseType;

    private ModelMap modelMap;

    private String view;

    public ReturnStub(String view, List<E> data, HttpServletRequest request, ModelMap modelMap) {
        String responseType = request.getParameter("responseType");
        this.responseType = responseType;
        this.data = data;
        this.datum = getDatum(data);
        this.view = view;
        this.modelMap = modelMap;
    }

    private E getDatum(List<E> data) {
        E datum = null;
        if (data != null && data.size() == 1) {
            datum = data.iterator().next();
        }
        return datum;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }

    public E getDatum() {
        return datum;
    }

    public void setDatum(E datum) {
        this.datum = datum;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public ModelMap getModelMap() {
        return modelMap;
    }

    public void setModelMap(ModelMap modelMap) {
        this.modelMap = modelMap;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public Object response(){
        if(StringUtils.equalsIgnoreCase("json", this.responseType)){
            if(datum != null){
                return datum;
            }
            else{
                return data;
            }
        }else{
            return new ModelAndView(this.view, modelMap);
        }
    }

}
