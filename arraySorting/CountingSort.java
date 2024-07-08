package arraySorting;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CountingSort extends Sort {
    public CountingSort(List<Integer> digits) {
        super(digits);
    }

    @Override
    public List<Integer> runSort(List<Integer> digits) {
        LocalTime startTime = LocalTime.now();

        sort(digits);

        LocalTime finishTime = LocalTime.now();
        String execTime = getExecutionTime(startTime, finishTime);
        System.out.println("Время выполнения сортировки CountingSort: " + execTime);
        return digits;
    }

    public void sort(List<Integer> digits) {
        if (digits == null || digits.isEmpty()) {
            return; // Если список пуст или null, ничего не делаем
        }

        // Находим максимальное значение в списке
        int max = digits.get(0);
        for (int digit : digits) {
            if (digit > max) {
                max = digit;
            }
        }

        // Создаем массив для подсчета
        int[] count = new int[max + 1];
        for (int digit : digits) {
            count[digit]++;
        }

        // Собираем отсортированный список
        List<Integer> sorted = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < count[i]; j++) {
                sorted.add(i);
            }
        }

        // Перезаписываем исходный список отсортированным
        digits.clear();
        digits.addAll(sorted);
    }
}
