package org.example.utils;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class FileUtils {

    @SneakyThrows
    public static String readFile(String filePath) {
        StringBuilder result = new StringBuilder();
        try {
            Scanner myReader = new Scanner(new File(filePath));
            while (myReader.hasNextLine()) {
                result.append(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new FileNotFoundException(format("File with path %s is not found", filePath));
        }

        return result.toString();
    }

    public static List<Command> parse(String commandsString) {
        return Arrays.stream(commandsString.split("\n")).map(s -> {
            String[] strings = s.split(" ");
            switch (strings[0]) {
                case "ALLOT_WATER":
                    String[] ratioOfWater = strings[2].split(":");
                    return new Command(strings[0], strings[1], ratioOfWater[0],ratioOfWater[1]);
                case "ADD_GUESTS" :
                    return new Command(strings[0], strings[1]);
                case "BILL":
                    return new Command(strings[0]);
                default:
                    throw new RuntimeException(format("Illegal command %s", strings[0]));
            }
        }).collect(Collectors.toList());
    }
}
