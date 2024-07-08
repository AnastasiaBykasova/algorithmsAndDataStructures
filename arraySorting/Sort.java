package arraySorting;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Sort implements SortTime {
    private List<Integer> digits = new ArrayList<>();

    public Sort(List<Integer> digits) {
        this.digits = digits;
    }

    protected void sort(List<Integer> digits) {
        // Базовый метод сортировки, реализуется в подклассах
    }

    @Override
    public String getExecutionTime(LocalTime startTime, LocalTime finishTime) {
        // Вычисляем время выполнения в наносекундах
        Duration duration = Duration.between(startTime, finishTime);
        long nanoseconds = duration.toNanos();

        // Форматируем время выполнения
        long seconds = (nanoseconds % 60000000000L) / 1000000000L; // 1 секунда * 1000 миллисекунд * 1000 наносекунд
        long milliseconds = (nanoseconds % 1000000000L) / 1000000; // 1 миллисекунда * 1000 наносекунд
        long microseconds = (nanoseconds % 1000000L) / 1000; // 1 микросекунда * 1000 наносекунд
        long nanosecondsRemainder = nanoseconds % 1000; // Остаток наносекунд

        String executionTime = String.format("%02d.%03d.%03d.%03d", seconds, milliseconds, microseconds, nanosecondsRemainder);
        return executionTime;
    }

    public abstract List<Integer> runSort(List<Integer> digits);
}
