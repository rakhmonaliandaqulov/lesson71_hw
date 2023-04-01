package com.example.repository;

import com.example.entity.BookEntity;
import com.example.entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {
    @Autowired
    private SessionFactory sessionFactory;
    public int save(BookEntity book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();

        session.close();
        sessionFactory.close();
        return 1;
    }
    public BookEntity getId(String id) {
        Session session = sessionFactory.openSession();
        BookEntity entity = session.find(BookEntity.class, id);
        session.close();
        return entity;
    }
    public List<BookEntity> bookList() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<BookEntity> bookDtoList = session.createQuery("from BookEntity", BookEntity.class).getResultList();
        transaction.commit();

        session.close();
        sessionFactory.close();
        return bookDtoList;
    }
    public int deleteBook(String id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<BookEntity> bookEntityList = session.createQuery("delete from  BookEntity where id = " + id + "", BookEntity.class).getResultList();
        transaction.commit();

        session.close();
        sessionFactory.close();
        return 1;
    }
    public int updateBook(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(id);
        transaction.commit();

        session.close();
        sessionFactory.close();
        return 1;
    }
}
