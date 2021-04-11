package com.momotenko.task4;

import java.util.*;

public class SkipList<T extends Comparable<T>> {
    LinkedList<List<Node<T>>> dataList = new LinkedList<>();
    int maxLevel;
    final int lowerBoundMaxLevel = 16;
    final int upperBoundMaxLevel = 32;

    {
        //setting the number of levels (lists)
        maxLevel = new Random().nextInt(upperBoundMaxLevel - lowerBoundMaxLevel + 1);
        maxLevel += lowerBoundMaxLevel;
    }

    public SkipList() {
        for (int i = 0; i < maxLevel; ++i) {
            dataList.add(new LinkedList<>());
        }
    }

    public boolean insert(T elem) {
        if (dataList.get(0).isEmpty()) {
            Iterator<List<Node<T>>> iterator = dataList.descendingIterator();
            Node<T> bottomNode = null;
            List<Node<T>> currList = new LinkedList<>();

            while (iterator.hasNext()) {
                bottomNode = new Node(elem, bottomNode, null, null);
                currList.add(bottomNode);
            }

            return true;
        }

        Queue<Node<T>> stack = new ArrayDeque<>();

        Node<T> currNode = dataList.get(0).get(0);

        for (List<Node<T>> currList : dataList) {
            //ListIterator<Node<T>> iterator = currList.listIterator();

            if (currNode == null){
                currNode = currList.get(0);
            }

            while (currNode != null) {
                if (currNode.compareTo(elem) < 0) {
                    stack.add(currNode);
                    continue;
                }else if (currNode.compareTo(elem) == 0){
                    return false;
                }else{
                    currNode = currNode.getPrev().getBottom();
                }
            }
        }
    }
}
