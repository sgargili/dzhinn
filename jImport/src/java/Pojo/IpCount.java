/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

/**
 *
 * @author APopov
 */
public class IpCount {

    private int countAll, count;

    public IpCount(int countAll, int count) {
        this.countAll = countAll;
        this.count = count;
    }

    public IpCount() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCountAll() {
        return countAll;
    }

    public void setCountAll(int countAll) {
        this.countAll = countAll;
    }
}
