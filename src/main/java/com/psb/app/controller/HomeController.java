package com.psb.app.controller;

import com.psb.app.dto.RegistrationRequest;
import com.psb.app.entity.Company;
import com.psb.app.entity.Department;
import com.psb.app.entity.Person;
import com.psb.app.entity.User;
import com.psb.app.repository.CompanyRepository;
import com.psb.app.repository.DepartmentRepository;
import com.psb.app.repository.PersonRepository;
import com.psb.app.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.time.LocalDate;

@Controller
public class HomeController {

    private final UserRepository userRepository;
    private final PersonRepository personRepository;
    private final CompanyRepository companyRepository;
    private final DepartmentRepository departmentRepository;
    private final PasswordEncoder passwordEncoder;

    public HomeController(UserRepository userRepository,
                          PersonRepository personRepository,
                          CompanyRepository companyRepository,
                          DepartmentRepository departmentRepository,
                          PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.personRepository = personRepository;
        this.companyRepository = companyRepository;
        this.departmentRepository = departmentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registrationRequest", new RegistrationRequest());
        return "register";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        return "dashboard";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("registrationRequest") RegistrationRequest request,
                           RedirectAttributes redirectAttributes) {

        if (userRepository.findByUsername(request.getUsername()).isPresent() ||
            userRepository.findByEmail(request.getEmail()).isPresent()) {
            redirectAttributes.addFlashAttribute("error", "Username or email already exists");
            return "redirect:/register";
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setFullName(request.getFullName());
        user.setRole("USER");
        user.setEnabled(true);
        userRepository.save(user);

        Department department = departmentRepository.findByDepartmentName(request.getDepartmentName())
            .orElseGet(() -> departmentRepository.save(new Department(request.getDepartmentName(), "Auto-created department")));

        Company company = companyRepository.findByCompanyName(request.getCompanyName())
            .orElseGet(() -> companyRepository.save(new Company(
                request.getCompanyName(),
                request.getCompanyAddress(),
                request.getCity(),
                request.getState(),
                request.getCountry(),
                request.getCompanyPhone(),
                request.getCompanyEmail(),
                request.getCompanyWebsite(),
                request.getRegistrationNumber(),
                request.getCompanyType(),
                request.getCompanyDescription())));

        Person person = new Person();
        person.setUser(user);
        person.setFullName(request.getFullName());
        person.setDateOfBirth(LocalDate.parse(request.getDateOfBirth()));
        person.setGender(request.getGender());
        person.setAddress(request.getAddress());
        person.setCity(request.getCity());
        person.setState(request.getState());
        person.setCountry(request.getCountry());
        person.setPhone(request.getPhone());
        person.setEmail(request.getEmail());
        person.setNationality(request.getNationality());
        person.setMaritalStatus(request.getMaritalStatus());
        person.setDepartment(department);
        person.setCompany(company);

        personRepository.save(person);

        redirectAttributes.addFlashAttribute("message", "Registration successful. Please login.");
        return "redirect:/login";
    }
}
