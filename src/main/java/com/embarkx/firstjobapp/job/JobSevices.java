package com.embarkx.firstjobapp.job;

import java.util.List;

public interface JobSevices {


    List<Job> findAll();
    String createJob (Job job);
    Job getJobById(Long id);

    boolean deleteById(Long id);

    boolean updateJob(Long id, Job job);
}
