package com.dbproject.cruddemo;

import com.dbproject.cruddemo.dao.StudendDAO;
import com.dbproject.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudendDAO studendDAO){
		return runner -> {
			//createStudent(studendDAO);
			createMultibleStudents(studendDAO);
			//readStudent(studendDAO);
			//queryForStudents(studendDAO);
			//queryForStudentsByLastName(studendDAO);
			//updateStudent(studendDAO);
			//deleteStudent(studendDAO);
			//deleteAllStudents(studendDAO);
		};

	}

	private void deleteAllStudents(StudendDAO studendDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studendDAO.deleteAll();
		System.out.println("Deleted " + numRowsDeleted + " students");
	}

	private void deleteStudent(StudendDAO studendDAO) {

		int studentId = 3;
		System.out.println("deleting student with id: " + studentId);
		studendDAO.delete(studentId);

	}

	private void updateStudent(StudendDAO studendDAO) {
		//retrieve student based on the id
		int studentId = 1;
		System.out.println("get student with id " + studentId);
		Student student = studendDAO.findById(studentId);

		//change the first name
		System.out.println("update student..");
		student.setFirstName("salah");
		//update student
		studendDAO.update(student);

		//display the updated student
		System.out.println("updated student: " + student);
	}

	private void queryForStudentsByLastName(StudendDAO studendDAO) {
		//get list of students
		List<Student> students= studendDAO.findByLastName("alhaj");

		//display list of students
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudendDAO studendDAO) {
		// get list of students
		List<Student> students = studendDAO.findAll();

		//display list of students
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudendDAO studendDAO) {
		// create student object
		System.out.println("Creating students...");
		Student tempStudent3 = new Student("moaz", "zakaria", "moaz@email.com");

		//save the student
		System.out.println("Saving student");
		studendDAO.save(tempStudent3);

		//display the id of the saved student
		System.out.println("Saved student. Generated Id:" + tempStudent3.getId());

		//retrieve student based on the id: primary key
		System.out.println("retrieving student");
		Student myStudent = studendDAO.findById(4);

		//display student
		System.out.println("the student is " + myStudent);

	}

	private void createMultibleStudents(StudendDAO studendDAO) {
		//create the student object
		System.out.println("Creating students...");
		Student tempStudent1 = new Student("amed", "mohamed", "ahmed@email.com");
		Student tempStudent2 = new Student("mostafa", "ahmed", "mostafa@email.com");


		// save the student object
		System.out.println("Saving student");
		studendDAO.save(tempStudent1);
		studendDAO.save(tempStudent2);

		//display the id of the saved student
		System.out.println("Saved student. Generated Id:" + tempStudent1.getId());
		System.out.println("Saved student. Generated Id:" + tempStudent2.getId());
	}
}
