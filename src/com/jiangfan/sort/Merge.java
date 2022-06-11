package com.jiangfan.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-10  20:39
 */
public class Merge {
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

    /*
      对数组a中的元素进行排序
   */
    public static void sort(Comparable[] a) {
        // 1.初始化assist数组
        int length = a.length;
        assist = new Comparable[length];
        // 2.记录数组最小和最大索引
        int lo = 0;
        int hi = length - 1;
        // 3.完成知道索引排序
        sort(a, lo, hi);

    }

    /*
    对数组a中从lo到hi的元素进行排序
    */
    private static void sort(Comparable[] a, int lo, int hi) {
        // 进行安全校验
        if (lo >= hi) {
            return;
        }
        // 分组
        int mid = lo + (hi - lo) / 2;

        // 对分组进行排序
        sort(a, lo, mid);
        sort(a, mid + 1, hi);

        // 合并
        merge(a, lo, mid, hi);
    }

    /*
    对数组中，从lo到mid为一组，从mid+1到hi为一组，对这两组数据进行归并
     */
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        //定义三个指针
        int i = lo;
        int p1 = lo;
        int p2 = mid + 1;

        //遍历，移动p1指针和p2指针，比较对应索引处的值，找出小的那个，放到辅助数组的对应索引处
        while (p1 <= mid && p2 <= hi) {
            if (less(a[p1],a[p2])){
                assist[i++] = a[p1++];
            }else{
                assist[i++]=a[p2++];
            }
        }

        //遍历，如果p1的指针没有走完，那么顺序移动p1指针，把对应的元素放到辅助数组的对应索引处
        while(p1<=mid){
            assist[i++]=a[p1++];
        }
        //遍历，如果p2的指针没有走完，那么顺序移动p2指针，把对应的元素放到辅助数组的对应索引处
        while(p2<=hi){
            assist[i++]=a[p2++];
        }
        //把辅助数组中的元素拷贝到原数组中
        for (int j = lo; j <= hi; j++) {
            a[j] = assist[j];
        }

    }
    
    @Test
    public void testMerge(){
        Integer[] a = {8,4,5,7,1,3,6,2};
        Merge.sort(a);
        System.out.println(Arrays.toString(a));
    }

}
