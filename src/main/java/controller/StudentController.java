package controller;

import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import service.StudentService;

import java.util.List;

/**
 * @author: Tologon Tekebaev
 */
@Controller
public class StudentController {
     private final StudentService studentService;

     @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public String getAllStudents(Model model ){
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return " ";
    }
    @PostMapping("/addStudent")
    public String addCompany(Model model){
         model.addAttribute("student", new Student());
         return "student/addStudent";
    }

    @GetMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.addStudent(student);
        return "redirect:getAllStudents";
    }
}
