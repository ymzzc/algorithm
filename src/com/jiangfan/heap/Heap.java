package com.jiangfan.heap;

/**
 * 堆
 *
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-12  16:20
 */
public class Heap<T extends Comparable<T>> {
    // 存储堆中元素
    private T[] items;
    // 记录堆中元素的个数
    private int N;

    public Heap(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    // 判断堆中索引i处的元素是否小于索引j处的元素
    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    // 交换堆中i索引和j索引处的值
    private void exch(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    // 往堆中插入一个元素
    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    // 使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k) {
        // 通过循环比较当前节点和父节点
        while (k > 1) {
            //和父节点比较
            if (less(k / 2, k)) {
                exch(k / 2, k);
            }
            k = k / 2;
        }
    }

    // 删除堆中最大的元素,并返回这个最大元素
    public T delMax() {
        T max = items[1];

        // 交换索引N和索引1
        exch(1, N);

        // 索引N置空
        items[N] = null;
        // 个数--
        N--;
        // 索引1开始下沉
        sink(1);
        return max;
    }

    // 使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k) {
        // 循环比较k 和子节点2k 2k+1的值
        while ((2 * k + 1) <= N) {
            // 获取子节点最大值
            int max;

            if (2 * k + 1 <= N) {
                if (less(2 * k, 2 * k + 1)) {
                    max = 2 * k + 1;
                } else {
                    max = 2 * k;
                }
            } else {
                // 不存在右子结点
                max = 2 * k;
            }
            // 父节点比子节点大，不需要交换
            if (!less(k, max)) {
                break;
            }
            // 交换
            exch(k, max);
        }
    }

}