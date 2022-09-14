package resourceAllocation;

public abstract class Resource {

    public enum ResourceType {
        MEM, //i.e. ec2 machine
        CPU, //i.e ec2
        SPACE //i.e s3


    }

    public Resource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public abstract boolean satisfy(Job job);


}
