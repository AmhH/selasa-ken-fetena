package com.example.leet.mki;

public class MyClass {

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        Class c = myClass.getClass();
        try{
            System.out.println(c.getMethod("getNumber", null).toString());
            System.out.println(c.getDeclaredMethod("setNumber", Integer.class));
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }

    public Integer getNumber(){
        return 2;
    }

    public void setNumber(Integer n){

    }
}
