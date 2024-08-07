package collections;


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class MainSets {
    public static void main(String[] args) {
        Set<String> setProgLangs = new HashSet<>();
        setProgLangs.add("Java");
        setProgLangs.add("Python");
        setProgLangs.add("C");
        setProgLangs.add("CPP");
        setProgLangs.add("Kotlin");
        setProgLangs.add("Swift");
        setProgLangs.add("PHP");
        setProgLangs.add("PHP");
        setProgLangs.add("JavaScript");

        System.out.println("Size of the set: " + setProgLangs.size() + "\n"); // 8
        for (String lang : setProgLangs) {
            System.out.println(lang);
        }
//        setProgLangs.remove(6);
        setProgLangs.remove("JavaScript");
        System.out.println(setProgLangs.contains("Java") + "\n"); // true

        for (String lang : setProgLangs) {
            System.out.println(lang);
        }

        System.out.println("\n");

        Set<String> linkedSetProgLangs = new LinkedHashSet<>();
        linkedSetProgLangs.add("Java");
        linkedSetProgLangs.add("Python");
        linkedSetProgLangs.add("C");
        linkedSetProgLangs.add("CPP");
        linkedSetProgLangs.add("Kotlin");
        linkedSetProgLangs.add("Swift");
        linkedSetProgLangs.add("PHP");
        linkedSetProgLangs.add("PHP");
        linkedSetProgLangs.add("JavaScript");

        System.out.println("Size of the set: " + linkedSetProgLangs.size() + "\n"); // 8
        for (String lang : linkedSetProgLangs) {
            System.out.println(lang);
        }
    }
}
