package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainMaps {
    public static void main(String[] args) {
        Map<String, Integer> mapProgLangs = new HashMap<>();
        mapProgLangs.put("Java", 1);
        mapProgLangs.put("Python", 4);
        mapProgLangs.put("C", 2);
        mapProgLangs.put("CPP", 3);
        mapProgLangs.put("Kotlin", 5);
        mapProgLangs.put("Swift", 9);
        mapProgLangs.put("PHP", 7);
        mapProgLangs.put("PHP", 8);
        mapProgLangs.put("JavaScript", 7);

        System.out.println("Size of the set: " + mapProgLangs.size() + "\n"); // 8

//        mapProgLangs.remove(6);
        mapProgLangs.remove("JavaScript");
        System.out.println("Size of the set: " + mapProgLangs.size() + "\n"); // 6


        Map<String, Integer> ages = new LinkedHashMap<>();
        ages.put("Alice", 25);
        ages.put("Bob", 30);
        ages.put("Charlie", 35);
        ages.forEach((name, age) -> System.out.println(name + ": " + age));
    }
}
