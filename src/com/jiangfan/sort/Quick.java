package com.jiangfan.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-11  11:31
 */
public class Quick {
    //归并所需要的辅助数组
    private static Comparable[] assist;

    /**
     * 比较v元素是否大于w元素
     *
     * @param v
     * @param w
     * @return
     */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
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

    // 对数组a中的元素进行排序
    public static void sort(Comparable[] a) {
        int lo = 0;
        int hi = a.length - 1;
        sort(a, lo, hi);

    }

    // 对数组a中从lo到hi的元素进行排序
    private static void sort(Comparable[] a, int lo, int hi) {
        // 进行安全校验
        if (lo >= hi) {
            return;
        }
        // 进行分组（左子组，右子组）
        int partition = partition(a, lo, hi);
        // 左子组排序
        sort(a, lo, partition - 1);

        // 右子组排序
        sort(a, partition + 1, hi);

    }

    // 对数组中，索引lo 到 hi分组，并返回分组界限的索引值
    private static int partition(Comparable[] a, int lo, int hi) {
        Comparable key = a[lo];//把最左边的元素当做基准值
        int left = lo;//定义一个左侧指针，初始指向最左边的元素
        int right = hi + 1;//定义一个右侧指针，初始指向左右侧的元素下一个位置
        //进行切分
        while (true) {
            //先从右往左扫描，找到一个比基准值小的元素
            while (less(key, a[--right])) {//循环停止，证明找到了一个比基准值小的元素
                if (right == lo) {
                    break;//已经扫描到最左边了，无需继续扫描
                }
            }
            //再从左往右扫描，找一个比基准值大的元素
            while (less(a[++left], key)) {//循环停止，证明找到了一个比基准值大的元素
                if (left == hi) {
                    break;//已经扫描到了最右边了，无需继续扫描
                }
            }
            if (left >= right) {
                //扫描完了所有元素，结束循环
                break;
            } else {
                //交换left和right索引处的元素
                exch(a, left, right);
            }
        }
        //交换最后rigth索引处和基准值所在的索引处的值
        exch(a, lo, right);
        return right;//right就是切分的界限
    }

    @Test   
    public void testQuick() {
        Integer[] a = {6, 1, 2, 7, 9, 3, 4, 5, 8};
        Quick.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
