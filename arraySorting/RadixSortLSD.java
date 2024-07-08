package arraySorting;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RadixSortLSD extends Sort {
    public RadixSortLSD(List<Integer> digits) {
        super(digits);
    }

    @Override
    public List<Integer> runSort(List<Integer> digits) {
        LocalTime startTime = LocalTime.now();

        sort(digits);

        LocalTime finishTime = LocalTime.now();
        String execTime = getExecutionTime(startTime, finishTime);
        System.out.println("Время выполнения сортировки RadixSortLSD: " + execTime);
        return digits;
    }

    protected void sort(List<Integer> digits) {
        if (digits == null || digits.isEmpty()) {
            return;
        }

        // Находим максимальную длину числа (количество разрядов)
        int maxLen = String.valueOf(digits.get(0)).length();
        for (int digit : digits) {
            int len = String.valueOf(digit).length();
            if (len > maxLen) {
                maxLen = len;
            }
        }

        // Сортировка по разрядам, начиная с наименее значимого
        for (int i = 0; i < maxLen; i++) {
            List<List<Integer>> buckets = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                buckets.add(new ArrayList<>());
            }

            // Раздаем элементы по корзинам (buckets) в зависимости от значения разряда
            for (int digit : digits) {
                int digitValue = getDigit(digit, i);
                buckets.get(digitValue).add(digit);
            }

            // Собираем отсортированные элементы обратно в список
            digits.clear();
            for (List<Integer> bucket : buckets) {
                digits.addAll(bucket);
            }
        }
    }

    private int getDigit(int num, int digitIndex) {
        String numStr = String.valueOf(num);
        if (digitIndex >= numStr.length()) {
            return 0; // Возвращаем 0, если разряд отсутствует
        }
        return Integer.parseInt(String.valueOf(numStr.charAt(numStr.length() - 1 - digitIndex)));
    }
}
