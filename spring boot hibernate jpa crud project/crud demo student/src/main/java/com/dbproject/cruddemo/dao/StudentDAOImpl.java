package com.dbproject.cruddemo.dao;

import com.dbproject.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl  implements StudendDAO{
    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student order by lastName desc", Student.class);

        //return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student where lastName = :lastName", Student.class);

        //set query parameters
        theQuery.setParameter("lastName", lastName);

        //return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {

        //retrieve the student
        Student student = entityManager.find(Student.class, id);

        //delete the student
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {

        int numRowsDeleted = entityManager.createQuery("delete from Student").executeUpdate();

        return numRowsDeleted;
    }
}
