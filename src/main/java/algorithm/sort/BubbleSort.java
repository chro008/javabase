package algorithm.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 2, 8, 9, 1, 6, 5, 3, 4};
        System.out.println("resource is:");
        println(arr);

        sort(arr);
        System.out.println("after sort is:");
        println(arr);
    }

    private static void sort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    exchange(arr, j, j + 1);
                }
            }
        }
    }

    private static void println(int[] arr) {
        for (int anArr : arr) {
            System.out.printf(anArr + "\t");
        }
        System.out.println();
    }

    private static void exchange(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


}
/*
resource is:
10	5	2	7	2	8	9	1	6	5	3	4
after sort is:
1	2	2	3	4	5	5	6	7	8	9	10
 */