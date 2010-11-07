package ira.xml;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by IntelliJ IDEA.
 * User: PAV
 * Date: 07.11.2010
 * Time: 16:48:55
 * To change this template use File | Settings | File Templates.
 */
public class XmlFileFilter implements FileFilter {

    public boolean accept(File pathname) {
        return pathname.getAbsolutePath().toLowerCase().endsWith(".xhtml");
    }
}
