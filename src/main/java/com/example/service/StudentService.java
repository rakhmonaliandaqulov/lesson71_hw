package com.example.service;

import com.example.dto.StudentDto;
import com.example.entity.StudentEntity;
import com.example.exp.AppBadRequestException;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentDto crate(StudentDto dto) {
        StudentEntity entity = new StudentEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        if (dto.getName() == null || dto.getName().isBlank()) {
            throw new AppBadRequestException("Name qani?");
        }
        if (dto.getSurname() == null || dto.getSurname().isBlank()) {
            throw new AppBadRequestException("Surname qani?");
        }
        entity.setPsw(dto.getPsw());
        entity.setPhone(dto.getPhone());
        entity.setVisible(dto.getVisible());
        entity.setCreatedDate(dto.getCreatedDate().atStartOfDay());

        studentRepository.saveStudent(entity);
        dto.setId(entity.getId());
        return dto;
    }

    public List<StudentDto> studentLIst() {
         return studentRepository.studentList();
    }
}
