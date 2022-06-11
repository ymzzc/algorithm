package com.jiangfan.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-10  18:55
 */
public class Insertion {

    /**
     * 对数组a中的元素进行排序
     *
     * @param a 数组
     */
    public static void sort(Comparable[] a) {
        int length = a.length;
        // 待排序
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) {
                // 比较索引 j 和 j-1 处的值
                if (greater(a[j-1],a[j])) {
                    exch(a,j-1,j);
                }else {
                    break;
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
    public void testInsertion() {
        Integer[] a = {4,3,2,10,12,1,5,6};
        Insertion.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
