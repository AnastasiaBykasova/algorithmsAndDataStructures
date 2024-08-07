package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Mutex extends Thread {
    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock(); //блокировка на входе в метод
        try {
            System.out.println("Hello from Mutex!");
        }
        finally {
            lock.unlock(); // разблокировка вне блока try-catch-finally
        }
    }
}

public class MyMutex {
    public static void main(String[] args) {
        Mutex mutex = new Mutex();
        mutex.start();

        System.out.println("It's main class...");
    }
}