package com.example.miniproject;

import com.example.miniproject.controller.StudentController;
import com.example.miniproject.models.Student;
import com.example.miniproject.repo.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class MiniprojectApplicationTests {

	@Autowired
	private StudentController studentController;

	@MockBean
	private StudentRepository studentRepository;

	@Test
	public void getStudentsTest() {
		when(studentRepository.findAll()).thenReturn(Stream
				.of(new Student(1, "Naman", "DTU", "CS"),
				new Student(2, "Swastik", "DTU", "CS")).collect(Collectors.toList()));

		assertEquals(2, studentController.getStudents().size());
	}

	@Test
	public void addStudentTest() {
		Student student = new Student(1, "Naman", "DTU", "CS");
		when(studentRepository.save(student)).thenReturn(student);
		assertEquals(student, studentController.addStudent(student));
	}

	@Test
	public void updateStudentTest() {
		Student student = new Student(1, "Naman", "DTU", "CS");
		when(studentRepository.save(student)).thenReturn(student);
		assertEquals("Updated data of Naman", studentController.updateStudent(student));
	}
}
