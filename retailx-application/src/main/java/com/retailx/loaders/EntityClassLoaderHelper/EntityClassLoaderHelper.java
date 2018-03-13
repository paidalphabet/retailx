package com.retailx.loaders.EntityClassLoaderHelper;

import com.retailx.entity.BaseObject;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EntityClassLoaderHelper {

    private static Map<String, Class> classMap = new HashMap<String ,Class>();

    static {
        Reflections reflections = new Reflections("com.retailx.entity");
        Set<Class<? extends BaseObject>> allClasses = reflections.getSubTypesOf(BaseObject.class);
        for(Class aClass : allClasses){

        }
    }

    public static Class getClassFromPath(String path) {
        return classMap.get(path);
    }
}
