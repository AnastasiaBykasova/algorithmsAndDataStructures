package collections;

import java.util.ArrayList;
import java.util.List;

public class MainLists {
    public static void main(String[] args) {
        List<String> listProgLangs = new ArrayList<>();
        listProgLangs.add("Java");
        listProgLangs.add("Python");
        listProgLangs.add("C");
        listProgLangs.add("CPP");
        listProgLangs.add("Kotlin");
        listProgLangs.add("Swift");
        listProgLangs.add("PHP");
        listProgLangs.add("PHP");
        listProgLangs.add("JavaScript");

        System.out.println(listProgLangs.size()); // 9
        System.out.println(listProgLangs.get(5)); // Swift
        listProgLangs.remove(6);
        listProgLangs.remove("JavaScript");
        System.out.println("\n");
        for (int i = 0; i < listProgLangs.size(); i++) {
            System.out.println(listProgLangs.get(i));
        }
    }
}
