package org.itstep.controller;

import org.itstep.data.Repository;
import org.itstep.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RequestMapping("/groups")
@Controller
public class GroupController {
    Repository<Group, Integer> repository;

    @Autowired
    public GroupController(Repository<Group, Integer> repository) {
        this.repository = repository;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("groups", repository.findAll());
        return "groups/index";
    }

    @GetMapping("/new")
    public String createStudent() {
        return "groups/create";
    }

    @PostMapping("/new")
    public String createStudent(Group group, RedirectAttributes redirectAttributes) {
        String message = "";
        int id = 0;
        try {
            id =  repository.save(group);
            message = "successfully saved";
        } catch (Exception ex) {
            message = "some error";
        }
        redirectAttributes.addFlashAttribute("error", message);
        return "redirect:/groups/info/" + id;
    }

    @GetMapping("/info/{id}")
    public String info(@PathVariable int id, Model model) {
        model.addAttribute("groups", repository.find(id));
        return "groups/info";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model, RedirectAttributes rs) {
        String message = "";
        try{
            model.addAttribute("groups", repository.delete(repository.find(id)));
            message = "Delete successfully";
        }catch (Exception ex){
            message = "Error: " + ex.getLocalizedMessage();
        }
        rs.addFlashAttribute("message", message);
        return "redirect:/groups";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("group", repository.find(id));
        return "groups/update";
    }

    @PostMapping("/update/{id}")
    public String update(Group group, RedirectAttributes rs) {
        String message = "";
        try{
            repository.update(group);
            message = "Update successfully";
        }catch (Exception ex){
            message = "Error: " + ex.getLocalizedMessage();
        }
        rs.addFlashAttribute("message", message);
        return "redirect:/groups";
    }
}