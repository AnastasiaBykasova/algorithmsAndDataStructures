package multithreading;

import java.util.concurrent.Semaphore;

class Semapfores extends Thread {
    private final Semaphore semapfore = new Semaphore(2); // позволяет двум потокам одновременно выполнить метод run

    @Override
    public void run() {
        try {
            semapfore.acquire(); // запрос на получение разрешения
            System.out.println("Hello from Semaphore!");
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        finally {
            semapfore.release(); // освобождение разрешения
        }
    }
}

public class MySemaphore {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i ++) { // создаем пять потоков
            Semapfores semapfores = new Semapfores();
            semapfores.start();
        }

        System.out.println("It's main class...");
    }
}
