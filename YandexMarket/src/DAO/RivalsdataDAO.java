/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Rivalsdata;
import Pojo.RivalsdataId;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author Admin4DB2
 */
public interface RivalsdataDAO {

    public void addRivalsdata(Rivalsdata rivalsdata) throws SQLException;

    public Collection getAllRivalsdata() throws SQLException;

    public Collection getAllRivalsDataByArticleId(long id) throws SQLException;

    public Rivalsdata getRivalsdataByArticleId(long id) throws SQLException;

    public double getAveragePriceByArticleId(long articleId) throws SQLException;

    public double getMinimumPriceByArticleId(long articleId) throws SQLException;

    public double getMinimumSumPriceByArticleId(long articleId) throws SQLException;

    public RivalsdataId getId4MinimumPriceByArticleId(long articleId) throws SQLException;

    public RivalsdataId getId4MinimumSumPriceByArticleId(long articleId) throws SQLException;

    public double getAveragePriceByArticleId(long articleId, int size) throws SQLException;
    // public boolean isRivalsPresent(String rival) throws SQLException;
}
