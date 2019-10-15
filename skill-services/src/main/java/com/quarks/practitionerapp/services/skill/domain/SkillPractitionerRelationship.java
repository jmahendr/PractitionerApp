package com.quarks.practitionerapp.services.skill.domain;

import org.neo4j.ogm.annotation.*;

import java.util.Collection;

@RelationshipEntity(type="PRACTICES")
public class SkillPractitionerRelationship {
    @Id @GeneratedValue
    Long id;
    @StartNode
    private Practitioner practitioner;
    @EndNode
    private Skill skill;
    private Collection<String> roles;

    public SkillPractitionerRelationship() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Practitioner getStartNode() {
        return practitioner;
    }

    public void setStartNode(Practitioner practitioner) {
        this.practitioner = practitioner;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Collection<String> getRoles() {
        return roles;
    }

    public void setRoles(Collection<String> roles) {
        this.roles = roles;
    }
}
