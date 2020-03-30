package org.itstep.controller;

import lombok.extern.slf4j.Slf4j;
import org.itstep.model.Group;
import org.itstep.service.AcademyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping(path = "/groups")
public class GroupController {

    AcademyService academyService;

    @Autowired
    public GroupController(AcademyService academyService) {
        this.academyService = academyService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("groups", academyService.getGroups());
        return "groups/index";
    }

    @GetMapping(path = "/create")
    public String create(Model model) {
        model.addAttribute("group", new Group());
        return "groups/form";
    }

    @PostMapping(path = "/create")
    public String create(Group group) {
        log.debug("Create group: " + group.toString());
        academyService.saveGroup(group);
        return "redirect:/groups";
    }

    @GetMapping(path = "/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("group", academyService.getOneGroup(id));
        return "groups/form";
    }

    @PostMapping(path = "/edit/{id}")
    public String edit(@Validated @ModelAttribute Group group, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            academyService.updateGroup(group);
            log.debug("Edit group: " + group.toString());
            return "redirect:/groups";
        }else {
            log.error("Edit group: " + group.toString());
        }
        return "groups/form";
    }

    @GetMapping(path = "/delete/{id}")
    public String delete(@PathVariable int id){
        academyService.deleteGroup(id);
        log.debug("Delete group id: " + id);
        return "redirect:/groups";
    }

}
