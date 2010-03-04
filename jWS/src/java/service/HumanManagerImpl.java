/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import types.Human;

/**
 *
 * @author APopov
 */
public class HumanManagerImpl implements HumanManager {

    public Human getHumanById(int id) {
        Human human = new Human("Andrey", "Popov", id);
        return human;
    }
}
