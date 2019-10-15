package com.quarks.practitionerapp.business.practitionerskill;

import com.quarks.practitionerapp.business.practitionerskill.client.PractitionerService;
import com.quarks.practitionerapp.business.practitionerskill.client.SkillService;
import com.quarks.practitionerapp.business.practitionerskill.domain.Practitioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PractitionerSkillBusinessProcess {
    private PractitionerService practitionerService;
    private SkillService skillService;

    @Autowired
    public PractitionerSkillBusinessProcess(PractitionerService practitionerService, SkillService skillService) {
        this.practitionerService = practitionerService;
        this.skillService = skillService;
    }

    public List<Practitioner> getPractitionersWithSkills(String skillName) {
        return null;
    }

    public Practitioner createOrUpdatePractitioner(Practitioner practitioner) throws Exception {
        Optional<Practitioner> practitionerExists = this.practitionerService.findById(practitioner.getId());
        if (practitionerExists.isPresent()) {
            Practitioner updatePractitioner = new Practitioner();
            updatePractitioner.setFirstName(practitioner.getFirstName());
            updatePractitioner.setLastName(practitioner.getLastName());
            updatePractitioner.setInitials(practitioner.getInitials());
            updatePractitioner.setPrefix(practitioner.getPrefix());
            updatePractitioner = practitionerService.save(updatePractitioner);
            return updatePractitioner;
        } else {
            practitioner = practitionerService.save(practitioner);
            return practitioner;
        }
    }
}
