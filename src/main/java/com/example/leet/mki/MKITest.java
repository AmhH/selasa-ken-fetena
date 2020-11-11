package com.example.leet.mki;

public class MKITest {

    public MKITest() {
        this(10);
    }

    public MKITest(int data) {
        this.data = data;
    }

    public void display() {
        class Decrementer{
            public void decrement(){
                data--;
            }
        }
        Decrementer decrementer = new Decrementer();
        decrementer.decrement();
        System.out.println("data: " + data);
    }

    private int data;

    public static void main(String[] args) {
        int data = 0;
        MKITest test = new MKITest();
        test.display();
        System.out.println("data: " + data);
    }
}
