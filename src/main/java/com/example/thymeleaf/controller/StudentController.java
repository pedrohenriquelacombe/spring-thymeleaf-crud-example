package com.example.thymeleaf.controller;

import com.example.thymeleaf.dto.StudentRequestDTO;
import com.example.thymeleaf.dto.mapper.StudentMapper;
import com.example.thymeleaf.repository.StudentRepository;
import com.example.thymeleaf.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;
    private StudentRepository studentRepository;

    @GetMapping
    public ModelAndView students() {
        ModelAndView modelAndView = new ModelAndView("students");
        modelAndView.addObject("students", StudentMapper.toDTO(this.studentRepository.findAll()));
        return modelAndView;
    }

    @GetMapping("/new")
    public ModelAndView newStudent() {
        ModelAndView modelAndView = new ModelAndView("new-student");
        modelAndView.addObject("student", new StudentRequestDTO());
        return modelAndView;
    }

    @PostMapping("/new")
    public ModelAndView newStudent(StudentRequestDTO studentDTO) {
        this.studentService.save(StudentMapper.toEntity(studentDTO));
        return this.students();
    }

}
