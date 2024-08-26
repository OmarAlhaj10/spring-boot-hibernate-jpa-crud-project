package com.dbproject.cruddemo.dao;

import com.dbproject.cruddemo.entity.Student;

import java.util.List;

public interface StudendDAO {
    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void delete(Integer id);

    int deleteAll();
}
