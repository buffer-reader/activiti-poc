package com.activitipoc.controllers;


import com.activitipoc.entities.Applicant;
import com.activitipoc.repositories.ApplicantRepository;
import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
public class VhireController {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private ApplicantRepository applicantRepository;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/start-vhire", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void startHireProcess(@RequestBody Map<String, String> data) {

        Applicant applicant = new Applicant(data.get("applicantName"), data.get("emailId"), data.get("phoneNumber"));
        applicantRepository.save(applicant);

        Map<String, Object> vars = Collections.<String, Object>singletonMap("applicant", applicant);
        runtimeService.startProcessInstanceByKey("vhire", vars);
    }

}
