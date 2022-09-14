package resourceAllocation;

import java.util.Date;

public class Job {
    int priority;
    long id;
    int requiredMem;
    int requiredCPU;
    String name;
    Date startTime;
    Date endTime;
    Double averageMemUsage;
    Double averageCPUUsage;

    public Job(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public long getId() {
        return id;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }



    public int getPriority() {
        return priority;
    }

    public long duration() {
        return Math.abs(endTime.getTime() - startTime.getTime());
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getRequiredMem() {
        return requiredMem;
    }

    public void setRequiredMem(int requiredMem) {
        this.requiredMem = requiredMem;
    }

    public int getRequiredCPU() {
        return requiredCPU;
    }

    public void setRequiredCPU(int requiredCPU) {
        this.requiredCPU = requiredCPU;
    }

    public Double getAverageMemUsage() {
        return averageMemUsage;
    }

    public void setAverageMemUsage(Double averageMemUsage) {
        this.averageMemUsage = averageMemUsage;
    }

    public Double getAverageCPUUsage() {
        return averageCPUUsage;
    }

    public void setAverageCPUUsage(Double averageCPUUsage) {
        this.averageCPUUsage = averageCPUUsage;
    }
}
