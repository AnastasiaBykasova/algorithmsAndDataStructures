package arraySorting;

import java.time.LocalTime;
import java.util.List;

public class InsertionSort extends Sort {
    public InsertionSort(List<Integer> digits) {
        super(digits);
    }

    @Override
    public List<Integer> runSort(List<Integer> digits) {
        LocalTime startTime = LocalTime.now();

        for (int i = 1; i < digits.size(); i++) {
            int key = digits.get(i);
            int j = i - 1;
            while (j >= 0 && key < digits.get(j)) {
                digits.set(j + 1, digits.get(j));
                j--;
            }
            digits.set(j + 1, key);
        }

        LocalTime finishTime = LocalTime.now();
        String execTime = getExecutionTime(startTime, finishTime);
        System.out.println("Время выполнения сортировки InsertionSort: " + execTime);
        return digits;
    }
}
