package arraySorting;

import java.time.LocalTime;
import java.util.List;
import java.util.Random;

public class RandomQuickSort extends QuickSort {
    private Random random;
    public RandomQuickSort(List<Integer> digits) {
        super(digits);
        random = new Random();
    }

    @Override
    public List<Integer> runSort(List<Integer> digits) {
        LocalTime startTime = LocalTime.now();

        sort(digits, 0, digits.size() - 1);

        LocalTime finishTime = LocalTime.now();
        String execTime = getExecutionTime(startTime, finishTime);
        System.out.println("Время выполнения сортировки RandomQuickSort: " + execTime);
        return digits;
    }

    private void sort(List<Integer> digits, int first, int last) {
        if (first < last) {
            // Рандомный индекс для пивот элемента
            int pivotIndex = random.nextInt(last - first + 1) + first;
            // Перемещаем пивот элемент в конец
            swap(digits, pivotIndex, last);
            int partitionIndex = partition(digits, first, last);
            sort(digits, first, partitionIndex - 1);
            sort(digits, partitionIndex + 1, last);
        }
    }
}