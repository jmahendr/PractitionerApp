package com.quarks.practitionerapp.services.skill.controller;


import com.quarks.practitionerapp.services.skill.domain.Practitioner;
import com.quarks.practitionerapp.services.skill.domain.Skill;
import com.quarks.practitionerapp.services.skill.service.SkillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/skills")
@Api(value="skills",description = "Data Services for Skills", tags=("skills"))
public class SkillController {

    @Autowired
    SkillService skillService;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value="Get All Skills", notes="Gets skill(s)", nickname="getSkills")
    public ResponseEntity<List<Skill>> getAllSkills(@RequestParam(name="skillName", required = false)String skillName)
    {
        List<Skill> list = this.skillService.getAllSkills(skillName);
        return new ResponseEntity<List<Skill>>(list,new HttpHeaders(),HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    @ApiOperation(value="Get Skill", notes="Gets a Skill based on id", nickname = "getSkills")
    public ResponseEntity<Skill> getSkillById(@PathVariable("id")Long id){
        return new ResponseEntity<Skill>(this.skillService.getSkillById(id),new HttpHeaders(),HttpStatus.OK);
    }
}
