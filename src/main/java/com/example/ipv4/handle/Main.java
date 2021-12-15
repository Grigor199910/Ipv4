package com.example.ipv4.handle;

import com.example.ipv4.file.MyFile;
import com.example.ipv4.impl.FileTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws IOException {

        MyFile myFile = new MyFile();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<FileTask> tasks = new ArrayList<>();

        tasks.add(new FileTask(myFile.bufferedReader, myFile.set));
        try {
          executorService.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

        System.out.println("finished with count with : " + myFile.set.size());

    }
}


