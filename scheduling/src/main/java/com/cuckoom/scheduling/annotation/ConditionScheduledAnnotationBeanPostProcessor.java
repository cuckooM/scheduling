package com.cuckoom.scheduling.annotation;

import com.cuckoom.scheduling.support.ConditionScheduledMethodRunnable;
import org.springframework.aop.support.AopUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.util.Assert;

import java.lang.reflect.Method;

/**
 * 为 {@link Scheduled @Scheduled} 增加执行条件
 * @author cuckooM
 */
public class ConditionScheduledAnnotationBeanPostProcessor extends ScheduledAnnotationBeanPostProcessor {

    @Override
    protected Runnable createRunnable(Object target, Method method) {
        Assert.isTrue(method.getParameterCount() == 0, "Only no-arg methods may be annotated with @Scheduled");
        Method invocableMethod = AopUtils.selectInvocableMethod(method, target.getClass());
        return new ConditionScheduledMethodRunnable(target, invocableMethod);
    }

}
