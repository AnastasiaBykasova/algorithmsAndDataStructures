package arraySorting;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RadixSortMSD extends Sort {
    public RadixSortMSD(List<Integer> digits) {
        super(digits);
    }

    @Override
    public List<Integer> runSort(List<Integer> digits) {
        LocalTime startTime = LocalTime.now();

        sort(digits);

        LocalTime finishTime = LocalTime.now();
        String execTime = getExecutionTime(startTime, finishTime);
        System.out.println("Время выполнения сортировки RadixSortMSD: " + execTime);
        return digits;
    }

    protected void sort(List<Integer> digits) {
        if (digits == null || digits.isEmpty()) {
            return;
        }

        radixSortMSD(digits, 0, digits.size() - 1, getMaxDigits(digits));
    }

    private void radixSortMSD(List<Integer> digits, int low, int high, int maxDigits) {
        if (low >= high || maxDigits < 0) {
            return;
        }

        // Создаем массив для хранения индексов корзин (buckets)
        List<Integer> bucketIndices = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bucketIndices.add(0);
        }

        // Раздаем элементы по корзинам (buckets) в зависимости от значения разряда
        for (int i = low; i <= high; i++) {
            int digitValue = getDigit(digits.get(i), maxDigits);
            bucketIndices.set(digitValue, bucketIndices.get(digitValue) + 1);
        }

        // Вычисляем кумулятивные индексы для каждой корзины
        for (int i = 1; i < 10; i++) {
            bucketIndices.set(i, bucketIndices.get(i) + bucketIndices.get(i - 1));
        }

        // Создаем вспомогательный список для хранения отсортированных элементов
        //  Инициализируем список sorted элементами из digits
        List<Integer> sorted = new ArrayList<>(digits);
        for (int i = high; i >= low; i--) {
            int digitValue = getDigit(digits.get(i), maxDigits);
            int bucketIndex = bucketIndices.get(digitValue) - 1;
            //sorted.add(bucketIndex, digits.get(i));
            sorted.set(bucketIndex, digits.get(i));
            bucketIndices.set(digitValue, bucketIndices.get(digitValue) - 1);
        }

        // Перезаписываем исходный список отсортированным
        for (int i = low; i <= high; i++) {
            digits.set(i, sorted.get(i - low));
        }

        // Рекурсивно сортируем каждую корзину
        for (int i = 0; i < 9; i++) {
            radixSortMSD(digits, low + bucketIndices.get(i), low + bucketIndices.get(i + 1) - 1, maxDigits - 1);
        }
    }

    private int getMaxDigits(List<Integer> digits) {
        int maxLen = String.valueOf(digits.get(0)).length();
        for (int digit : digits) {
            int len = String.valueOf(digit).length();
            if (len > maxLen) {
                maxLen = len;
            }
        }
        return maxLen - 1; // Индекс самого старшего разряда
    }

    private int getDigit(int num, int digitIndex) {
        String numStr = String.valueOf(num);
        if (digitIndex >= numStr.length()) {
            return 0; // Возвращаем 0, если разряд отсутствует
        }
        return Integer.parseInt(String.valueOf(numStr.charAt(numStr.length() - 1 - digitIndex)));
    }
}
