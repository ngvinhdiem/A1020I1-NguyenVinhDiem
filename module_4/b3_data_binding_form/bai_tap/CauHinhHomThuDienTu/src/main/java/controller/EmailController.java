package controller;

import model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailController {

    @RequestMapping(value = {"/", "/formSettingEmail"}, method = RequestMethod.GET)
    public String settingEmailForm(Model model){
        model.addAttribute("email", new Email());

        List<String> listLanguage = new ArrayList<>();
        listLanguage.add("English");
        listLanguage.add("Vietnamese");
        listLanguage.add("Japanese");
        listLanguage.add("Chinese");
        model.addAttribute("listLanguage", listLanguage);

        List<Integer> listPageSize = new ArrayList<>();
        listPageSize.add(5);
        listPageSize.add(10);
        listPageSize.add(15);
        listPageSize.add(25);
        listPageSize.add(50);
        listPageSize.add(100);
        model.addAttribute("listPageSize", listPageSize);

        return "emailSetting";
    }

    @PostMapping(value = "/settingEmail")
    public ModelAndView settingEmail(@ModelAttribute("email") Email email){
        return new ModelAndView("emailSettingResult", "email", email);
    }
}