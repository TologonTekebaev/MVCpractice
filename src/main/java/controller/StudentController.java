package controller;

import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import service.StudentService;

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
    @PostMapping("/saveStudent")
    public String addCompany(Model model){
         model.addAttribute("student", new Student());
         return "student/addStudent";
    }
    
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.addStudent(student);
        return "redirect:ge";
    }
}
