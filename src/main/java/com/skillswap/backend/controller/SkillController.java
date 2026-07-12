//package com.skillswap.backend.controller;
//
//public class SkillController {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}

package com.skillswap.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.skillswap.backend.entity.Skill;
import com.skillswap.backend.service.SkillService;

@RestController
@RequestMapping("/skills")
public class SkillController {

    @Autowired
    private SkillService skillService;

    // Save Skill
    @PostMapping
    public Skill saveSkill(@RequestBody Skill skill) {
        return skillService.saveSkill(skill);
    }

    // Get All Skills
    @GetMapping
    public List<Skill> getAllSkills() {
        return skillService.getAllSkills();
    }

    // Get Skill By ID
    @GetMapping("/{id}")
    public Skill getSkillById(@PathVariable Long id) {
        return skillService.getSkillById(id);
    }

    // Update Skill
    @PutMapping("/{id}")
    public Skill updateSkill(@PathVariable Long id, @RequestBody Skill skill) {
        return skillService.updateSkill(id, skill);
    }

    // Delete Skill
    @DeleteMapping("/{id}")
    public String deleteSkill(@PathVariable Long id) {
        return skillService.deleteSkill(id);
    }
    
 // Search Skills By Name
    @GetMapping("/search/{skillName}")
    public List<Skill> searchSkillsByName(@PathVariable String skillName) {
        return skillService.searchSkillsByName(skillName);
    }
}
