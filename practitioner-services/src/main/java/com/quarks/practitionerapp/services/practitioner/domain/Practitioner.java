package com.quarks.practitionerapp.services.practitioner.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
public class Practitioner {

    @Id
    @GeneratedValue
    Long id;
    private String firstName;
    private String lastName;
    private String initials;
    private String prefix;


    @Relationship(type="PRACTICES")
    private List<Class<?>> endNodes;

    public Practitioner() {
    }

    public Practitioner(Long id, String firstName, String lastName, String initials, String prefix) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.initials = initials;
        this.prefix = prefix;
    }

    public Practitioner(String firstName, String lastName, String initials, String prefix, List<Class<?>> endNodes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.initials = initials;
        this.prefix = prefix;
        this.endNodes = endNodes;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        lastName = lastName;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public List<Class<?>> getEndNodes() {
        return endNodes;
    }

    public void setEndNodes(List<Class<?>> endNodes) {
        this.endNodes = endNodes;
    }
}
