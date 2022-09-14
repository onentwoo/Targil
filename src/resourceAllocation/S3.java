package resourceAllocation;

public class S3 extends Resource {

    int diskSpace;

    public S3(int diskSpace, String name) {
        super(name);
        this.diskSpace = diskSpace;
    }

    @Override
    public boolean satisfy(Job job) {
        if (job.getAverageSpaceUsage() <= diskSpace) {
            return true;
        } else {
            return false;
        }

    }
}
