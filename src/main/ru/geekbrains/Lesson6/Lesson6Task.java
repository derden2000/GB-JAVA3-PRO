package main.ru.geekbrains.Lesson6;

import java.util.*;

public class Lesson6Task {

    public static int[] arrModify(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer num : arr) {
            list.add(num);
        }
        if (!list.contains(4)) {
            throw new RuntimeException();
        } else {
            int[] arr2 = new int[arr.length - 1 - list.lastIndexOf(4)];
            System.arraycopy(arr, list.lastIndexOf(4) + 1, arr2, 0, arr.length - 1 - list.lastIndexOf(4));
            return arr2;
        }
    }

    public static boolean findNums(int[] arr) {
        int wrongNum=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=1 && arr[i] != 4) {
                wrongNum++;
            }
        }
        if (wrongNum>0) {
            return false;
        } else {
            return true;
        }
    }
}
