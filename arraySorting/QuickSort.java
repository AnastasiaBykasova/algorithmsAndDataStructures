package arraySorting;

import java.time.LocalTime;
import java.util.List;

public class QuickSort extends Sort {
    public QuickSort(List<Integer> digits) {
        super(digits);
    }

    @Override
    public List<Integer> runSort(List<Integer> digits) {
        LocalTime startTime = LocalTime.now();

        sort(digits, 0, digits.size() - 1);

        LocalTime finishTime = LocalTime.now();
        String execTime = getExecutionTime(startTime, finishTime);
        System.out.println("Время выполнения сортировки QuickSort: " + execTime);
        return digits;
    }

    private void sort(List<Integer> digits, int first, int last) {
        if (first < last) {
            int partitionIndex = partition(digits, first, last);
            sort(digits, first, partitionIndex - 1);
            sort(digits, partitionIndex + 1, last);
        }
    }

    protected int partition(List<Integer> digits, int low, int high) {
        int pivot = digits.get(high);
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (digits.get(j) <= pivot) {
                i++;
                swap(digits, i, j);
            }
        }
        swap(digits, i + 1, high);
        return (i + 1);
    }

    protected void swap(List<Integer> digits, int i, int j) {
        int temp = digits.get(i);
        digits.set(i, digits.get(j));
        digits.set(j, temp);
    }
}
