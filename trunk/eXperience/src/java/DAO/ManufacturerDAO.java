/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Manufacturer;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author Admin4DB2
 */
public interface ManufacturerDAO {

    public void addManufacturer(Manufacturer manufacturer) throws SQLException;

    public void updateManufacturer(Manufacturer manufacturer) throws SQLException;

    public boolean isManufacturerPresent(String ManufacturerName) throws SQLException;

    public Manufacturer getManufacturerById(Long Manufacturer_Id) throws SQLException;

    public Collection getAllManufacturers() throws SQLException;

    public void deleteManufacturer(Manufacturer manufacturer) throws SQLException;

}
