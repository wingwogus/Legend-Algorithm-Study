package 백준.김건우.week2;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WordSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();

        for(int i = 0; i < count; i++) {
            words.add(br.readLine());
        }

        words.stream().distinct().sorted(Comparator.comparing(String::length).thenComparing(String::compareTo))
                .forEach(System.out::println);
    }
}