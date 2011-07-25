package com.pav4it.imf;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Andrey Popov creates on 22.07.11 (16:58)
 */
public class GenericValue implements UserType {
    private final Logger logger = LoggerFactory.getLogger(GenericValue.class);

    private static final int[] SQL_TYPES = new int[]{
            Types.VARCHAR
    };

    @Override
    public int[] sqlTypes() {
        return SQL_TYPES;
    }

    @Override
    public Class returnedClass() {
        return Object.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return x == y;
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, Object owner) throws HibernateException, SQLException {
        String value = rs.getString(names[0]);
        //TODO WTF Code... Надо бы переделать... Не красиво...
        if (value != null) {
            try {
                int returnValue = Integer.parseInt(value);
                logger.error("Return Integer Value: {}", returnValue);
                return returnValue;
            } catch (NumberFormatException intEx) {
                try {
                    double returnValue = Double.parseDouble(value);
                    logger.error("Return Double Value: {}", returnValue);
                    return returnValue;
                } catch (NumberFormatException doubleEx) {
                    try {
                        DateFormat dateFormat = new SimpleDateFormat();
                        Date returnValue = dateFormat.parse(value);
                        logger.error("Return Date Value: {}", returnValue);
                        return returnValue;
                    } catch (ParseException dateEx) {
                        //TODO Круто, да? :) Надо переделать...
                        if ("true".equalsIgnoreCase(value) || "false".equalsIgnoreCase(value)) {
                            boolean returnValue = Boolean.parseBoolean(value);
                            logger.error("Return Boolean Value: {}", returnValue);
                            return returnValue;
                        } else {
                            logger.error("Return String Value: {}", value);
                            return value;
                        }
                    }
                }
            }
        } else {
            return null;
        }
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index) throws HibernateException, SQLException {
        if (value == null) {
            st.setString(index, null);
        } else {
            st.setString(index, value.toString());
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) value;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return cached;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original;
    }

}
