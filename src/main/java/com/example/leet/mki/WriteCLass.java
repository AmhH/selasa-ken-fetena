package com.example.leet.mki;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;

public class WriteCLass {

    public static void main(String[] args) throws IOException {
        File file = new File("Data.txt");
        FileWriter writer = new FileWriter(file);
        /*for (int i = 0; i < 5; i++) {
            writer.write(String.valueOf(i));
        }*/

        /*PrintWriter printer = new PrintWriter(writer);
        Stream.of('0', '1', '2', '3', '4').forEach(printer::write);*/

        //writer.write(new char[]{'0', '1', '2', '3', '4'});

        //Stream.of('0', '1', '2', '3', '4').forEach(writer::write); exception handling needed

        writer.flush();
    }
}
