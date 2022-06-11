package com.jiangfan.linear;

import java.util.Iterator;

/**
 * 双向链表
 *
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-11  16:10
 */
public class TwoWayLinkList<T> implements Iterable<T> {
    // 头节点
    private Node first;

    // 尾节点
    private Node last;

    // 长度
    private int N;

    // 节点类
    private class Node {

        // 数据
        public T item;
        // 前驱节点
        public Node pre;
        // 后继节点
        public Node next;

        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }

    }

    public TwoWayLinkList() {
        this.first = new Node(null, null, null);
        this.last = null;
        N = 0;
    }

    // 去空链表

    public void clear() {
        last = null;
        first.next = last;
        first.pre = null;
        first.item = null;
        this.N = 0;
    }
    // 链表是否为空

    public boolean isEmpty() {
        return N == 0;
    }
    // 获取链表长度

    public int length() {
        return N;
    }
    // 获取链表第index个元素的值

    public T get(int index) {
        if (index >= N || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.item;
    }
    // 添加元素

    public boolean insert(T t) {
        if (last == null) {
            last = new Node(t, first, null);
            first.next = last;
        } else {
            Node oldLast = last;
            Node node = new Node(t, oldLast, null);
            oldLast.next = node;
            last = node;
        }
        N++;
        return true;
    }
    // 想i处添加元素

    public boolean insert(int index, T t) {
        if (index > N || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index == N){
            insert(t);
            return true;
        }
        // 前一个节点
        Node pre = first;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        // 当前节点
        Node current = pre.next;
        // 新插入节点
        Node newNode = new Node(t, pre, current);
        pre.next = newNode;
        current.pre = newNode;
        N++;
        return true;
    }
    // 删除第i个元素

    public boolean remove(int index) {
        if (index >= N || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        // 前一个节点
        Node pre = first;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        // 下一节点
        Node next = pre.next.next;
        pre.next = next;
        next.pre = pre;
        N--;
        return true;
    }
    // 返回元素首次出现位置

    public int indexOf(T t) {
        Node node = first;
        for (int i = 0; node.next != null; i++) {
            node = node.next;
            if (node.equals(t)) {
                return i;
            }
        }
        return -1;
    }
    // 获取第一个元素

    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return first.next.item;
    }
    // 获取最后一个元素

    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return last.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }

    private class TIterator implements Iterator {
        private Node node = first;

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public Object next() {
            node = node.next;
            return node.item;
        }
    }
}
