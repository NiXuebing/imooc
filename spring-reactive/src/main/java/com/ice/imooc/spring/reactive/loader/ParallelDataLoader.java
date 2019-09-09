package com.ice.imooc.spring.reactive.loader;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 并行数据加载器
 *
 * @author : ACE
 * @date : 2019/9/9
 */
public class ParallelDataLoader extends DataLoader {

    @Override
    protected void doLoad() {  // 并行计算
        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletionService completionService = new ExecutorCompletionService(executorService);
        //  耗时 >= 1s
        completionService.submit(super::loadConfigurations, null);
        //  耗时 >= 2s
        completionService.submit(super::loadUsers, null);
        //  耗时 >= 3s
        completionService.submit(super::loadOrders, null);

        int count = 0;
        while (count < 3) { // 等待三个任务完成
            if (completionService.poll() != null) {
                count++;
            }
        }
        executorService.shutdown();
    }  // 总耗时 max(1s, 2s, 3s)  >= 3s

    public static void main(String[] args) {
        new ParallelDataLoader().load();
    }

}

