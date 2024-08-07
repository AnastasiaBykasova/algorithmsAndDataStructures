package multithreading;

class DataPreparer implements Runnable {
    private final Object monitor = new Object();
    private boolean dataReady = false;

    @Override
    public void run() {
        synchronized (monitor) {
            while (!dataReady) {
                try {
                    System.out.println("Data is not ready yet.");
                    monitor.wait(); // поток переходит в состояние ожидания
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Data is ready now.");
        }
    }

    public void prepareData() {
        synchronized (monitor) {
            dataReady = true;
            monitor.notifyAll(); // оповещает все ожидающие потоки
        }
    }
}

public class WaitNotify {
    public static void main(String[] args) {
        DataPreparer preparer = new DataPreparer();
        Thread preparerThread = new Thread(preparer);
        preparerThread.start();

        Thread consumerThread = new Thread(() -> {
            preparer.prepareData();
        });

        consumerThread.start();
    }
}



// Класс DataPreparer реализует интерфейс Runnable. У него есть метод prepareData(),
// который изменяет состояние dataReady на true и вызывает notifyAll()
// для оповещения всех ожидающих потоков.
// Внутри метода run() поток ожидает, пока данные не станут готовыми,
// используя wait(). Как только данные становятся готовыми, поток продолжает выполнение.
// В методе main создаются два потока: один для подготовки данных (preparerThread)
// и один для потребления данных (consumerThread). Поток-потребитель запускается после
// потока-представителя данных, чтобы продемонстрировать, как notifyAll() может оповестить ожидающий поток.