package com.web_project.school.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public String home (Model model){
        model.addAttribute("name", "Лев");
        return "homePage";
    }
    @PostMapping("calculate")
    public String calculate(
            @RequestParam("operand1") double operand1,
            @RequestParam("operand2") double operand2,
            @RequestParam("operator") String operator,
            Model model){
        double result = switch (operator){
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "/" -> operand1 / operand2;
            case "*" -> operand1 * operand2;
            default -> 0.0;
        };
        model.addAttribute("result", result);
        return "result";
    }

    @GetMapping("calculator")
    public String calculator (Model model){
        return "calculator";
    }

    @GetMapping("convert")
    public String convert(
            @RequestParam("from") String from,
            @RequestParam("to") String to,
            @RequestParam("amount") double amount,
            Model model){

        double result = switch (to){
            case "RUB" -> switch (from){
                case "RUB" -> amount * 1;
                case "USD" -> amount / 92.8;
                case "EUR" -> amount / 103.22;
                default -> 0.0;
            };
            case "USD" -> switch (from){
                case "RUB" -> amount * 92.8;
                case "USD" -> amount * 1;
                case "EUR" -> amount * 1.11;
                default -> 0.0;
            };
            case "EUR"-> switch (from){
                case "RUB" -> amount * 103.15;
                case "USD" -> amount * 0.9;
                case "EUR" -> amount * 1;
                default -> 0.0;
            };
            default -> 0.0;
        };
        model.addAttribute("result", result);
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        model.addAttribute("amount", amount);

        return "converterResult";
    }

    @GetMapping("converter")
    public String converter (Model model){
        return "converter";
    }
}
