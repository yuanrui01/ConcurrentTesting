package org.fanchekeji.fun.lowlevel;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: yuanrui
 * @email: xdyrfree@gmail.com
 * @date: 2023/5/25-0:33
 */
public abstract class IntGenerator {
    private AtomicBoolean canceled =
            new AtomicBoolean();
    public abstract int next();
    public void cancel() { canceled.set(true); }
    public boolean isCanceled() {
        return canceled.get();
    }
}