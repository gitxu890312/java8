package com.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        Integer[] tmps = new Integer[]{13, 9, 7, 6, 4,3, 2};
        System.out.println(nearIndexOf(14, Arrays.asList(tmps),false)==0);
        System.out.println(nearIndexOf(1, Arrays.asList(tmps),false)==-1);


        System.out.println(nearIndexOf(12, Arrays.asList(tmps),true)==0);
        System.out.println(nearIndexOf(12, Arrays.asList(tmps),false)==1);

        System.out.println(nearIndexOf(8, Arrays.asList(tmps),true)==1);
        System.out.println(nearIndexOf(8, Arrays.asList(tmps),false)==2);

        System.out.println(nearIndexOf(6, Arrays.asList(tmps),false)==3);
        System.out.println(nearIndexOf(4, Arrays.asList(tmps),false)==4);
    }

    /**
     * 就近查找；查找离目标值最近的索引
     * @param target 查找目标
     * @param arrs 查找的数组（倒序）
     * @param rtnMaxValue 当没有命中时返回较大值对应的一个索引
     * @return
     * 例如：
     * arrs[13, 9, 7, 6, 4, 2]
     * idx  0   1, 2, 3, 4, 5
     *  target=14;return 0;
     *  target=1;return -1;
     *  target=12;rtnHighMix=TRUE return 0;else return 1;
     *  target=8;rtnHighMix=TRUE return 1;else return 2;
     *
     */
    public static int nearIndexOf(int target, List<Integer> arrs,boolean rtnMaxValue) {
        if (arrs.size() == 0 || target < arrs.get(arrs.size() - 1)) {
            return -1;
        }
        if (target >= arrs.get(0)) {
            return 0;
        }
        int low = 0;
        int high = arrs.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midBarTime = arrs.get(mid);
            if (target == midBarTime) {
                return mid;
            } else if (midBarTime < target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println("low" + low + ",value" + arrs.get(low));
        System.out.println("target:" + target);
        System.out.println("high" + high + ",value" + arrs.get(high));

        if(rtnMaxValue){
            return high;
        }else{
            return low;
        }
    }
}
