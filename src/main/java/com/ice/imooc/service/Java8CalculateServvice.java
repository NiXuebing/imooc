package com.ice.imooc.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * Java 8 lambda 循环实现 {@link CalculateService}
 *
 * @author : ACE
 * @date : 2019/8/29
 */
@Profile("Java8")
@Service
public class Java8CalculateServvice implements CalculateService {

    @Override
    public Integer sum(Integer... values) {
        System.out.println("Java 8 lambda 循环实现:");
        int sum = Stream.of(values).reduce(0, Integer::sum);
        return sum;
    }
}
