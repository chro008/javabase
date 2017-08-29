package algorithm.sort;

import util.CommonUtil;
import util.MathUtil;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = MathUtil.getRandomArr(12, 100);

        System.out.println("before sort is:");
        CommonUtil.show(arr);

        bubbleSort(arr);

        System.out.println("after sort is:");
        CommonUtil.show(arr);
    }

    private static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {           //没循环一次 都将下标从0  到 i 的这些数 最大的 放到了最后一位
                if (arr[j] > arr[j + 1]) {
                    CommonUtil.exchange(arr, j, j + 1);
                }
            }
        }
    }

}
/*
before sort is:
65	36	30	69	18	1	88	13	67	92	74	7
after sort is:
1	7	13	18	30	36	65	67	69	74	88	92
 */