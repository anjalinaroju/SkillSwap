package com.skillswap.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillswap.backend.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    List<Skill> findBySkillName(String skillName);

}