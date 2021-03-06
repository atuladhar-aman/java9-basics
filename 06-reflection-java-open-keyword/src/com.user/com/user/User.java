package com.user;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class User {
    public static void main(String[] args) throws Exception{
    
        Class<?> exportedClass = Class.forName("com.exported.Exported");
        Constructor<?> con = exportedClass.getDeclaredConstructor();
        con.setAccessible(true);
        Object exportedObj = con.newInstance();

        Method m;

        m = exportedObj.getClass().getMethod("callMe");
        m.setAccessible(true);
        System.out.println("Public : " + m.invoke(exportedObj));

        m = exportedObj.getClass().getDeclaredMethod("callMePrivate");
        m.setAccessible(true);
        System.out.println("Private : " + m.invoke(exportedObj));
        
        // m = exportedObj.getClass().getDeclaredMethod("callMePrivateStatic");
        // m.setAccessible(true);
        // System.out.println("Private Static : " + m.invoke(exportedObj));
    }
}