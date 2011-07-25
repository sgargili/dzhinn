package com.pav4it.imf;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Andrey Popov creates on 25.07.11 (10:58)
 */
public class ValueTypeTest {
    private final Logger logger = LoggerFactory.getLogger(ValueTypeTest.class);

    @Test
    public void testGetValue() throws Exception {

    }

    @Test
    public void testGetValues() throws Exception {

    }

    @Test
    public void testGetFromString() throws Exception {

    }

    @Test
    public void testGetFromValueType() throws Exception {
        logger.error(ValueType.getFromValueType(ValueType.Integer)+"");
    }
}
