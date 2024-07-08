package arraySorting;

import java.time.LocalTime;
import java.util.List;

public class SelectionSort extends Sort {
    public SelectionSort(List<Integer> digits) {
        super(digits);
    }

    @Override
    public List<Integer> runSort(List<Integer> digits) {
        LocalTime startTime = LocalTime.now();

        for (int i = 0; i < digits.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < digits.size(); j++) {
                if (digits.get(j) < digits.get(minIndex)) {
                    minIndex = j;
                }
            }
            swap(digits, i, minIndex);
        }

        LocalTime finishTime = LocalTime.now();
        String execTime = getExecutionTime(startTime, finishTime);
        System.out.println("Время выполнения сортировки SelectionSort: " + execTime);
        return digits;
    }

    private void swap(List<Integer> digits, int i, int j) {
        int temp = digits.get(i);
        digits.set(i, digits.get(j));
        digits.set(j, temp);
    }

}
