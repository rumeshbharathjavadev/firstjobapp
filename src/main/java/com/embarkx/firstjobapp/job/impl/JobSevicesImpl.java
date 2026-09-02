package com.embarkx.firstjobapp.job.impl;

import com.embarkx.firstjobapp.job.Job;
import com.embarkx.firstjobapp.job.JobSevices;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
public class JobSevicesImpl implements JobSevices {


    private List<Job> jobs= new ArrayList<>();
    private Long nextId=1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public String createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
        return "Job Added Successfully";
    }

    @Override
    public Job getJobById(Long id) {

        for (Job job:jobs){

            if (job.getId().equals(id)){
                return job;
            }
        }
return  null;
    }

    @Override
    public boolean deleteById(Long id) {

        Iterator<Job> iterator= jobs.iterator();

        while(iterator.hasNext()){

            Job job=iterator.next();

            if (job.getId().equals(id)){
                iterator.remove();
                return true;
            }
        }


        return false;
    }

    @Override
    public boolean updateJob(Long id, Job updatejob) {

        for (Job job:jobs){

           if(job.getId().equals(id)){
               job.setTitle(updatejob.getTitle());
               job.setDescription(updatejob.getDescription());
               job.setMinSalary(updatejob.getMinSalary());
               job.setMaxSalary(updatejob.getMaxSalary());
               job.setLocation(updatejob.getLocation());
               return true;
           }
        }
        return false;
    }
}
