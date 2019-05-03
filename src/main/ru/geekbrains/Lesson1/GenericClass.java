package main.ru.geekbrains.Lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericClass<T> {

    public static void main(String[] args) {
        String[] strArr = {"Sasha", "Masha", "Petya", "Vasya"};
        Integer[] intArr = {1,2,3,4,5};
        Sample[] sampleArr = {new Sample("первый"), new Sample("второй"), new Sample("третий")};

        changeElements(strArr);
        changeElements(intArr);
        changeElements(sampleArr);

        for (String str: strArr)
        System.out.print(str +" ");
        System.out.println();

        for (Integer str: intArr)
        System.out.print(str +" ");
        System.out.println();

        for (Sample str: sampleArr)
        System.out.print(str.toString() +" ");
        System.out.println();

        System.out.println(elementToArrayList(strArr).get(0).getClass().getName());
        System.out.println(elementToArrayList(intArr).get(0).getClass().getName());
        System.out.println(elementToArrayList(sampleArr).get(0).getClass().getName());

    }

    private static <T> ArrayList<T> elementToArrayList(T[] arr) {
        ArrayList<T> list = new ArrayList<T>(Arrays.asList(arr));
        return list;
    }

    public static <T> T[] changeElements (T[] sample) {
        T second;
        second = sample[1];
        sample[1]=sample[0];
        sample[0]=second;

        return sample;
    }

}