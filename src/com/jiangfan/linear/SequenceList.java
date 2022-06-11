package com.jiangfan.linear;

import java.util.Iterator;

/**
 * 顺序表
 *
 * @author jiangfan
 * @version 1.0
 * @CreateTime 2022-06-11  12:21
 */
public class SequenceList<T> implements Iterable<T> {
    //存储元素的数组
    private T[] elementData;
    //记录当前顺序表中的元素个数
    private int size;

    //构造方法
    public SequenceList(int capacity) {
        //初始化数组
        this.elementData = (T[]) new Object[capacity];
        //初始化长度
        this.size = 0;
    }

    //将一个线性表置为空表
    public void clear() {
        this.size = 0;
    }

    //判断当前线性表是否为空表
    public boolean isEmpty() {
        return size == 0;
    }

    //获取线性表的长度
    public int length() {
        return size;
    }

    //获取指定位置的元素
    public T get(int i) {
        return elementData[i];
    }

    //向线型表中添加元素t
    public void insert(T t) {
        if (size == elementData.length) {
            resize(2 * elementData.length);
        }

        elementData[size++] = t;
    }

    //在i元素处插入元素t
    public void insert(int i, T t) {
        if (size == elementData.length) {
            resize(2 * elementData.length);
        }

        //先把i索引处的元素及其后面的元素依次向后移动一位
        for (int index = size; index > i; index--) {
            elementData[index] = elementData[index - 1];
        }
        //再把t元素放到i索引处即可
        elementData[i] = t;

        //元素个数+1
        size++;
    }

    //删除指定位置i处的元素，并返回该元素
    public T remove(int i) {
        //记录索引i处的值
        T current = elementData[i];
        //索引i后面元素依次向前移动一位即可
        for (int index = i; index < size - 1; index++) {
            elementData[index] = elementData[index + 1];
        }
        //元素个数-1
        size--;

        if (size < elementData.length / 4) {
            resize(elementData.length / 2);
        }

        return current;
    }

    //查找t元素第一次出现的位置
    public int indexOf(T t) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    //根据参数newSize，重置elementData的大小
    public void resize(int newSize) {
        //定义一个临时数组，指向原数组
        T[] temp = elementData;
        //创建新数组
        elementData = (T[]) new Object[newSize];
        //把原数组的数据拷贝到新数组即可
        for (int i = 0; i < size; i++) {
            elementData[i] = temp[i];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {
        private int cusor;

        public SIterator() {
            this.cusor = 0;
        }

        @Override
        public boolean hasNext() {
            return cusor < size;
        }

        @Override
        public Object next() {
            return elementData[cusor++];
        }
    }

}
