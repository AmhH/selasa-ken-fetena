package com.example.leet.mki;


public interface StringMapper<T> {
    String map(T t);
}

class X {
    String s;

    public X(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s.toLowerCase();
    }

    public String toLowerCase() {
        return s.toLowerCase();
    }
}

class Y<T> {
    T s;

    public Y(T s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s.toString();
    }
}

class H2 {
    static String mapMe(Y y, StringMapper<Y> t) {
        return t.map(y);
    }

    static String mapMe(X x, StringMapper<X> t){
        return t.map(x);
    }

    public static void main(String[] args){
        System.out.println(mapMe(new Y<>(3), e -> e.toString()));//3
        System.out.println(mapMe(new Y<>("HELLO"), e -> e.toString()));//HELLO
        System.out.println(mapMe(new X("HELLO"), e -> {
            if(e.s.charAt(0) == 'H')
                return e.toString();
            return e.toLowerCase();
        }));//hello
        System.out.println(mapMe(new Y<>(new X("HELLO")), e -> e.toString()));//hello
        System.out.println(mapMe(new Y<>(3), e -> e.toString().equals("3") ? "hello" : "HELLO"));//hello
    }
}

