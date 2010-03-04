/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

import types.Human;

/**
 *
 * @author APopov
 */
public class HumanResponse {

    private Human human;

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public HumanResponse(Human human) {
        this.human = human;
    }

    public HumanResponse() {
    }
}
