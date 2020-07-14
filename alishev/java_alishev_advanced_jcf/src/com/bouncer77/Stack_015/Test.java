package com.bouncer77.Stack_015;

import java.util.Stack;

/**
 * @author Ivan Kosenkov
 * Created by Ivan Kosenkov on 25.05.2020
 * lesson 015
 */
public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // push - pop - peek
        stack.push(5);
        stack.push(3);
        stack.push(1);

        //System.out.println(stack.pop());
        //System.out.println(stack.peek());

        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}
