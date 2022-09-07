package com.mycompany.microspring;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author jose.gamboa
 */
public class MicroJunit {

    public static void main(String... args) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String className = args[0];
        Class c = Class.forName(className);
        Method[] declareMethods = c.getDeclaredMethods();

        int passed = 0, failed = 0;

        for (Method m : declareMethods) {
            if (m.isAnnotationPresent(Test.class)) {
                try {
                    System.out.println("Invoking: " + m.getName() + " in class " + c.getName());
                    m.invoke(null);
                    passed = passed + 1;
                } catch (Exception e) {
                    failed = failed + 1;
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Passed: " + passed + ", Failed: " + failed);
    }

}
