package com.jiangfan.algorithm;

/**
 * 二分查找算法
 *
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-16  20:49
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {3, 12, 24, 31, 46, 48, 52, 66, 69, 79, 82};
        int target = 31;
        int index = binarySearch(array, target);
        System.out.println(target+"索引为："+index);
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
