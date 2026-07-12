//package com.skillswap.backend.service;
//
//public class SkillService {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}

package com.skillswap.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillswap.backend.entity.Skill;
import com.skillswap.backend.repository.SkillRepository;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    // Save Skill
    public Skill saveSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    // Get All Skills
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    // Get Skill By ID
    public Skill getSkillById(Long id) {
        return skillRepository.findById(id).orElse(null);
    }

    // Update Skill
    
    public Skill updateSkill(Long id, Skill updatedSkill) {

        Skill skill = skillRepository.findById(id).orElse(null);

        if (skill != null) {
            skill.setSkillName(updatedSkill.getSkillName());
            skill.setCategory(updatedSkill.getCategory());
            skill.setLevel(updatedSkill.getLevel());

            return skillRepository.save(skill);
        }

        return null;
    }

    // Delete Skill
    public String deleteSkill(Long id) {

        if (skillRepository.existsById(id)) {
            skillRepository.deleteById(id);
            return "Skill deleted successfully!";
        }

        return "Skill not found!";
    }
 // Search Skills By Skill Name
    public List<Skill> searchSkillsByName(String skillName) {
        return skillRepository.findBySkillName(skillName);
    }
}