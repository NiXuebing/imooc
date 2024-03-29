package com.ice.imooc.spring.reactive.loader;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * {@link Future} 阻塞数据加载器
 *
 * @author : ACE
 * @date : 2019/9/9
 */
public class FutureBlockingDataLoader extends DataLoader {

    @Override
    protected void doLoad() {
        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        runCompletely(executorService.submit(super::loadConfigurations));
        runCompletely(executorService.submit(super::loadUsers));
        runCompletely(executorService.submit(super::loadOrders));
        executorService.shutdown();
    }

    private void runCompletely(Future<?> future) {
        try {
            future.get();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        new FutureBlockingDataLoader().load();
    }

}

