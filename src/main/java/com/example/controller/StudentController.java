package com.example.controller;

import com.example.dto.StudentDto;
import com.example.exp.AppBadRequestException;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    private List<StudentDto> studentList = new LinkedList<>();

    public StudentController() {
        StudentDto s1 = new StudentDto();
        s1.setId(1);
        s1.setName("Alish");
        s1.setSurname("Aliyev");

        studentList.add(s1);
    }

    @GetMapping("/list")
    public List<StudentDto> getAll() {
        return studentService.studentLIst();
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        Optional<StudentDto> optional = studentService.studentLIst().stream().filter(studentDTO -> studentDTO.getId().equals(id)).findAny();
        if (optional.isEmpty()) {
            return ResponseEntity.badRequest().body("Student Not Found");
        }
        return ResponseEntity.ok(optional.get());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody StudentDto studentDTO) {
//         studentService.crate(studentDTO);
//        return new ResponseEntity<>("test message", HttpStatus.OK);
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

//        StudentDTO response = studentService.crate(studentDTO);
//        return new ResponseEntity<>(response, HttpStatus.OK);

//        StudentDTO response = studentService.crate(studentDTO);
//        return ResponseEntity.ok(response);

//        StudentDTO response = studentService.crate(studentDTO);
//        return ResponseEntity.ok().body(response);

//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        return ResponseEntity.badRequest().build();
        try {
            StudentDto response = studentService.crate(studentDTO);
            return ResponseEntity.ok(response);
        } catch (AppBadRequestException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /*@PostMapping(value = "/create/all")
    public Boolean createAll(@RequestBody List<StudentDTO> list) {
        for (StudentDTO dto : list) {
            dto.setId(1);
            studentList.add(dto);
        }
        return true;
    }*/

   /* @PutMapping(value = "/update/{id}")
    public Boolean update(@PathVariable("id") Integer id, @RequestBody StudentDTO studentDTO) {
        for (StudentDTO dto : studentList) {
            if (dto.getId().equals(id)) {
                dto.setName(studentDTO.getName());
                dto.setSurname(studentDTO.getSurname());
                return true;
            }
        }
        return false;
    }*/

    @DeleteMapping(value = "/delete/{id}")
    public Boolean delete(@PathVariable("id") String id) {
        return studentService.studentLIst().removeIf(studentDTO -> studentDTO.getId().equals(id));
    }
}
