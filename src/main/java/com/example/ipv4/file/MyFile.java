package com.example.ipv4.file;

import com.google.common.collect.Sets;
import lombok.Getter;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

@Getter
public class MyFile {
    public Set<String> set;
    public BufferedReader bufferedReader;

    public MyFile() {
        this.set = Sets.newConcurrentHashSet();
        try {
            this.bufferedReader = Files.newBufferedReader(Paths.get("/Users/grigormartirosyan/IdeaProjects/ipv4/ips.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
