package org.itstep.controller;

import org.itstep.data.Repository;
import org.itstep.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;

@RequestMapping("/students")
@Controller
public class StudentController {

    Repository<Student, Integer> repository;

    @Autowired
    public StudentController(Repository<Student, Integer> repository) {
        this.repository = repository;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("students", repository.findAll());
        return "students/index";
    }

    @GetMapping("/new")
    public String createStudent() {
        return "students/create";
    }

    @PostMapping("/new")
    public String createStudent(Student student, RedirectAttributes redirectAttributes) {
        String message = "";
        int id = 0;
        try {
            id = repository.save(student);
            if(id == -1) {
                throw new Exception("No group!");
            }
            message = "successfully saved";
        } catch(Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            message = "Error: " + ex.getLocalizedMessage();
        }
        redirectAttributes.addFlashAttribute("message", message);
        //System.out.println(student);
        return "redirect:/students";
    }

    @GetMapping("/info/{id}")
    public String info(@PathVariable int id, Model model) {
        model.addAttribute("student", repository.find(id));
        return "students/info";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        try {
            repository.delete(repository.find(id));
            redirectAttributes.addFlashAttribute("message", "Delete successfully");
        }catch (Throwable ex) {
            redirectAttributes.addFlashAttribute("message", "Error: " + ex.getLocalizedMessage());
        }
        return "redirect:/students";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("student", repository.find(id));
        return "students/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable int id, RedirectAttributes redirectAttributes, HttpServletRequest req) {
        String message = "";
        try {
            String fName = req.getParameter("firstName");
            String lName = req.getParameter("lastName");
            String group = req.getParameter("group");
            String age = req.getParameter("age");
            Student student = repository.find(id);
            if(!"".equals(fName)){
                student.setFirstName(fName);
            }
            if(!"".equals(lName)){
                student.setLastName(lName);
            }
            if(!"".equals(group)){
                student.setGroup(group);
            }
            if(!"".equals(age)){
                student.setAge(Integer.parseInt(age));
            }

            if(repository.update(student) == -1) {
                throw new Exception("No group!");
            }
            message = "Update successfully";
        }catch (Exception ex) {
           message = "Error: " + ex.getLocalizedMessage();
        }
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/students";
    }
}
