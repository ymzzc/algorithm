package com.jiangfan.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-10  18:17
 */
public class Bubble {

    /**
     * 对数组a中的元素进行排序
     *
     * @param a 数组
     */
    public static void sort(Comparable[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                // 比较索引j和索引j+1处的值
                if (greater(a[j], a[j + 1])) {
                    exch(a, j, j + 1);
                }
            }
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
    public void testBubble() {
        Integer[] a = {4, 5, 6, 3, 2, 1};
        Bubble.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
