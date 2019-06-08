package main.ru.geekbrains.Lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HomeWork7Test<T> {

    public static void start(Class<?> clazz) {

        Method[] arrMethods = clazz.getDeclaredMethods();

        Method methodBefore = null;
        Method methodAfter = null;
        List<Method> methodList = new ArrayList<>();

        for (Method method : arrMethods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (methodBefore == null) {
                    methodBefore = method;
                } else {
                    throw new RuntimeException();
                }
            } else if (method.isAnnotationPresent(AfterSuite.class)) {
                if (methodAfter == null) {
                    methodAfter = method;
                } else {
                    throw new RuntimeException();
                }
            } else if (method.isAnnotationPresent(Test.class)) {
                methodList.add(method);
            }
        }
        methodList.sort(Comparator.comparing(g -> g.getAnnotation(Test.class).priority()));

        System.out.println("Печать методов");
        HomeWork7 hw7 = new HomeWork7();

        try {
            System.out.println(methodBefore.invoke(hw7,10, 5));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        for (Method method : methodList) {
            try {
                System.out.println(method.invoke(hw7, 10, 5));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        try {
            System.out.println(methodAfter.invoke(hw7, 10, 5));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        start(HomeWork7.class);
    }

}

