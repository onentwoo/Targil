package resourceAllocation;

import java.util.Date;

public class JobExecution {

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public int getMemUsage() {
        return memUsage;
    }

    public void setMemUsage(int memUsage) {
        this.memUsage = memUsage;
    }

    public int getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(int cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public Date getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    Job job;
    int memUsage;
    int cpuUsage;
    Date executionDate;


}
