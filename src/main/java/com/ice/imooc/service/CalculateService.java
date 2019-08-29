package com.ice.imooc.service;

/**
 * 计算服务
 *
 * @author : ACE
 * @date : 2019/8/29
 */
public interface CalculateService {
    /**
     * 从多个整数 sum 求和
     *
     * @param values 多个整数
     * @return sum 累计值
     */
    Integer sum(Integer... values);
}
