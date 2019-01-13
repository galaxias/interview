package javaQuestions.thread;

public class InterruptExample1 {

    private static class MyThread2 extends Thread {
        @Override
        public void run() {
            while (!interrupted()) {
                // ..
            }
            System.out.println("Thread end");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread2 = new MyThread2();
        thread2.start();
        thread2.interrupt();
    }
}
