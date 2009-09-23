/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

/**
 *
 * @author APopov
 */
public class ThreadTest implements Runnable {
  public void run() {
    double calc;
    for (int i=0; i<50000; i++) {
      calc=Math.sin(i*i);
      if (i%10000==0) {
        System.out.println(getName()+
          " counts " + i/10000);
      }
    }
  }

  public String getName() {
     return Thread.currentThread().getName();
  }

  public static void main(String s[]) {
    // Подготовка потоков
    Thread t[] = new Thread[3];
    for (int i=0; i<t.length; i++) {
      t[i]=new Thread(new ThreadTest(),
                     "Thread "+i);
    }
    // Запуск потоков
    for (int i=0; i<t.length; i++) {
      t[i].start();
      System.out.println(t[i].getName()+
                         " started");
    }
  }
}
