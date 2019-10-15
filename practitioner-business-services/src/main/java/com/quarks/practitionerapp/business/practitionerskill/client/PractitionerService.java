package com.quarks.practitionerapp.business.practitionerskill.client;

import com.quarks.practitionerapp.business.practitionerskill.domain.Practitioner;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@FeignClient(value = "PRACTITIONERSERVICES")
public interface PractitionerService {

    @RequestMapping(value="/practitioners",method = RequestMethod.GET)
    List<Practitioner> getAllPractitioners(@RequestParam(name="practitionerName", required = false)String practitionerName);

    @RequestMapping(value="/practitionerById",method = RequestMethod.GET)
    Optional<Practitioner> getPractitionerById(Long practitionerId);

    Practitioner save(Practitioner practitioner);

    @RequestMapping(value="/createOrUpdatePractitioner",method = RequestMethod.POST)
    Practitioner createOrUpdatePractitioner(Practitioner practitioner);

}
