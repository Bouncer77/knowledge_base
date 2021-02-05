package com.bouncer77.LinkedLIst_004_005;

import java.util.Arrays;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 24.05.2020
 * lesson 005
 */
public class SuperList {

    private Node head;
    private int size;

    public void remove(int index) {
        if (index == 0) {
            head = head.getNext();
            size--;
            return;
        }

        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Node curNode = head;
        int curIndex = 0;

        while (curIndex++ != index - 1) {
            curNode = curNode.getNext();
        }

        curNode.setNext(curNode.getNext().getNext());
        size--;
    }

    public int get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node curNode = head;
        int curIndex = 0;
        while (curNode != null) {
            if (curIndex == index) {
                return curNode.getValue();
            }
            curNode = curNode.getNext();
            curIndex++;
        }

        throw new IndexOutOfBoundsException();
    }

    public void add(int value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node temp = head;

            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            // head -> [1] -> [2] -> [3] -> null

            temp.setNext(new Node(value));
        }
        size++;
    }

    @Override
    public String toString() {
        int[] res = new int[size];
        int idx = 0;
        Node temp = head;

        while(temp != null) {
            res[idx++] = temp.getValue();
            temp = temp.getNext();
        }

        return Arrays.toString(res);
    }

    private static class Node {
        private Node next;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public int getValue() {
            return value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
