package com.quarks.practitionerapp.services.skill.service;

import com.quarks.practitionerapp.services.skill.Repository.SkillRepository;
import com.quarks.practitionerapp.services.skill.domain.Skill;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SkillService {

    @Autowired
    SkillRepository skillRepository;

    public List<Skill> getAllSkills(String skillName) {
        if(StringUtils.isNotEmpty(skillName)){
            return Arrays.asList(this.skillRepository.findByName(skillName));
        }
        return (List<Skill>) this.skillRepository.findAll();
    }

    public Skill getSkillById(Long id) {
         return this.skillRepository.findById(id).get();
    }
}
