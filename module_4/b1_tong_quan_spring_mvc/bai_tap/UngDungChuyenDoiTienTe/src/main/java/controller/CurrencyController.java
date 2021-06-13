
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CurrencyController {

    @GetMapping("/")
    public String viewIndexPage(){
        return "index";
    }

    @RequestMapping(value = "/currency", method = RequestMethod.POST)
    public String currencyConvert(@RequestParam("usd") double usd, Model model){
        double vnd = usd * 22000;
        model.addAttribute("usd", usd);
        model.addAttribute("result", usd + " USD = " +vnd + " VND");
        return "index";
    }
}