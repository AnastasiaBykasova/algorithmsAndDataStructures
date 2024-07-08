package arraySorting;

import java.time.LocalTime;
import java.util.List;

public class BubbleSort extends Sort {
    public BubbleSort(List<Integer> digits) {
        super(digits);
    }

    @Override
    public List<Integer> runSort(List<Integer> digits) {
        LocalTime startTime = LocalTime.now();
        for (int i = 0; i < digits.size() - 1; i++) {
            for (int j = 0; j < digits.size() - i - 1; j++) {
                if (digits.get(j) > digits.get(j + 1)) {
                    int temp = digits.get(j);
                    digits.set(j, digits.get(j + 1));
                    digits.set(j + 1, temp);
                }
            }
        }
        LocalTime finishTime = LocalTime.now();
        String execTime = getExecutionTime(startTime, finishTime);
        System.out.println("Время выполнения сортировки BubbleSort: " + execTime);
        return digits;
    }
}
