package org.itstep.controller;

import lombok.extern.slf4j.Slf4j;
import org.itstep.dto.GroupDto;
import org.itstep.dto.StudentDto;
import org.itstep.service.AcademyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Slf4j

@Controller
@RequestMapping("/students")
public class StudentsController {

    final AcademyService academyService;

    public static final String BASE_URL = "/students";
    public static final String REDIRECT_INDEX = "redirect:" + BASE_URL;
    public static final String VIEW_PATH = "student";
    public static final String FORM_PATH = VIEW_PATH + "/form";
    public static final String INDEX_PATH = VIEW_PATH + "/index";

    @Autowired
    public StudentsController(AcademyService academyService) {

        this.academyService = academyService;
    }

    @ModelAttribute("groups")
    List<GroupDto> getGroups() {
        return academyService.findGroupsDto();
    }

    @GetMapping
    public String index(Model model,
                        @RequestParam(required = false) Integer page,
                        @RequestParam(required = false) Integer size,
                        @RequestParam(required = false) String firstName,
                        @RequestParam(required = false) String lastName) {
        log.info("index() + student");

        page = page == null ? 1 : page;
        size = size == null ? 5 : size;

        model.addAttribute("page", page);
        model.addAttribute("size", size);

        if ((firstName == null && lastName == null) || ("".equals(firstName) && "".equals(lastName))) {
            model.addAttribute("students", academyService.findStudentsDto(size));
        } else {
            if ("".equals(firstName) || "".equals(lastName)) {
                model.addAttribute("students", academyService.findStudentsByFirstOrLastName(firstName, lastName));
            } else {
                model.addAttribute("students", academyService.findStudentsByFirstAndLastName(firstName, lastName));
            }
        }

        return INDEX_PATH;
    }

    @GetMapping("/create")
    public String create(Model model) {
        log.info("create()");
        model.addAttribute("studentDto", new StudentDto());
        return FORM_PATH;
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute StudentDto studentDto,
                         BindingResult bindingResult) {
        log.debug("Create student: " + studentDto.toString());
        if (!bindingResult.hasErrors()) {
            academyService.save(studentDto);
            log.debug("Student saved");
            return REDIRECT_INDEX;
        }
        log.error(bindingResult.toString());
        return FORM_PATH;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id,
                         RedirectAttributes redirectAttributes) {
        if (academyService.delete(id)) {
            redirectAttributes.addAttribute("message", "OK");
        } else {
            redirectAttributes.addAttribute("message", "Error");
        }
        return REDIRECT_INDEX;
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        String url;
        try {
            StudentDto studentDto = academyService.getStudentDto(id);
            model.addAttribute("studentDto", studentDto);
            url = FORM_PATH;
        } catch (EmptyResultDataAccessException ex) {
            url = REDIRECT_INDEX;
        }
        return url;
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable int id,
                       @Validated @ModelAttribute StudentDto studentDto,
                       BindingResult bindingResult, @RequestParam("photo") MultipartFile f) throws IOException {
        log.debug("Create student: " + studentDto.toString());
        if (!bindingResult.hasErrors()) {
            academyService.update(studentDto);
            return REDIRECT_INDEX;
        }
        return FORM_PATH;
    }
}
