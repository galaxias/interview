package javaQuestions.thread;

public class MyRunnable implements Runnable {
    public void run() {
        System.out.println("running");
    }


    public static void main(String[] args) {
        MyRunnable instance = new MyRunnable();
        Thread thread = new Thread(instance);
        thread.start();
    }


}