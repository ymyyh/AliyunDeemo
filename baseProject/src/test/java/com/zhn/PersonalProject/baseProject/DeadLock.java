package com.zhn.personalproject.baseproject;

public class DeadLock {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        new Thread(new Thread1(lock1, lock2)).start();
        new Thread(new Thread2(lock1, lock2)).start();
    }

    public static class Thread1 implements Runnable{
        Object lock1;
        Object lock2;
        public Thread1(Object lock1, Object lock2){
            this.lock1 = lock1;
            this.lock2 = lock2;
        }
        @Override
        public void run() {
            try{
                synchronized (lock1){
                    System.out.println("lock1 is locked !!");
                    Thread.sleep(3000);
                    synchronized (lock2){
                        System.out.println("lock2 is locked !!");
                    }
                }
            }catch (Exception e){

            }
        }
    }

    public static class Thread2 implements Runnable{
        Object lock1;
        Object lock2;
        public Thread2(Object lock1, Object lock2){
            this.lock1 = lock1;
            this.lock2 = lock2;
        }
        @Override
        public void run() {
            try{
                synchronized (lock2){
                    System.out.println("lock2 is locked !!");
                    Thread.sleep(3000);
                    synchronized (lock1){
                        System.out.println("lock1 is locked !!");
                    }
                }
            }catch (Exception e){

            }
        }
    }
}
