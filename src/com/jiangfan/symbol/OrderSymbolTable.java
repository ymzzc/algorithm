package com.jiangfan.symbol;

import com.jiangfan.linear.Stack;

import java.util.Iterator;

/**
 * 有序符号表
 *
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-11  20:55
 */
public class OrderSymbolTable<K extends Comparable<K>, V> implements Iterable<K>{
    //记录首结点
    private Node head;
    //记录符号表中元素的个数
    private int N;

    public OrderSymbolTable() {
        head = new Node(null, null, null);
        N = 0;
    }

    @Override
    public Iterator<K> iterator() {
        return new OItertor();
    }

    private class OItertor implements Iterator<K>{

        private Node n = head;

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public K next() {
            n = n.next;
            return n.key;
        }
    }
    
    private class Node {
        //键
        public K key;
        //值
        public V value;
        //下一个结点
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    //获取符号表中键值对的个数
    public int size() {
        return N;
    }

    //往符号表中插入键值对,key相同，value替换
    public void put(K key, V value) {
        //记录当前结点
        Node curr = head.next;
        //记录上一个结点
        Node pre = head;
        //1.如果key大于当前结点的key，则一直寻找下一个结点
        while (curr != null && key.compareTo(curr.key) > 0) {
            pre = curr;
            curr = curr.next;
        }
        //如果key一样，value覆盖
        if (curr != null && curr.key.compareTo(key) == 0) {
            curr.value = value;
        } else {
            //key不一样，插入curr之前
            Node newNode = new Node(key, value, curr);
            pre.next = newNode;
        }
    }

    //删除符号表中键为key的键值对
    public void delete(K key) {
        Node n = head;
        while (n.next != null) {
            // n节点的下个节点的键是否等于key
            if (n.next.key.equals(key)) {
                // 删除节点
                n.next = n.next.next;
                N--;
                return;
            }
            n = n.next;
        }
    }

    //从符号表中获取key对应的值
    public V get(K key) {
        Node n = head;
        while (n.next != null) {
            n = n.next;
            if (n.key.equals(key)) {
                return n.value;
            }
        }
        return null;
    }
}
