/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

/**
 *
 * @author APopov
 */
public class MyRunnable implements Runnable {
   public void run() {
      // некоторое долгое действие, вычисление
      long sum=0;
      for (int i=0; i<1000; i++) {
         sum+=i;
      }
      System.out.println(sum);
   }
}

