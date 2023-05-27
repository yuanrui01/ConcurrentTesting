package org.fanchekeji.fun.lowlevel;// lowlevel/IntTestable.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.concurrent.TimeUnit;
import java.util.function.*;

public abstract class
IntTestable implements Runnable, IntSupplier {
  abstract void evenIncrement();
  @Override public void run() {
    while(true)
      evenIncrement();
  }

  public static void main(String[] args) {
    TimeUnit millseconds = TimeUnit.MILLISECONDS;
    System.out.println(millseconds.toMicros(10));
  }
}
