package com.retailx.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class HttpRequestUtil<T> {

    @Autowired
    private Environment environment;

    @Autowired
    private GsonBuilder builder;

    public List<T> getRequest(String urlStr, Map<String, String> parameters, Class<T> clazz) {

        try {
            String baseURL = environment.getRequiredProperty("rest.baseurl");
            URL url = new URL(baseURL + urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            StringBuffer output = new StringBuffer("");
            String line = "";
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            while ((line = br.readLine()) != null) {
                output.append(line);
            }
            String op = output.toString();
            if(op.charAt(0) == '[') {
                Gson gson = new GsonBuilder().create();
                List returnData = gson.fromJson(op, List.class);
                return returnData;
            } else if(op.charAt(0) == '{') {
                T object = new GsonBuilder().create().fromJson(op, clazz);
                return Collections.singletonList(object);
            }
            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
