package com.quarks.practitionerapp.services.practitioner.repository;

import com.quarks.practitionerapp.services.practitioner.domain.Practitioner;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PractitionerRepository extends Neo4jRepository<Practitioner, Long> {
    Practitioner findByName(String practitionerName);
}
