package resourceAllocation;

public class EC2 extends Resource{

    int maxMem;
    int numberOfCPU;
    int maxStorage;

    public EC2(int maxMem, int numberOfCPU, String name) {
        super(name);
        this.maxMem = maxMem;
        this.numberOfCPU = numberOfCPU;
    }

    public int getMaxMem() {
        return maxMem;
    }

    public void setMaxMem(int maxMem) {
        this.maxMem = maxMem;
    }

    public int getNumberOfCPU() {
        return numberOfCPU;
    }

    public void setNumberOfCPU(int numberOfCPU) {
        this.numberOfCPU = numberOfCPU;
    }



    @Override
    public boolean satisfy(Job job) {
        if (job.getAverageCPUUsage() <= numberOfCPU && job.averageMemUsage <= maxMem) {
            return true;
        } else {
            return false;
        }
    }
}
