package com.example.leet.mki;

import java.util.*;

public class Col {
    
    public static void main(String[] args) {
        String[] a = {"A", "D", "B", "E", "C"};
        List<String> l = Arrays.asList(a);
        //Collection<String> c = getCollection(l);
        Collection<String> c = (Collection<String>) getCollection(l);
        Iterator<String> it = c.iterator();
        while(it.hasNext()){
            System.out.print(it.next());
        }
    }

    static public <E extends CharSequence>Collection<? extends CharSequence> getCollection(Collection<E> c){
        Collection<E> t = new TreeSet<>();
        for(Iterator<E> it = c.iterator(); it.hasNext();){
            t.add(it.next());
        }

        return t;
    }
}
