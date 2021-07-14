package com.example.thymeleaf.service;

import com.example.thymeleaf.entity.Student;
import com.example.thymeleaf.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;

    public Student findById(String id) {
        return this.studentRepository.findById(id).orElseThrow();
    }

    public Student save(Student student) {
        return this.studentRepository.save(student);
    }

    public Student update(Student student) {
        Student studentDatabase = this.findById(student.getId());
        BeanUtils.copyProperties(student, studentDatabase, "id", "createdAt", "updatedAt");
        return this.studentRepository.save(studentDatabase);
    }

    public void deleteById(String id) {
        this.studentRepository.delete(this.findById(id));
    }

}