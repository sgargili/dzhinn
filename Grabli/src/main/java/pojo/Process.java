package pojo;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 11.11.2010
 * Time: 11:46:33
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Process {
    private Integer id;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String process;

    @Column(name = "process")
    @Basic
    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    private String status;

    @Column(name = "status")
    @Basic
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Process process1 = (Process) o;

        if (id != null ? !id.equals(process1.id) : process1.id != null) return false;
        if (process != null ? !process.equals(process1.process) : process1.process != null) return false;
        if (status != null ? !status.equals(process1.status) : process1.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (process != null ? process.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
