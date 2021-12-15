package com.example.ipv4.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.Callable;

public class FileTask implements Callable<String> {

    private BufferedReader bufferedReader;

    private Set<String> set;

    public FileTask(BufferedReader bufferedReader, Set<String> set) {
        this.bufferedReader = bufferedReader;
        this.set = set;
    }

    @Override
    public String call() throws Exception {
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                set.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "done";
    }
}
