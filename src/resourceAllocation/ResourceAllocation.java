package resourceAllocation;

import java.util.*;

    /*
  Assume a system in which many jobs are run, each job has {priority, start time, end time, memory requested, and other proprietary fields}.
A job needs memory & compute resources to be available in the system in order to run.
In case there are none available, Job will fail.


Task:
Given log of all job executions from the past year, including size of memory used.
Study the concurrency of Jobs, in order to optimize pre-allocated resources / budget
Implement the logical component for calculating concurrency of Jobs, and resources used. And offer ways to deduce how many resources should be pre-allocated in order to sustain proper functioning of the system.
Note: aiming for 100% availability may be possible yet costly, so please plan for a certain ratio of failure ~10%.
     */



public class ResourceAllocation {


    public static void main(String[] args) {

        Map<Job, List<JobExecution>> log = new HashMap<>();
        Job job1 = new Job(1L);
        job1.setRequiredCPU(1); //GPU
        job1.setRequiredMem(40); //MB
        Job job2 = new Job(2L);
        JobExecution job1Exec1 = new JobExecution();
        job1Exec1.setJob(job1);
        job1Exec1.setCpuUsage(2);
        job1Exec1.setMemUsage(33);
        job1Exec1.setExecutionDate(new Date());
        JobExecution job1Exec2 = new JobExecution();
        job1Exec2.setJob(job1);
        job1Exec2.setCpuUsage(2);
        job1Exec2.setMemUsage(28);
        job1Exec2.setExecutionDate(new Date());
        List<JobExecution> executions = new ArrayList<>();
        executions.add(job1Exec1);
        executions.add(job1Exec2);
        log.put(job1,executions);
       // log.put(job2,null);
        JobCoordinator coordinator = new JobCoordinator();
        List<Resource> resources = new ArrayList<>();
        Resource EC2_AMI123 = new EC2(100, 2, "AMI123");
        Resource EC2_AMI456 = new EC2(50, 1 , "AMI456");
        resources.add(EC2_AMI123);
        resources.add(EC2_AMI456);
        coordinator.concurrencyOfJobs(log, resources);
    }





         /*
            1. match best resources for job
            2. match for time frame
            3. search next job and see if no collision in resources put in concurrences
            4. if collision put all collision machine in counter and check if availability is less than 10% - check what is the collision and decide if to postpone or apply another resource
            5. if postpone put next, if not prepare resource in advance
            6.
         */


    /*
        1. if using the same resource order by duration - put shorter duration first
        2. maybe job use more than one resource ?



     */


        //concurrency map of jobs
        //resource type:
        //S3, EC2

    }

