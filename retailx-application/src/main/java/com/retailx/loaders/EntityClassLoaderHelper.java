package com.retailx.loaders;

import com.retailx.entity.BaseObject;
import com.retailx.entity.PersistableObject;
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
            System.out.println(aClass);
            //if (aClass.isAssignableFrom(PersistableObject.class)){
                try {
                    System.out.println("Assignable From");
                    PersistableObject object = (PersistableObject) aClass.newInstance();
                    classMap.put(object.getRequestPath(), aClass);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            //}
        }
    }

    public static Class getClassFromPath(String path) {
        return classMap.get(path);
    }
}
