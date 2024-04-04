package energy_glow.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request){
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        System.out.printf("Hello, dear %s %s%n", surname, name);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname", required = false) String surname,
                              Model model){
        //System.out.printf("Hello, dear %s %s%n", surname, name);
        model.addAttribute("message", "Hello, " + name + " " + surname);
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") Integer num1, @RequestParam("b") Integer num2,
                            @RequestParam("action") String action, Model model){
        model.addAttribute("a", num1);
        model.addAttribute("b", num2);
        double buffer = 0;
        switch(action){
            case "addition": buffer = num1 + num2; action = "+";
            break;
            case "subtraction": buffer = num1 - num2; action = "-";
            break;
            case "multiplication": buffer = num1 * num2; action = "*";
            break;
            case "division": buffer = (double) num1 / num2; action = "/";
            break;
            default:
                System.out.println("Wrong operation!");
                break;
        }
        model.addAttribute("action", action);
        model.addAttribute("answer", buffer);
        return "first/calculator";
    }
}