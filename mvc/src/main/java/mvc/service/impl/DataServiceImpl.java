package mvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import mvc.dao.DataDao;
import mvc.dto.DataRequest;
import mvc.dto.DataResponce;
import mvc.service.DataService;

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
