/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package format;

/**
 *
 * @author APopov
 */
public class TestClass {

    public static void main(String[] arg) {
        Formatter fr = new BasicFormatterImpl();
        String query = "select                   * " +
                "" +
                "" +
                "" +
                "" +
                "           " +
                "" +
                "" +
                "from entity as a where a.id = ?";
        System.out.println(fr.format(query));
    }
}
