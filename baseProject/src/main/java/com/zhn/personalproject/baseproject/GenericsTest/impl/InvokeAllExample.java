package com.zhn.personalproject.baseproject.GenericsTest.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class InvokeAllExample {
    public static void main(String[] args) {
        // 创建一个固定大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2));

        // 创建一组Callable任务
        List<Callable<String>> tasks = Arrays.asList(
            () -> {
                TimeUnit.SECONDS.sleep(1);
                return "Task 1 completed";
            },
            () -> {
                TimeUnit.SECONDS.sleep(2);
                return "Task 2 completed";
            },
            () -> {
                TimeUnit.SECONDS.sleep(3);
                return "Task 3 completed";
            }
        );

        try {
            // 使用invokeAll方法批量提交任务
            List<Future<String>> futures = executorService.invokeAll(tasks);

            // 遍历Future对象列表，获取任务的执行结果
            for (Future<String> future : futures) {
                try {
                    System.out.println(future.get());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 关闭ExecutorService
            executorService.shutdown();
        }
    }
}
