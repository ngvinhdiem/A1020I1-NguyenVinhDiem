
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CondimentController {
    private final List<String> condimentList = new ArrayList<>();

    @GetMapping(value = {"/", "/list"})
    public String showList(Model model){
        model.addAttribute("condimentList", condimentList);
        return "list";
    }

    @GetMapping(value = "/create")
    public String showCreatePage(){
        return "create";
    }

    @PostMapping(value = "/create")
    public String createCondiment(@RequestParam("condiment") String condiment){
        condimentList.add(condiment);
        return "redirect:/list";
    }
}