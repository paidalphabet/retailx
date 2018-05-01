package com.retailx.util;

import com.retailx.entity.Product;
import com.retailx.servlet.RequestAttribute;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.TypeUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class RetailxReflectionHelper {

    private static final Map<Class, Map<String, Field>> classFieldsCache = new ConcurrentHashMap<Class, Map<String, Field>>();

    public static Map<String, Field> getFieldDataMap(Class clazz) {
        if (classFieldsCache.get(clazz) != null) {
            return classFieldsCache.get(clazz);
        }
        Map<String, Field> fieldMap = new HashMap<String, Field>();
        Field[] fields = clazz.getDeclaredFields();
        if (fields != null) {
            for (Field field : fields) {
                RequestAttribute attribute = field.getAnnotation(RequestAttribute.class);
                if (attribute != null) {
                    String fieldName = attribute.name();
                    fieldMap.put(fieldName, field);
                }
            }
        }
        classFieldsCache.put(clazz, fieldMap);
        return fieldMap;
    }

    public static Object populatePersistableObject(Map<String, Field> fieldMap, HttpServletRequest request, Class clazz) throws IllegalAccessException, InstantiationException {
        Object object = clazz.newInstance();
        if (fieldMap != null) {
            Set<String> fieldSet = fieldMap.keySet();
            for (String key : fieldSet) {
                Field field = fieldMap.get(key);
                Object parameterValue = request.getParameter(key);
                if (parameterValue == null) {
                    continue;
                }
                field.setAccessible(true);
                Class fieldType = field.getType();
                ReflectionUtils.setField(field, object, convertToFieldType(fieldType, (String) parameterValue));
            }
        }
        return object;
    }

    private static Object convertToFieldType(Class fieldType, String parameterValue) {
        Class doubleType = Double.TYPE;
        Class integerType = Integer.TYPE;
        Class longType = Long.TYPE;
        Object value = parameterValue;
        if(TypeUtils.isAssignable(fieldType, doubleType)){
            value = Double.parseDouble(parameterValue);
        }
        if(TypeUtils.isAssignable(fieldType, longType)){
            value = Long.parseLong(parameterValue);
        }
        if(TypeUtils.isAssignable(fieldType, integerType)){
            value = Integer.parseInt(parameterValue);
        }
        return value;
    }
}
