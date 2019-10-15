package com.quarks.practitionerapp.services.skill.Repository;

import com.quarks.practitionerapp.services.skill.domain.Skill;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends Neo4jRepository<Skill,Long> {
    Skill findByName(String name);
}
