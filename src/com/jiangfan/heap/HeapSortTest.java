package com.jiangfan.heap;

import java.util.Arrays;

/**
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-12  18:50
 */
public class HeapSortTest {
    public static void main(String[] args) {
        //待排序数组
        String[] arr = {"S","O","R","T","E","X","A","M","P","L","E"};
        //通过HeapSort对数组中的元素进行排序
        HeapSort.sort(arr);
        //打印排序后数组中的元素
        System.out.println(Arrays.toString(arr));
    }
}
