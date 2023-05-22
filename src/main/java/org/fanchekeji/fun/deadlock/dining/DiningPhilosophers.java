package org.fanchekeji.fun.deadlock.dining;

import org.fanchekeji.fun.common.Nap;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/5/23-1:48
 */
public class DiningPhilosophers {
    private StickHolder[] sticks;
    private Philosopher[] philosophers;
    public DiningPhilosophers(int n) {
        sticks = new StickHolder[n];
        Arrays.setAll(sticks, i -> new StickHolder());
        philosophers = new Philosopher[n];
        Arrays.setAll(philosophers, i ->
                new Philosopher(i,
                        sticks[i], sticks[(i + 1) % n]));    // [1]
        // Fix by reversing stick order for this one:
        // philosophers[1] =                     // [2]
        //   new Philosopher(0, sticks[0], sticks[1]);
        Arrays.stream(philosophers)
                .forEach(CompletableFuture::runAsync); // [3]
    }
    public static void main(String[] args) {
        // Returns right away:
        new DiningPhilosophers(2);               // [4]
        // Keeps main() from exiting:
        new Nap(3, "Shutdown");
    }
}