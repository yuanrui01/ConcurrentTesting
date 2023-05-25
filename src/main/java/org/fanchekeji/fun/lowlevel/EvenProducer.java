package org.fanchekeji.fun.lowlevel;// lowlevel/EvenProducer.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// When threads collide
// {VisuallyInspectOutput}

import java.util.concurrent.atomic.AtomicInteger;

public class EvenProducer extends IntGenerator {
  private AtomicInteger currentEvenValue = new AtomicInteger(0);
  @Override public int next() {
    currentEvenValue.getAndAdd(2);
/*    ++currentEvenValue;                   // [1]
    ++currentEvenValue;*/
    return currentEvenValue.get();
  }
  public static void main(String[] args) {
    EvenChecker.test(new EvenProducer());
  }
}
/* Output:
419 not even!
425 not even!
423 not even!
421 not even!
417 not even!
*/
