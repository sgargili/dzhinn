package sws.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import sws.dao.DataDao;
import sws.dto.DataRequest;
import sws.dto.DataResponce;
import sws.service.DataService;

/**
 * User: Andrey Popov
 * Date: 14.12.10
 * Time: 16:47
 */
@Repository
@Service("dataService")
public class DataServiceImpl implements DataService {
    @Autowired
    private DataDao dataDao;

    private DataResponce dataResponce = new DataResponce();

    public DataResponce getDataResponce(DataRequest dataRequest) {
        if (dataRequest.getRequestType() == 0) {
            dataResponce.setDatas(dataDao.getDataByArticle(dataRequest.getArticle()));
        } else if (dataRequest.getRequestType() == 1) {
            dataResponce.setDatas(dataDao.getDataByAttribute(dataRequest.getAttribute()));
        }
        return dataResponce;
    }
}
