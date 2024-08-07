package arraySorting;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class TestSort {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(7, 3, 5, 4, 8, 10);
        System.out.println("Начальный список: " + arr);
        TestQuickSort quickSort = new TestQuickSort(arr);
        List<Integer> sortedList = quickSort.runSort(arr);
        System.out.println("Отсортированный список: " + sortedList);
    }
}

class TestQuickSort extends Sort {
    public TestQuickSort(List<Integer> digits) {
        super(digits);
    }

    @Override
    public List<Integer> runSort(List<Integer> digits) {
        LocalTime startTime = LocalTime.now();

        sort(digits, 0, digits.size() - 1);

        LocalTime finishTime = LocalTime.now();
        String execTime = getExecutionTime(startTime, finishTime);
        return digits;
    }

    private void sort(List<Integer> digits, int first, int last) {
        if (first < last) {
            int partitionIndex = partition(digits, first, last);

            System.out.println("Состояние списка после разделения: " + digits);

            sort(digits, first, partitionIndex - 1);
            sort(digits, partitionIndex + 1, last);
        }
    }

    protected int partition(List<Integer> digits, int first, int last) {
        int pivot = digits.get(last);
        int i = (first - 1);
        for (int j = first; j <= last - 1; j++) {
            if (digits.get(j) <= pivot) {
                i++;
                swap(digits, i, j);

                // Выводим состояние списка после каждого обмена
                System.out.println("Состояние списка после обмена: " + digits);
            }
        }
        swap(digits, i + 1, last);
        return (i + 1);
    }

    protected void swap(List<Integer> digits, int i, int j) {
        int temp = digits.get(i);
        digits.set(i, digits.get(j));
        digits.set(j, temp);
    }
}
