/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author APopov
 */
public interface Download {

    public void loadContentFromCdDiski(String article, String url);

    public void loadContentFromCdVSeti(String article, String url);

    public void loadContentFromPleer(String article, String url);

    public String askGoogle(String description);
}
