package com.jiangfan.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-10  18:36
 */
public class Selection {

    /**
     * 对数组a中的元素进行排序
     *
     * @param a 数组
     */
    public static void sort(Comparable[] a) {
        int length = a.length;
        for (int i = 0; i < length - 1; i++) {
            // 最小值索引
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                // 比较最小值和索引j处的值
                if (greater(a[minIndex], a[j])) {
                    // 更新最小值索引
                    minIndex = j;
                }
            }
            exch(a, i, minIndex);
        }
    }

    /**
     * 比较v元素是否大于w元素
     *
     * @param v
     * @param w
     * @return
     */
    private static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    /**
     * 数组元素i和j交换位置
     *
     * @param a 数组
     * @param i 元素i
     * @param j 元素j
     */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    @Test
    public void testSelection() {
        Integer[] a = {4,6,8,7,9,2,10,1};
        Selection.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
