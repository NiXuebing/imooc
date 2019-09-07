package com.ice.imooc.spring.servlet.controller;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Random;
import java.util.concurrent.*;

/**
 * HelloWorld 异步 {@link RestController}
 *
 * @author : ACE
 * @date : 2019/9/6
 */
@RestController
@EnableScheduling
public class HelloWorldAsyncController {

    private final BlockingQueue<DeferredResult<String>> blockingDeque = new ArrayBlockingQueue<>(5);

    private final Random random = new Random();

    @Scheduled(fixedRate = 5000)
    public void process() throws InterruptedException {
        DeferredResult<String> result = null;
        do {
            result = blockingDeque.take();
            long timeout = random.nextInt(100);
            Thread.sleep(timeout);
            result.setResult("Hello, World");
            println("执行计算结果, 消耗: " + timeout + "ms");
        } while (result != null);

    }


    @GetMapping("/completion-stage")
    public CompletionStage<String> completionStage() {
        final long startTime = System.currentTimeMillis();

        println("CompletionStage Hello, World");
        return CompletableFuture.supplyAsync(() -> {
            final long costTime = System.currentTimeMillis() - startTime;
            println("执行计算结果, 消耗: " + costTime + "ms");
            return "CompletionStage Hello World";
        });
    }

    @GetMapping("/callable-hello-world")
    public Callable<String> callableHelloWorld() {
        final long startTime = System.currentTimeMillis();

        println("Callable Hello, World");
        return () -> {
            final long costTime = System.currentTimeMillis() - startTime;
            println("执行计算结果, 消耗: " + costTime + "ms");
            return "Callable Hello World";
        };

    }


    @GetMapping("/hello-world")
    public DeferredResult<String> helloWorld() {

        DeferredResult<String> result = new DeferredResult<>(50L);
        // result.setResult("Hello, World");

        //blockingDeque.offer(result);

        println("hello world");
        result.onCompletion(() -> {
            println("执行结束");
        });

        result.onTimeout(() -> {
            println("执行超时");
        });
        return result;
    }

    private static void println(Object object) {
        System.out.println("HelloWorldAsyncController[" + Thread.currentThread().getName() + "]: " + object);
    }
}
