package com.cuckoom.scheduling.support;

import org.springframework.scheduling.support.ScheduledMethodRunnable;

import java.lang.reflect.Method;

/**
 * 按条件执行的定时任务
 * @author cuckooM
 */
public class ConditionScheduledMethodRunnable extends ScheduledMethodRunnable {

    /**
     * 构造函数
     * @param target 类对象
     * @param method 方法
     */
    public ConditionScheduledMethodRunnable(Object target, Method method) {
        super(target, method);
    }

    /**
     * 构造函数
     * @param target 类对象
     * @param methodName 方法名
     * @throws NoSuchMethodException 方法不存在异常
     */
    public ConditionScheduledMethodRunnable(Object target, String methodName) throws NoSuchMethodException {
        super(target, methodName);
    }

    @Override
    public void run() {
        super.run();
    }
}
