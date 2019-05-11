/*
    Zadanie 7
    Autor: Rafał Tęcza & Damian Brzoskowski
    Index: s19468 & s18499
*/

package pjwstk.lab4.zadanie7;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = Files.newBufferedReader(Paths.get("src/assets/words.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");

                line = line.replace(".", "").replace(",", "").toLowerCase();
                String[] words = line.split(" ");

                for(String word : words) {
                    if(map.containsKey(word)) {
                        map.put(word, map.get(word) + 1);
                    } else {
                        map.put(word, 1);
                    }
                }
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        System.out.println(map);
    }
}
