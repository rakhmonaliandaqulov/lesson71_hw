package com.example.controller;

import com.example.dto.StudentBookDto;
import com.example.enums.StudentBookStatus;
import com.example.service.StudentBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/student-book")
public class StudentBookController {
    @Autowired
    private StudentBookService studentBookService;
    private List<StudentBookDto> studentBookDTOList = new LinkedList<>();

    public StudentBookController() {
        StudentBookDto s1 = new StudentBookDto();
        s1.setId(1);
        s1.setReturnedDate(LocalDate.ofEpochDay(2023 - 13 - 03));
        s1.setCreatedDate(LocalDate.ofEpochDay(2020 - 01 - 01).atStartOfDay());
        s1.setStatus(StudentBookStatus.TAKEN);
        s1.setStudentId(1);
        s1.setBookId(2);
        studentBookService.takeBook(s1);
    }
    @PostMapping(value = "/create")
    public StudentBookDto create(@RequestBody StudentBookDto studentBookDto) {
        return studentBookService.takeBook(studentBookDto);
    }
    @GetMapping("/list")
    public List<StudentBookDto> getBookList() {
        return studentBookService.studentBookList();
    }
   /* @GetMapping(value = "/get/{id}")
    public StudentBookDto getById(@PathVariable("id") String id) {
        Optional<StudentBookDto> optional = studentBookService.studentBookList().stream().filter(bookdto -> bookdto.getId().equals(id)).findAny();
        return optional.orElse(null);
    }*/

    /*@PutMapping(value = "/update/{id}")
    public Boolean update(@PathVariable("id") String id, @RequestBody StudentBookDto studentBookDto) {
        for (StudentBookDto dto : studentBookDtoLinkedList) {
            if (dto.getId().equals(id)) {
                dto.setReturnedDate(studentBookDto.getReturnedDate());
                dto.setDuration(studentBookDto.getDuration());
                dto.setCreatedDate(studentBookDto.getCreatedDate());
                dto.setStatus(studentBookDto.getStatus());
                dto.setStudent_id(studentBookDto.getStudent_id());
                dto.setBook_id(studentBookDto.getBook_id());
                studentBookDtoLinkedList.add(dto);

//                bookList.add(dto);
                return true;
            }
        }
        return false;
    }*/

}
