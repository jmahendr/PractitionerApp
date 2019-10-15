package com.quarks.practitionerapp.business.practitionerskill.client;


import com.quarks.practitionerapp.business.practitionerskill.domain.Skill;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@FeignClient(value="SKILLSERVICES")
public interface SkillService {
    @RequestMapping(value = "/skills",method = RequestMethod.GET)
    List<Skill> getAllSkills(@RequestParam(name="skillName", required = false)String skillName);

    @RequestMapping(value="/skillById",method = RequestMethod.GET)
    Optional<Skill> getSkillById(Long skillId);

    Skill save(Skill skill);

    @RequestMapping(value="/createOrUpdateSkill",method = RequestMethod.POST)
    Skill createOrUpdateSkill(Skill skill);

}
