package lesson_5;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // Создаём одномерный массив
        final int size = 10000000;
        final int h = size / 2;

        float[] arr = new float[size];

        noThread(arr);
        withThread(arr);

    }


    public static void noThread(float[] arr) {

        Arrays.fill(arr, 1);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long executionTime = System.currentTimeMillis() - startTime;

        System.out.println("Операция первого метода без потоков прошла за " + ((float) executionTime / 1000) + " секунд.");

    }

    public static void withThread(float[] arr) throws InterruptedException {

        long startTime = System.currentTimeMillis();
        long firstThreadStartTime = System.currentTimeMillis();
        long secondThreadStartTime = System.currentTimeMillis();

        // Синхронизирвоали работу с переменной
        synchronized (arr) {

            // Создали первый поток
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < arr.length / 2; i++) {
                        arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    }

                    long firstThreadExecutionTime = System.currentTimeMillis() - firstThreadStartTime;
                    System.out.println("Выполнение первого потока прошло за " + +((float) firstThreadExecutionTime / 1000) + " секунд.");
                }
            });

            t1.start();

            // Создали второй поток
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = arr.length / 2; i < arr.length; i++) {
                        arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    }

                    long secondThreadExecutionTime = System.currentTimeMillis() - secondThreadStartTime;
                    System.out.println("Выполнение второго потока прошло за " + +((float) secondThreadExecutionTime / 1000) + " секунд.");

                }
            });

            // t1.start();
            t2.start();
            t1.join();
            t2.join();

            long executionTime = System.currentTimeMillis() - startTime;
            System.out.println("Общее время выполнения второго метода с потоками прошло за " + ((float) executionTime / 1000) + " секунд.");

        }
    }
}
