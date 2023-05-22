package org.fanchekeji.fun.common;

import java.util.concurrent.TimeUnit;

/**
 * @description: 摸鱼类（打个盹）
 * @author: yuanrui
 * @email: xdyrfree@gmail.com
 * @date: 2023/5/23-1:49
 */
public class Nap {
    public Nap(double t) { // Seconds
        try {
            TimeUnit.MILLISECONDS.sleep((int)(1000 * t));
        } catch(InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public Nap(double t, String msg) {
        this(t);
        System.out.println(msg);
    }
}
