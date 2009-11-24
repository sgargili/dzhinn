/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package en;

/**
 *
 * @author APopov
 */
public class Test {

    public static void main(String[] args) {
        Suits suit = Suits.Spades;
        try {
            System.out.println(suit.valueOf(null));
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        if (Suits.isRed(suit)) {
            System.out.println("Suit is red.");
        } else {
            System.out.println("Suit is black.");
        }
    }
}
