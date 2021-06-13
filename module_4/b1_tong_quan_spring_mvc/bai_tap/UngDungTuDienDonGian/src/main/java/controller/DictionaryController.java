package controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
@Controller
public class DictionaryController {
    @GetMapping(value = "/")
    public String viewIndexPage(){
        return "index";
    }

    @RequestMapping(value = "/dictionary", method = RequestMethod.POST)
    public String dictionaryTranslate(@RequestParam("search") String search, ModelMap modelMap){
        Map<String, String> dictionaryList = new HashMap<>();
        dictionaryList.put("hello", "Xin Chao");
        dictionaryList.put("bye", "Tam Biet");
        dictionaryList.put("code", "Lap Trinh");

        String result = dictionaryList.get(search);
        if (result != null) {
            modelMap.addAttribute("result", result);
        } else {
            modelMap.addAttribute("result", "Khong tim thay");
        }
        return "index";
    }
}