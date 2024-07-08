package arraySorting;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MergeSort extends Sort {
    public MergeSort(List<Integer> digits) {
        super(digits);
    }

    @Override
    public List<Integer> runSort(List<Integer> digits) {
        LocalTime startTime = LocalTime.now();

        sort(digits, 0, digits.size() - 1);

        LocalTime finishTime = LocalTime.now();
        String execTime = getExecutionTime(startTime, finishTime);
        System.out.println("Время выполнения сортировки MergeSort: " + execTime);
        return digits;
    }

    private void sort(List<Integer> digits, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(digits, left, mid);
            sort(digits, mid + 1, right);
            merge(digits, left, mid, right);
        }
    }

    private void merge(List<Integer> digits, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        List<Integer> leftArray = new ArrayList<>();
        List<Integer> rightArray = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            leftArray.add(digits.get(left + i));
        }
        for (int j = 0; j < n2; j++) {
            rightArray.add(digits.get(mid + 1 + j));
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray.get(i) <= rightArray.get(j)) {
                digits.set(k, leftArray.get(i));
                i++;
            } else {
                digits.set(k, rightArray.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            digits.set(k, leftArray.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            digits.set(k, rightArray.get(j));
            j++;
            k++;
        }
    }

}
