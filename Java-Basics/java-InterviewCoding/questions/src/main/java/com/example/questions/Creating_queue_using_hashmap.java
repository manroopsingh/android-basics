package com.example.questions;

import java.util.HashMap;

public class Creating_queue_using_hashmap {

    public static void main(String[] args) {

        CustomQueue<String> customQueue = new CustomQueue<>();
        customQueue.enqueue("first");
        customQueue.enqueue("second");
        customQueue.enqueue("third");
        System.out.println(customQueue.dequeue());
        System.out.println(customQueue.dequeue());
        System.out.println(customQueue.dequeue());
        System.out.println(customQueue.dequeue());
        customQueue.enqueue("fourth");
        System.out.println(customQueue.dequeue());

    }

    public static class CustomQueue<E>{

        HashMap<Long, E> map;
        private long  head = 0;
        private long tail = 0;

        public CustomQueue() {
            map = new HashMap<>();
        }

        public E dequeue(){
            if(head>tail) return null;
            E e = map.get(head);
            map.remove(head);
            if(head>=tail) head++;
            return e;
        }

        public void enqueue(E e){
            if(head==0) head = 1;
            tail++;
            map.put(tail, e);
        }

    }

}
