package com.example.thymeleaf.controller;

import com.example.thymeleaf.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("index");
    }

}
