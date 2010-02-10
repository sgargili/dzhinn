/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package en;

/**
 *
 * @author APopov
 */
public enum Suits {

    Spades,
    Clubs,
    Diamonds,
    Hearts;

    static public boolean isRed(Suits suit) {
        if (suit == Suits.Diamonds || suit == Suits.Hearts) {
            return true;
        } else {
            return false;
        }
    }
}
