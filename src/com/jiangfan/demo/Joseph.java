package com.jiangfan.demo;

/**
 * 约瑟夫问题
 *
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-11  17:46
 */
public class Joseph {

    public static void main(String[] args) {
        // 1.构建循环链表
        Node<Integer> first = null;
        // 记录前一个结点
        Node<Integer> pre = null;

        for (int i = 1; i <= 41; i++) {
            //第一个元素
            if (i == 1) {
                first = new Node(i, null);
                pre = first;
                continue;
            }
            Node<Integer> node = new Node<>(i, null);
            pre.next = node;
            pre = node;
            if (i == 41) {
                // 构建循环链表，让最后一个结点指向第一个结点
                pre.next = first;
            }
        }
        // 2.使用count，记录当前的报数值
        int count = 0;
        // 3.遍历链表，每循环一次，count++
        // 当前节点
        Node<Integer> n = first;
        // 记录当前节点的上一节点
        Node<Integer> before = null;
        while (n != n.next) {
            // 4.判断count的值，如果是3，则从链表中删除这个结点并打印结点的值，把count重置为0；
            count++;
            if (count == 3) {
                //删除当前结点 上一节点为 当前节点的 下一节点
                before.next = n.next;
                System.out.print(n.item + ",");
                count = 0;
                n = n.next;
            } else {
                // 不是3，before指向 当前节点， 当前节点指向下一节点
                before = n;
                n = n.next;
            }
        }
        /*打印剩余的最后那个人*/
        System.out.println();
        System.out.println(n.item);
    }

    // 节点类
    private static class Node<T> {
        // 数据
        T item;
        // 下一个节点
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
