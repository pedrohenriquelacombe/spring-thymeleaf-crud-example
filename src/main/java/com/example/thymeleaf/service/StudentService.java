package com.example.thymeleaf.service;

import com.example.thymeleaf.entity.Student;
import com.example.thymeleaf.repository.AddressRepository;
import com.example.thymeleaf.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {

    private AddressRepository addressRepository;
    private StudentRepository studentRepository;

    public Student findById(String id) {
        return this.studentRepository.findById(id).orElseThrow();
    }

    public Student save(Student student) {
        this.studentRepository.save(student);
        this.addressRepository.save(student.getAddress());
        return student;
    }

    public Student update(String id, Student student) {
        Student studentDatabase = this.findById(id);
        BeanUtils.copyProperties(student, studentDatabase, "id", "createdAt", "updatedAt", "address");
        BeanUtils.copyProperties(student.getAddress(), studentDatabase.getAddress(), "id", "createdAt", "updatedAt", "student");
        return this.studentRepository.save(studentDatabase);
    }

    public void deleteById(String id) {
        this.studentRepository.delete(this.findById(id));
    }

}
