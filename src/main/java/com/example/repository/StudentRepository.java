package com.example.repository;

import com.example.entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public StudentEntity saveStudent(StudentEntity student) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);

        transaction.commit();
        session.close();
        return student;
    }

    public StudentEntity get(Integer id) {
        Session session = sessionFactory.openSession();
        StudentEntity entity =  session.find(StudentEntity.class, id);
        session.close();
        return entity;
    }


   /* public List<StudentDTO> studentList() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<StudentDTO> studentDTOList = session.createQuery("from StudentDTO", StudentDTO.class).getResultList();
        transaction.commit();

        session.close();
        sessionFactory.close();
        return studentDTOList;
    }*/
}
