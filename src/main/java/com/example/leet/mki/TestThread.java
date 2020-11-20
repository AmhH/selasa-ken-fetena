package com.example.leet.mki;

public class TestThread{

    public static void main(String[] args) {
        SampleDemo a = new SampleDemo("A");
        SampleDemo b = new SampleDemo("B");

        b.start();
        a.start();
    }
}

class SampleDemo implements Runnable{
    private Thread t;
    private String threadName;

    SampleDemo(String threadName){
        this.threadName = threadName;
    }

    @Override
    public void run() {
        while (true){
            System.out.print(threadName);
        }
    }

    public void start(){
        if(t == null){
            t = new Thread();
            t.start();
        }
    }
}
