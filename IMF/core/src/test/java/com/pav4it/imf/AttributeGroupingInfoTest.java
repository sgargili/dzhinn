package com.pav4it.imf;

import java.io.StringWriter;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Andrey Popov creates on 16.08.11 (15:50)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
//@Transactional
public class AttributeGroupingInfoTest {

    private static final Logger log = LoggerFactory.getLogger(AttributeGroupingInfoTest.class);

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Autowired
    private Jaxb2Marshaller jaxb2Marshaller;

    @Test
    public void test() throws Exception {
        List<AttributeGroupingInfo> infos = hibernateTemplate.loadAll(AttributeGroupingInfo.class);
//        log.error("{}", infos.size());

//        AttributeGroupingInfo info = new AttributeGroupingInfo();
//        info.setComposite(true);
//        info.setWeight(1);
//        AttributeGroupingInfo.Key key = new AttributeGroupingInfo.Key(1l, 1l);
//        info.setId(key);
//        hibernateTemplate.saveOrUpdate(info);
//        log.error("{}", "");
//        AttributeGroupingInfo info = hibernateTemplate.get(AttributeGroupingInfo.class, new AttributeGroupingInfo.Key(1, 1));
        final StringWriter out = new StringWriter();
//        jaxb2Marshaller.marshal(info, new StreamResult(out));
//        log.error(out.getBuffer().toString());
//        out.flush();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(out, infos);
        log.error(out.getBuffer().toString());
    }
}
