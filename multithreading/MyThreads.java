package multithreading;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from myThread!");

    }
}

public class MyThreads {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("It's main class...");
    }
}
