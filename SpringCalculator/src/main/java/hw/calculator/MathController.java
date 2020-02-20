package hw.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MathController {
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(Model model, @RequestParam(defaultValue = "1") double a,
                        @RequestParam(defaultValue = "1") double b,
                        @RequestParam(defaultValue = "+") String op) {
        double res;
        switch (op) {
            case "-":
                res = a - b;
                break;
            case "*":
                res = a * b;
                break;
            case "/":
                res = a / b;
                break;
            default:
                res = a + b;
                op = "+";
                break;
        }
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("op", op);
        model.addAttribute("res", res);
        return "index";
    }
}
