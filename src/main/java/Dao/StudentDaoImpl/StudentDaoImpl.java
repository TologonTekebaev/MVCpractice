package Dao.StudentDaoImpl;

import Dao.StudentDao;
import entity.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;

/**
 * @author: Tologon Tekebaev
 */
@Repository
@Transactional

public class StudentDaoImpl implements StudentDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = entityManager.createQuery("select s from Student s", Student.class)
                .getResultList();
        Comparator<Student> comparator = ((o1, o2) -> (int) (o1.getId() - o2.getId()));
        students.sort(comparator);
        return students;
    }
    @Override
    public void addStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    public void deleteStudent(Student student) {
        entityManager.remove(student);
    }
}
