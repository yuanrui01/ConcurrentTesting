package org.fanchekeji.fun.deadlock.dining;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/5/23-1:47
 */
public class Philosopher implements Runnable {
    private final int seat;
    private final StickHolder left, right;
    public Philosopher(int seat,
                       StickHolder left, StickHolder right) {
        this.seat = seat;
        this.left = left;
        this.right = right;
    }
    @Override public String toString() {
        return "P" + seat;
    }
    @Override public void run() {
        while(true) {
            // System.out.println("Thinking");   // [1]
            right.pickUp();
            left.pickUp();
            System.out.println(this + " eating");
            right.putDown();
            left.putDown();
        }
    }
}
