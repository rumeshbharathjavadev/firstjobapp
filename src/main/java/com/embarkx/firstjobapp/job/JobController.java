package com.embarkx.firstjobapp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {


    private JobSevices jobSevices;

    public JobController(JobSevices jobSevices) {
        this.jobSevices = jobSevices;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        List<Job>j= jobSevices.findAll();
        return new ResponseEntity<>(j,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job ){
       jobSevices.createJob(job);
        return new ResponseEntity<>("Job Created Successfully",HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job= jobSevices.getJobById(id);
        if (job !=null){
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(job, HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean delete=jobSevices.deleteById(id);

        if (delete)
            return new ResponseEntity<>("Job deleted Successfully",HttpStatus.OK);

        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }




    //@RequestMapping(value = "/jobs/{id}" , method = RequestMethod.PUT)

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id,@RequestBody Job job){

        boolean update=jobSevices.updateJob(id,job);

        if (update)
            return new ResponseEntity<>("Job Updated Successfully",HttpStatus.OK);

        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);

}}
