package com.example.leet.java9;

import java.util.Map;
import java.util.stream.Collectors;

public class StackWalkerDemo {

    public static void main(String[] args) {
        //before java 9 => low performance, no gurantee all stack elements are returned, no partial handling possible
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();

        //Java 9
        StackWalker stackWalker =  StackWalker.getInstance();
        stackWalker.walk(frame -> frame.sorted());
        stackWalker.forEach(System.out::println);

        stackWalker.walk(stackStream -> stackStream
        .filter(f -> f.getMethodName().startsWith("M")))
                .map(StackWalker.StackFrame::getLineNumber)
                .collect(Collectors.toList());

    }
}
