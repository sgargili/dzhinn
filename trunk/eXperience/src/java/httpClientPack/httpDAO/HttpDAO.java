/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpClientPack.httpDAO;

import java.io.IOException;
import java.util.Collection;
import org.xmlpull.v1.XmlPullParserException;

/**
 *
 * @author APopov
 */
public interface HttpDAO {

    public boolean Login4Value(String Login, String Password);

    public boolean Logout4Value();

    public String DownloadFromValue(String url);

    public Collection DownloadManufacturersFromValue() throws XmlPullParserException, IOException;

    public boolean Login4Profit(String Login, String Password);

    public boolean Logout4Profit();

    public String DownloadFromProfit(String url);

    public Collection DownloadPTFromProfit()throws XmlPullParserException, IOException;

    public String DownloadContent(String url);
}
