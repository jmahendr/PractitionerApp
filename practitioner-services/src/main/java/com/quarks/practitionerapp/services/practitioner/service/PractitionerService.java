package com.quarks.practitionerapp.services.practitioner.service;

import com.quarks.practitionerapp.services.practitioner.domain.Practitioner;
import com.quarks.practitionerapp.services.practitioner.repository.PractitionerRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class PractitionerService {

    @Autowired
    private PractitionerRepository practitionerRepository;

    public List<Practitioner> getAllPractitioners(String practitionerName) {
        if(StringUtils.isNotEmpty(practitionerName)){
            return Arrays.asList(this.practitionerRepository.findByName(practitionerName));
        }
        return (List<Practitioner>) this.practitionerRepository.findAll();
    }

    public Practitioner getPractitionerById(Long id) {
        return this.practitionerRepository.findById(id).get();
    }
}
