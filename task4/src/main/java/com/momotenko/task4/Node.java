package com.momotenko.task4;

public class Node<T extends Comparable<T>> implements Comparable<T> {
    private T value;
    private Node<T> bottom;
    private Node<T> next;
    private Node<T> prev;

    public Node(T value, Node<T> bottom, Node<T> prev, Node<T> next) {
        this.value = value;
        this.bottom = bottom;
        this.next = next;
        this.prev = prev;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getBottom() {
        return bottom;
    }

    public void setBottom(Node<T> bottom) {
        this.bottom = bottom;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    @Override
    public int compareTo(T o) {
        return value.compareTo(o);
    }
}
