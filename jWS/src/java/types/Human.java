/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package types;

/**
 *
 * @author APopov
 */
public class Human {

    private String name, surname;
    private int id;

    public Human() {
    }

    public Human(String name, String surname, int id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
