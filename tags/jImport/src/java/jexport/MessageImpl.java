/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jexport;

/**
 *
 * @author APopov
 */
public class MessageImpl implements Message {

    private String name;

    public MessageImpl() {
    }

    public MessageImpl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String sayHello() {
        return name;
    }

    @Override
    public String sayHello(String name) {
        return name;
    }
}
