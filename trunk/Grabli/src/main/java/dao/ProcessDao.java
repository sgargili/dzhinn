package dao;

import pojo.Process;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 11.11.2010
 * Time: 12:17:46
 * To change this template use File | Settings | File Templates.
 */
public interface ProcessDao {
    void saveProcess(pojo.Process process);

    void updateProcess(Process process);

    void updateProcessStatusById(String status, int id);

    Process getProcessById(int id);

    String getProcessStatusById(int id);
}
