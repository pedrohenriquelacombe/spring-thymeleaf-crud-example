package com.example.thymeleaf.controller;

import com.example.thymeleaf.dto.CreateStudentDTO;
import com.example.thymeleaf.dto.StudentResponseDTO;
import com.example.thymeleaf.dto.UpdateStudentDTO;
import com.example.thymeleaf.dto.mapper.StudentMapper;
import com.example.thymeleaf.repository.StudentRepository;
import com.example.thymeleaf.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;
    private StudentRepository studentRepository;

    @GetMapping
    public ModelAndView showStudents() {
        List<StudentResponseDTO> students = StudentMapper.toDTO(this.studentRepository.findAll());
        return new ModelAndView("students").addObject("students", students);
    }

    @GetMapping("/new")
    public ModelAndView showCreateForm() {
        return new ModelAndView("new-student").addObject("student", new CreateStudentDTO());
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("student") @Valid CreateStudentDTO studentDTO, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "new-student";
        }

        this.studentService.save(StudentMapper.toEntity(studentDTO));
        attributes.addFlashAttribute("message", "User registered successfully!");
        return "redirect:/students";
    }

    @GetMapping("/{id}")
    public ModelAndView showUpdateForm(@PathVariable String id) {
        StudentResponseDTO responseDTO = StudentMapper.toDTO(this.studentService.findById(id));
        return new ModelAndView("edit-student").addObject("student", responseDTO);
    }

    @PostMapping("/{id}")
    public String update(@PathVariable String id, @ModelAttribute("student") @Valid UpdateStudentDTO studentDTO, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            studentDTO.setId(id);
            return "edit-student";
        }

        this.studentService.update(id, StudentMapper.toEntity(studentDTO));
        attributes.addFlashAttribute("message", "User updated successfully!");
        return "redirect:/students";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable String id, RedirectAttributes attributes) {
        this.studentService.deleteById(id);
        attributes.addFlashAttribute("message", "User deleted successfully!");
        return "redirect:/students";
    }

}
