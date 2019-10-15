package com.quarks.practitionerapp.business.practitionerskill;

import com.quarks.practitionerapp.business.practitionerskill.client.PractitionerService;
import com.quarks.practitionerapp.business.practitionerskill.domain.Practitioner;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value="PractitionerSkill", description = "Business process service operations Practitioner and Skills", tags=("practitionerSkill"))
public class PractitionerSkillController {

    @Autowired
    private PractitionerService practitionerService;

    @Autowired
    private PractitionerSkillBusinessProcess practitionerSkillBusinessProcess;

    @RequestMapping(value="/practitioners",method=RequestMethod.GET)
    public List<Practitioner> findAll(@RequestParam(name="practitionerName", required = false)String practitionerName){
            return this.practitionerService.findAll(practitionerName);
    }

    @PostMapping
    public ResponseEntity<Practitioner> createOrUpdatePractitioner(Practitioner practitioner) throws Exception {
        Practitioner cruPractitioner = practitionerSkillBusinessProcess.createOrUpdatePractitioner(practitioner);
        return new ResponseEntity<Practitioner>(cruPractitioner, new HttpHeaders(), HttpStatus.OK);
    }


}
