package util;

import java.util.Random;

public class MathUtil {
    public static int[] getRandomArr(int length) {
        return getRandomArr(length, 100);
    }

    public static int[] getRandomArr(int length, int max) {
        Random random = new Random();
        int arr[] = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(max);
        }
        return arr;
    }


}
