/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apopov.sqlformatter;

import apopov.format.BasicFormatter4PhpImpl;
import apopov.format.Formatter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JEditorPane;
import org.openide.cookies.EditorCookie;

public final class Sql2Php implements ActionListener {

    private final EditorCookie context;

    public Sql2Php(EditorCookie context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        Formatter fr = new BasicFormatter4PhpImpl();
        if (context != null) {
            JEditorPane[] panes = context.getOpenedPanes();
            if (panes.length > 0) {
                String selection = panes[0].getSelectedText();
//                String variarle = "", sql = "";
//                Pattern pat = Pattern.compile("(.*[$].*?=)(.*)");
//                Matcher match = pat.matcher(selection);
//                if (match.find()) {
//                    variarle = match.group(1);
//                    sql = match.group(2);
//                    pat = Pattern.compile("(^\")|(^\\s\")");
//                    match = pat.matcher(sql);
//                    if (match.find()) {
//                        sql = sql.replaceAll("(^\")|(^\\s\")", "");
//                        pat = Pattern.compile("(.*)\"(.*)");
//                        match = pat.matcher(sql);
//                        if (match.find()) {
//                            sql = match.group(1) + match.group(2);
//                        }
//                    }
//                }
//                panes[0].replaceSelection(variarle + fr.format(sql));
                panes[0].replaceSelection(fr.format(selection));
                int start = panes[0].getSelectionStart();
                int end = panes[0].getSelectionEnd();
                panes[0].select(start, end);
            }
        }
    }
}
