package com.quarks.practitionerapp.services.skill.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
public class Skill {

    @Id
    @GeneratedValue
    Long id;
    private String domain;
    private String category;
    private String name;

    @Relationship(type="PRACTICES",direction = Relationship.INCOMING)
    private List<SkillPractitionerRelationship> skillPractitionerRelationships;

    public Skill() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSkillName() {
        return name;
    }

    public void setSkillName(String name) {
        this.name = name;
    }


    public List<SkillPractitionerRelationship> getSkillPractitionerRelationships() {
        return skillPractitionerRelationships;
    }

    public void setSkillRelationships(List<SkillPractitionerRelationship> skillPractitionerRelationships) {
        this.skillPractitionerRelationships = skillPractitionerRelationships;
    }

}
