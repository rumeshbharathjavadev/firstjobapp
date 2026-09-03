package com.embarkx.firstjobapp.company;

import com.embarkx.firstjobapp.job.Job;
import jakarta.persistence.OneToMany;


import java.util.List;

public class Company {


    private Long id;
    private String name;
    private String description;

    @OneToMany
    private List<Job> job;




}
