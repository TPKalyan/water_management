package org.example;

import org.example.utils.FileUtils;

import java.util.List;

public class App {

    public static void main(String[] args)  {
        String filePath = args[0];

        List<String> commands = FileUtils.readFiles();

//        commands.forEach(s -> );
    }
}