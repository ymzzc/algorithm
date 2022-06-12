package com.jiangfan.heap;

/**
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-12  17:10
 */
public class HeapTest {
    public static void main(String[] args) {
        Heap<String> heap = new Heap<>(10);
        heap.insert("A");
        heap.insert("B");
        heap.insert("C");
        heap.insert("D");
        heap.insert("E");
        heap.insert("F");
        heap.insert("G");

        String del;
        while ((del = heap.delMax()) != null) {
            System.out.print(del + ",");
        }
    }
}
