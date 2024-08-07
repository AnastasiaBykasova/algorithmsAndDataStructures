package collections;

import java.util.ArrayList;

public class MainArrayList {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        names.add("Иван");
        names.add("Анна");
        names.add("Мария");

        System.out.println("Список имен:");
        for (String name : names) {
            System.out.println(name);
        }

        names.remove(0);

        names.add(0, "Петр");

        System.out.println("\nОбновленный список имен:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
