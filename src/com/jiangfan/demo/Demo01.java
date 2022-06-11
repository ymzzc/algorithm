package com.jiangfan.demo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 合并时间区间（建议时间复杂度 O(n)）
 * 给定⼀个按开始时间从⼩到⼤排序的时间区间集合，请将重叠的区间合并。时间区间集合⽤⼀个⼆维数组表示，
 * ⼆维数组的每⼀⾏表示⼀个时间区间（闭区间），其中 0 位置元素表示时间区间开始，1 位置元素表示时间区间结束。
 * 例 1：输⼊：[ [1, 3], [2, 6], [8, 10], [15, 18] ]
 * 返回： [ [1, 6], [8, 10], [15, 18]]
 * 解释：时间区间 [1, 3] 和 [2, 6] 有部分重叠，合并之后为 [1, 6]
 * 例 2：输⼊：[[1, 4], [4, 5]]
 * 返回：[[1, 5]]
 * 解释：时间区间[1，4] 和 [4，5]重叠了⼀个时间点，合并之后为 [1，5]
 * 需要实现的⽅法原型：int[][] merge(int[][] intervals)
 *
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-10  11:25  12.40
 */
public class Demo01 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 6}, {8, 10}, {15, 18}, {16, 20}, {22, 30}, {23, 40}};
        int[][] merge = merge(intervals);

        for (int i = 0; i < merge.length; i++) {
            System.out.println(Arrays.toString(merge[i]));
        }
    }

    public static int[][] merge(int[][] intervals) {
        int length = intervals.length;

        // 新建集合存放数组
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(intervals[i]);
        }

        int oldSize = list.size();
        for (int i = 0; i < oldSize - 1; i++) {
            // 当前索引数组
            int[] firstArray = list.get(i);
            int first = firstArray[1];
            // 索引+1数组
            int[] secondArray = list.get(i + 1);
            int second = secondArray[0];

            // 需要合并
            if (first >= second) {
                // 添加合并之后的数组
                list.add(i, new int[]{firstArray[0], secondArray[1]});
                // 删除用来合并的两个数组
                list.remove(i + 1);
                list.remove(i + 1);
                i--;
                oldSize--;
            }
        }

        // 从集合中取出数组
        int size = list.size();
        int[][] array = new int[size][];
        for (int i = 0; i < size; i++) {
            array[i] = list.get(i);
        }

        return array;
    }
}
