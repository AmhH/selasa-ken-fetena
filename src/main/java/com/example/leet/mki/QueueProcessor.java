package com.example.leet.mki;

import java.util.ArrayList;
import java.util.List;

public class QueueProcessor {
    public List<String> q;

    public void setUp(){
        try{
            establishQueueSequence();
        }finally {
            cleanUp();
            System.out.println("Queue sequence successfully cleaned up");
        }
    }

    private void establishQueueSequence() {
        if(true){
            throw new IllegalArgumentException();
        }
        q = new ArrayList<>();
    }

    private void cleanUp() {
        if(q.size() > 0){
            System.out.println("Q size > 0");
        }
    }

    public static void main(String[] args) {
        QueueProcessor processor = new QueueProcessor();
        processor.setUp();
        System.out.println("Processing Complete");
    }
}
