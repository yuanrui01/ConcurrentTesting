package org.fanchekeji.fun.reorder;

import org.fanchekeji.fun.common.Nap;

import javax.print.attribute.standard.PrinterStateReason;
import java.util.stream.IntStream;

/**
 * @description:
 * @author: yuanrui
 * @email: xdyrfree@gmail.com
 * @date: 2023/5/25-22:45
 */
public class ReorderExample {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
/*        Thread one = new Thread(() -> {
            new Nap(0.1);
            a = 1;
            x = b;
        });

        Thread two = new Thread(() -> {
            b = 1;
            y = a;
        });

        one.start();
        two.start();
        one.join();
        two.join();

        System.out.println("( " + x + "," + y + ")");*/

        IntStream.range(0, 10)
                .parallel()
                .forEach(i -> {
                    System.out.println(Thread.currentThread());
                    Thread one = new Thread(() -> {
                        new Nap(0.1);
                        a = 1;
                        x = b;
                    });

                    Thread two = new Thread(() -> {
                        b = 1;
                        y = a;
                    });

                    one.start();
                    two.start();
                    try {
                        one.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        two.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }


                    System.out.println("( " + x + "," + y + ")");
                });
    }
}
