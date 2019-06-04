package main.ru.geekbrains.Lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HomeWork7Test {

    public static void start(Class clazz) {

        Method[] arrMethods = clazz.getDeclaredMethods();
        System.out.println("Массив до сортировки");
        for(int i = 0; i<arrMethods.length; i++) {
            System.out.println("arrMethods[" + i + "] :" + arrMethods[i].getName());
        }

        findBefore(arrMethods);
        findAfter(arrMethods);
        sortTest(arrMethods);

        System.out.println("Массив после сортировки");
        for(int i = 0; i<arrMethods.length; i++) {
            System.out.println("arrMethods["+i+"] :" + arrMethods[i].getName());
        }

        System.out.println("Печать методов");
        HomeWork7 hw7 = new HomeWork7();
        for (Method method : arrMethods) {
            try {
                System.out.println(method.invoke(hw7, 10, 5));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    private static void findBefore(Method[] arrMethods) {
        int count = 0;
        for (int i = 0; i < arrMethods.length; i++) {
            if (arrMethods[i].isAnnotationPresent(BeforeSuite.class)) {
                count++;
            }
        }
        if (count ==1) {
            for (int i = 0; i < arrMethods.length; i++) {
                if (arrMethods[i].isAnnotationPresent(BeforeSuite.class)) {
                    Method buf = arrMethods[0];
                    arrMethods[0] = arrMethods[i];
                    arrMethods[i] = buf;
                }
            }
        } else {
            throw new RuntimeException();
        }

    }

    private static void findAfter(Method[] arrMethods) {
        int count = 0;
        for (int i = 0; i < arrMethods.length; i++) {
            if (arrMethods[i].isAnnotationPresent(AfterSuite.class)) {
                count++;
            }
        }
        if (count ==1) {
            for (int i = 0; i < arrMethods.length; i++) {
                if (arrMethods[i].isAnnotationPresent(AfterSuite.class)) {
                    Method buf = arrMethods[arrMethods.length - 1];
                    arrMethods[arrMethods.length - 1] = arrMethods[i];
                    arrMethods[i] = buf;
                }
            }
        } else {
            throw new RuntimeException();
        }

    }

    private static void sortTest(Method[] arrMethods) {
        for (int i = arrMethods.length - 2; i >= 1; i--) {
            if (arrMethods[i].isAnnotationPresent(Test.class)) {
                for (int j = 1; j < i; j++) {
                    int priorPrev = arrMethods[j].getAnnotation(Test.class).priority();
                    Test testAnnotationNext = arrMethods[j + 1].getAnnotation(Test.class);
                    int priorNext = testAnnotationNext.priority();
                    if (priorPrev > priorNext) {
                        Method buf = arrMethods[j];
                        arrMethods[j] = arrMethods[j + 1];
                        arrMethods[j + 1] = buf;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        start(HomeWork7.class);
    }

}

