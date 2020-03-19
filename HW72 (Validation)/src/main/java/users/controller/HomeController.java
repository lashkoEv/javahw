package users.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import users.model.User;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/")
@Controller
public class HomeController {

    public static final Logger log = LoggerFactory.getLogger( HomeController.class);

    List <User> list = new ArrayList<>();

    @GetMapping
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping(path = "/")
    public String create(@Validated @ModelAttribute User register, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        String message = "";
        log.debug(register.toString());
        if (bindingResult.hasErrors()) {
            log.debug(bindingResult.toString());
            return "index";
        }
        try {
            list.add(register);
            message = "Добавление успешно!";
        } catch (Exception ex) {
            log.error(ex.getLocalizedMessage(), ex);
            message = "Ошибка: " + ex.getLocalizedMessage();
        }
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:";
    }
}
