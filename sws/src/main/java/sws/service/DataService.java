package sws.service;

import sws.dto.DataRequest;
import sws.dto.DataResponce;

/**
 * User: Andrey Popov
 * Date: 14.12.10
 * Time: 16:45
 */
public interface DataService {
    DataResponce getDataResponce(DataRequest dataRequest);
}
