package Dao;

import entity.Student;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import java.util.List;

public interface StudentDao {
    List<Student> getAllStudents();

    void addStudent(Student student);

    Student getStudentById(Long id);

    void updateStudent(Student student);

    void deleteStudent(Student student);

}
