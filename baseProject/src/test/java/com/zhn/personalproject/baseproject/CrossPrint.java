package com.zhn.personalproject.baseProject;

public class CrossPrint {
    public static volatile Object lock = new Object();
    public static volatile int flag = 0;
    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
    }
    public static class Thread1 implements Runnable{
        int count = 0;
        int limit = 4;
        @Override
        public void run() {
            try {
                synchronized (lock) {
                    while (count < limit) {
                        while (flag != 0) {
                            lock.wait();
                        }
                        if (count < limit) {
                            flag = 1;
                            System.out.println("a");
                            count += 1;
                            lock.notifyAll();
                        }
                    }
                }
            }catch (Exception e){
                System.out.println(e.fillInStackTrace());
            }
        }
    }

    public static class Thread2 implements Runnable{
        int count = 0;
        int limit = 4;
        @Override
        public void run() {
            try {
                synchronized (lock) {
                    while (count < limit) {
                        while (flag != 1) {
                            lock.wait();
                        }
                        if (count < limit) {
                            flag = 0;
                            System.out.println("b");
                            count += 1;
                            lock.notifyAll();
                        }
                    }
                }
            }catch (Exception e){
                System.out.println(e.fillInStackTrace());
            }
        }
    }
}
