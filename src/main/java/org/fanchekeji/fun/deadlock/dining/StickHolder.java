package org.fanchekeji.fun.deadlock.dining;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/5/23-1:46
 */
public class StickHolder {
    private static class Chopstick {}
    private Chopstick stick = new Chopstick();
    private BlockingQueue<Chopstick> holder =
            new ArrayBlockingQueue<>(1);
    public StickHolder() { putDown(); }
    public void pickUp() {
        try {
            holder.take(); // Blocks if unavailable
        } catch(InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void putDown() {
        try {
            holder.put(stick);
        } catch(InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
