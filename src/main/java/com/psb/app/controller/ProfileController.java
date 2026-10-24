package com.psb.app.controller;

import com.psb.app.entity.Person;
import com.psb.app.entity.User;
import com.psb.app.repository.PersonRepository;
import com.psb.app.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    private final UserRepository userRepository;
    private final PersonRepository personRepository;

    public ProfileController(UserRepository userRepository, PersonRepository personRepository) {
        this.userRepository = userRepository;
        this.personRepository = personRepository;
    }

    @GetMapping("/profile")
    public String profile(Model model, Principal principal) {
        User user = userRepository.findByUsername(principal.getName())
            .orElseThrow(() -> new RuntimeException("User not found"));

        Person person = personRepository.findByUser(user).orElse(null);

        model.addAttribute("user", user);
        model.addAttribute("person", person);
        return "profile";
    }
}
