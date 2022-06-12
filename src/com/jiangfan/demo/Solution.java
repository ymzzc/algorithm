package com.jiangfan.demo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-12  15:29
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
    }

    public static int findRepeatNumber(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return -1;
        }

        //排序查找
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }
}
