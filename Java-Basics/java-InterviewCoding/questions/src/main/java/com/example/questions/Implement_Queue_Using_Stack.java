package com.example.questions;

import java.util.Stack;

public class Implement_Queue_Using_Stack {


    public static class MyQueue<E>{


        private Stack<E> stack1;
        private Stack<E> stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();

        }

        public void enqueue(E item) {

            stack1.push(item);

        }

        public E dequeue() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

    }

    public static void main(String[] args) {

        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.enqueue(5);

        System.out.println(myQueue.dequeue());

        }

    }


