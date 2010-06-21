/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apopov.sqlformatter;

import apopov.format.BasicFormatter4SqlImpl;
import apopov.format.Formatter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import org.openide.cookies.EditorCookie;

public final class Sql2Sql implements ActionListener {

    private final EditorCookie context;

    public Sql2Sql(EditorCookie context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        Formatter fr = new BasicFormatter4SqlImpl();
        if (context != null) {
            JEditorPane[] panes = context.getOpenedPanes();
            if (panes.length > 0) {
                String selection = panes[0].getText();
                panes[0].setText(fr.format(selection));
            }
        }
    }
}
