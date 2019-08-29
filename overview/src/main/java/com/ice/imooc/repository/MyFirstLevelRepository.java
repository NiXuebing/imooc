package com.ice.imooc.repository;

import com.ice.imooc.annotation.FirstLevelRepository;
import com.ice.imooc.annotation.SecondLevelRepository;
import org.springframework.stereotype.Component;

/**
 * 我的 {@link FirstLevelRepository}
 *
 * @author : ACE
 * @date : 2019/8/28
 */
//@Component
//@FirstLevelRepository(value = "myFirstLevelRepository")
@SecondLevelRepository
public class MyFirstLevelRepository {
}
