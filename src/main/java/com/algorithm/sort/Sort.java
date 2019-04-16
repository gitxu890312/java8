package com.algorithm.sort;

import java.util.Arrays;

/**
 * @Author: xuming
 * @Description:
 * @Date: 2019/4/15
 * @Version: 1.0.0
 */
public class Sort {
    /**
     *冒泡排序:
     *每次遍历会找到一个最大值,因此对于长度为N的数组，需要遍历N-1次,
     *设遍历次数为T，每次遍历需要比较的次数为N-1-T;
     * 时间复杂度:(N-1)(N-1-T)/2=O(n*n)
     */
    public static void bubbleSort(int[] arrs) {
        for (int i = 0; i < arrs.length - 1; i++) {
            for (int j = 0; j < arrs.length - i - 1; j++) {
                if (arrs[j] > arrs[j + 1]) {
                    int tmp = arrs[j];
                    arrs[j] = arrs[j + 1];
                    arrs[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 插入排序
     * @param arrs
     */
    public static void insertSort(int[] arrs) {
        //从第二个元素开始便利，因为一个元素默认是有序的
        for (int i = 1; i < arrs.length; i++) {
            int tmp = arrs[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arrs[j] > tmp) {
                    arrs[j + 1] = arrs[j];
                    //tmp是最小的元素，直接插入到第一个
                    if (j == 0) {
                        arrs[j] = tmp;
                    }
                } else {
                    arrs[j + 1] = tmp;
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arrs = new int[]{3,5,10,1,9,2,7,4};
//        Sort.bubbleSort(arrs);
        Sort.insertSort(arrs);
        System.out.println(Arrays.toString(arrs));
    }
}
