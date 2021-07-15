package com.example.thymeleaf.controller;

import com.example.thymeleaf.dto.StudentRequestDTO;
import com.example.thymeleaf.dto.mapper.StudentMapper;
import com.example.thymeleaf.repository.StudentRepository;
import com.example.thymeleaf.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
    public ModelAndView newStudent(StudentRequestDTO studentRequestDTO) {
        return new ModelAndView("new-student")
                .addObject("student", studentRequestDTO);
    }

    @PostMapping("/new")
    public ModelAndView newStudent(@ModelAttribute("student") @Valid StudentRequestDTO studentRequestDTO, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return this.newStudent(studentRequestDTO);
        }
        this.studentService.save(StudentMapper.toEntity(studentRequestDTO));
        attributes.addFlashAttribute("message", "User registered successfully!");
        return new ModelAndView("redirect:/students");
    }

}
