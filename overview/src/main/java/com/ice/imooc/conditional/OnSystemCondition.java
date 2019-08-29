package com.ice.imooc.conditional;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * Java 系统属性 条件判断
 *
 * @author : ACE
 * @date : 2019/8/29
 */
public class OnSystemCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
        String propertyName = String.valueOf(attributes.get("name"));
        String propertyValue = String.valueOf(attributes.get("value"));

        String javaPropertyValue = System.getProperty(propertyName);
        return propertyValue.equals(javaPropertyValue);
    }
}
