package algorithm.sort;

import util.CommonUtil;
import util.MathUtil;

import java.util.Random;

/**
 * Created by ming on 17/8/29.
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = MathUtil.getRandomArr(10);

        System.out.println("befor sort is:");
        CommonUtil.show(arr);

        insertSort(arr);

        System.out.println("after sort is:");
        CommonUtil.show(arr);
    }


    private static void insertSort(int[] arr) {
        int length = arr.length;
        int j;
        for (int i = 1; i < length; i++) {
            int temp = arr[i];
            //将 i 位置的数 和 前面的数做比较， 如果小于前面的数，就把前面的数往后移1位
            //当前面的数都小于 i位置的数的时候，j就是 将要插入位置的下标
            for (j = i; j > 0 && arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }
}
