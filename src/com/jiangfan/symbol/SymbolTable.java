package com.jiangfan.symbol;

/**
 * 符号表
 *
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-11  20:55
 */
public class SymbolTable<K, V> {
    //记录首结点
    private Node head;
    //记录符号表中元素的个数
    private int N;

    public SymbolTable() {
        head = new Node(null, null, null);
        N = 0;
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
        //先从符号表中查找键为key的键值对
        Node n = head;
        while (n.next != null) {
            n = n.next;
            if (n.key.equals(key)) {
                n.value = value;
                return;
            }
        }
        //符号表中没有键为key的键值对，从头部插入
        Node oldFirst = head.next;
        Node newFirst = new Node(key, value, oldFirst);
        head.next = newFirst;
        //个数++
        N++;
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
