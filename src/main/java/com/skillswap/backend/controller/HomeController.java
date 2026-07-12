//package com.skillswap.backend.controller;
//
//public class HomeController {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}

package com.skillswap.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to SkillSwap Backend!";
    }
}