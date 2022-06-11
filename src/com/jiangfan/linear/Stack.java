package com.jiangfan.linear;

import java.util.Iterator;

/**
 * 栈 先进后出FILO
 *
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-11  19:26
 */
public class Stack<T> implements Iterable<T> {
    //记录首结点
    private Node head;
    //栈中元素的个数
    private int N;

    public Stack() {
        head = new Node(null, null);
        N = 0;
    }

    // 节点类
    private class Node {
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    //判断当前栈中元素个数是否为0
    public boolean isEmpty() {
        return N == 0;
    }

    //把t元素压入栈
    public void push(T t) {
        Node oldNext = head.next;
        Node node = new Node(t, oldNext);
        head.next = node;
        //个数+1
        N++;
    }

    //弹出栈顶元素
    public T pop() {
        Node oldNext = head.next;
        if (oldNext == null) {
            return null;
        }
        //删除首个元素
        head.next = head.next.next;
        //个数-1
        N--;
        return oldNext.item;
    }

    //获取栈中元素的个数
    public int size() {
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator<T> {
        private Node n = head;

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public T next() {
            Node node = n.next;
            n = n.next;
            return node.item;
        }
    }

}
