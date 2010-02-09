/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

/**
 *
 * @author APopov
 */
public class GreetingServiceImpl implements GreetingService {

    private String greeting;

    public GreetingServiceImpl() {
    }

    // injection
    public GreetingServiceImpl(String greeting) {
        this.greeting = greeting;
    }

    public String greet() {
        return greeting;
    }

    public String greet(String subject) {
        return greeting + " " + subject;
    }

    // injection
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
