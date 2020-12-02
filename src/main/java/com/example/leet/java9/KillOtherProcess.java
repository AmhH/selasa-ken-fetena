package com.example.leet.java9;

public class KillOtherProcess {

    public static void main(String[] args) {
        ProcessHandle textHandle = ProcessHandle.allProcesses()
                .filter(h -> h.info().command()
                            .map(cmd -> cmd.contains("Office"))
                            .orElse(false))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No matching handle found"));

        System.out.println(textHandle.info());

        textHandle.onExit().thenAccept(h -> System.out.println("Word was killed by Java"));

        boolean shutDown = textHandle.destroy();

        textHandle.onExit().join();

        System.out.println("Shutdown: " + shutDown);
    }
}
