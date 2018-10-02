package com.example.questions;

import java.util.PriorityQueue;

public class Priority_queue {

    public static void main(String[] args) {

        PriorityQueue<String> pq = new PriorityQueue<>();

        pq.add("1");
        pq.add("2");
        pq.add("3");
        System.out.println(pq.poll() + ":" + pq.peek());

    }


}
