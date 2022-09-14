package resourceAllocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobCoordinator {



    private Resource matchDistinctResourceForJob(Job job, List<Resource> resources, Map<Job,Resource> resourceToJob) {
        for (Resource resource : resources) {
            if (resource.satisfy(job) && !resourceToJob.containsValue(resource)) {
                return resource;
            }
        }
        System.out.println("No matching resource for Job "+job.getId());
        return null;
    }

    private Resource matchResourceForJob(Job job, List<Resource> resources) {
        for (Resource resource : resources) {
            if (resource.satisfy(job)) {
                return resource;
            }
        }
        System.out.println("No matching resource for Job "+job.getName());
        return null;
    }

    public Map<Job,Resource> concurrencyOfJobs(Map<Job, List<JobExecution>> jobExecutions, List<Resource> resources) {

        for (Job job: jobExecutions.keySet()) {
            job.averageMemUsage = jobExecutions.get(job).stream().mapToDouble(j -> j.memUsage).average().getAsDouble();
            job.averageCPUUsage = jobExecutions.get(job).stream().mapToDouble(j -> j.cpuUsage).average().getAsDouble();
        }
        Map<Job,Resource> resourceToJob = new HashMap<>();
        List<Job> orphanJobs = new ArrayList<>();
        for (Job job: jobExecutions.keySet()) {
            Resource assignedResource = matchDistinctResourceForJob(job,resources, resourceToJob);
            if (assignedResource != null) { // resource is allocated
                resourceToJob.put(job, assignedResource);
            } else {
                orphanJobs.add(job);
            }
        }

        if (resourceToJob.size() == 0) {
            System.out.println("Cannot allocate resource to any job");
            return null;
        }

        if ((orphanJobs.size()*100/resourceToJob.keySet().size())>10) {
            int reassignJob = 0;
            for (Job orphanJob: orphanJobs) {
                Resource assignedResource = matchResourceForJob(orphanJob,resources);
                resourceToJob.put(orphanJob, assignedResource);
                reassignJob++;
                if (((orphanJobs.size()-reassignJob)*100/resourceToJob.keySet().size())<10) {
                    break;
                }
            }
        }
        System.out.println("concurrency is ready");
        System.out.println("the following resources should be plan ahead:");
        resourceToJob.values().forEach(resource ->  System.out.println(resource.getName()));
        return resourceToJob;

    }

}
