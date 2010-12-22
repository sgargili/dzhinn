package mvc.service;

import mvc.dto.DataRequest;
import mvc.dto.DataResponce;

/**
 * User: Andrey Popov
 * Date: 14.12.10
 * Time: 16:45
 */
public interface DataService {
    DataResponce getDataResponce(DataRequest dataRequest);
}
