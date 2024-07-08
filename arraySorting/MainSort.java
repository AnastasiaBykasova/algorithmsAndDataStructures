package arraySorting;

//info: https://proglib.io/p/sort-gif

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainSort {
    public static void main(String[] args) {
        // Создаем список чисел, заполняя его 500 рандомными числами
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            numbers.add(random.nextInt(100000)); // Генерируем числа от 0 до 999
        }

        // сортировка пузырьком
        BubbleSort bubbleSort = new BubbleSort(numbers);
        List<Integer> sortedBubble = bubbleSort.runSort(numbers);

        System.out.println("Отсортированный список:");
        for (Integer number : sortedBubble) {
            System.out.print(number + " ");
        }
        System.out.println("\n");

        // быстрая сортировка
        QuickSort quickSort = new QuickSort(numbers);
        List<Integer> sortedQuick = quickSort.runSort(numbers);

        System.out.println("Отсортированный список:");
        for (Integer number : sortedQuick) {
            System.out.print(number + " ");
        }
        System.out.println("\n");

        // рандомная быстрая сортировка
        RandomQuickSort randomQuickSort = new RandomQuickSort(numbers);
        List<Integer> sortedQuickRandom = randomQuickSort.runSort(numbers);

        System.out.println("Отсортированный список:");
        for (Integer number : sortedQuickRandom) {
            System.out.print(number + " ");
        }
        System.out.println("\n");

        // сортировка слиянием
        MergeSort mergeSort = new MergeSort(numbers);
        List<Integer> sortedMerge = mergeSort.runSort(numbers);

        System.out.println("Отсортированный список:");
        for (Integer number : sortedMerge) {
            System.out.print(number + " ");
        }
        System.out.println("\n");

        // сортировка выбором
        SelectionSort selectionSort = new SelectionSort(numbers);
        List<Integer> sortedSelection = selectionSort.runSort(numbers);

        System.out.println("Отсортированный список:");
        for (Integer number : sortedSelection) {
            System.out.print(number + " ");
        }
        System.out.println("\n");

        // сортировка вставками
        InsertionSort insertionSort = new InsertionSort(numbers);
        List<Integer> sortedInsertion = insertionSort.runSort(numbers);

        System.out.println("Отсортированный список:");
        for (Integer number : sortedInsertion) {
            System.out.print(number + " ");
        }
        System.out.println("\n");

        // сортировка подсчетом
        CountingSort сountingSort = new CountingSort(numbers);
        List<Integer> sortedCounting = сountingSort.runSort(numbers);

        System.out.println("Отсортированный список:");
        for (Integer number : sortedCounting) {
            System.out.print(number + " ");
        }
        System.out.println("\n");

        // поразрядная сортировка LSD
        RadixSortLSD radixLSDSort = new RadixSortLSD(numbers);
        List<Integer> sortedRadixLSD = radixLSDSort.runSort(numbers);

        System.out.println("Отсортированный список:");
        for (Integer number : sortedRadixLSD) {
            System.out.print(number + " ");
        }
        System.out.println("\n");

        // поразрядная сортировка MSD
        RadixSortMSD radixMSDSort = new RadixSortMSD(numbers);
        List<Integer> sortedRadixMSD = radixMSDSort.runSort(numbers);

        System.out.println("Отсортированный список:");
        for (Integer number : sortedRadixMSD) {
            System.out.print(number + " ");
        }
        System.out.println("\n");
    }
}
