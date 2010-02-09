/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

/**
 *
 * @author APopov
 */
public interface GreetingService {

    public String greet();

    public String greet(String subject);

    public void setGreeting(String string);
}
