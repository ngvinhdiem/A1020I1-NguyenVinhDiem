
package controller;


import model.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping(value = {"/", "calculator"})
    public String showCaculator(){
        return "index";
    }

    @PostMapping(value = "calculator")
    public String caculator(@RequestParam double firstNum, @RequestParam double secondNum,
                            @RequestParam String operator, Model model){
        Calculator calculator = new Calculator(firstNum, secondNum, operator);
        double result = calculator.result();
        model.addAttribute("result", result);
        return "index";
    }
}