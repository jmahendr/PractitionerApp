package com.quarks.practitionerapp.services.practitioner.controller;

import com.quarks.practitionerapp.services.practitioner.repository.PractitionerRepository;
import com.quarks.practitionerapp.services.practitioner.domain.Practitioner;
import com.quarks.practitionerapp.services.practitioner.service.PractitionerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/practitioners")
@Api(value="practitioners",description = "Data Services for Practitioners", tags=("practitioners"))
public class PractitionerController {

    @Autowired
    private PractitionerService practitionerService;


    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value="Get All Practitioners", notes="Gets practitioner(s)", nickname="getPractitioners")
    public ResponseEntity<List<Practitioner>> getAllPractitioners(@RequestParam(name="practitionerName", required = false)String practitionerName){
        List<Practitioner> list = this.practitionerService.getAllPractitioners(practitionerName);
        return new ResponseEntity<List<Practitioner>>(list,new HttpHeaders(),HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    @ApiOperation(value="Get Practitioner", notes="Gets a Practitioner based on id", nickname = "getPractitioners")
    public ResponseEntity<Practitioner> getPractitionerById(@PathVariable("id")long id){
        return new ResponseEntity<Practitioner>(this.practitionerService.getPractitionerById(id),new HttpHeaders(),HttpStatus.OK);
    }
}
