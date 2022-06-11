package com.jiangfan.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-10  19:12
 */
public class Shell {

    /**
     * 对数组a中的元素进行排序
     *
     * @param a 数组
     */
    public static void sort(Comparable[] a) {
        int length = a.length;
        // 1.根据数组长度缺点增长量h的初始值
        int h = 1;
        while (h < length / 2) {
            h = h * 2 + 1;
        }
        // 2.希尔排序
        while (h >= 1) {
            // 排序
            // 2.1找到待插入的元素
            for (int i = h; i < length; i++) {
                // 2.2将待插入的元素插入到有序数组中
                for (int j = i; j >= h; j -= h) {
                    // 待插入的元素是a[j],比较a[j-h]和a[j]
                    if (greater(a[j - 1], a[j])) {
                        exch(a, j - h, j);
                    } else {
                        // 待插入的元素找到应该插入的位置
                        break;
                    }
                }
            }
            // 减小h
            h = h / 2;
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
    public void testShell() {
        Integer[] a = {9, 1, 2, 5, 7, 4, 8, 6, 3, 5};
        Shell.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
