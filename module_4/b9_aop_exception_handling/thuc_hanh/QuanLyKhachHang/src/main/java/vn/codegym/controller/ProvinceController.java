package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Province;
import vn.codegym.service.ProvinceService;

import java.util.List;

@Controller
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @GetMapping(value = {"/province"})
    public String showList(Model model){
        List<Province> provinceList = provinceService.findAll();
        model.addAttribute("provinceList", provinceList);
        return "province/list";
    }

    @GetMapping("/province/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("province/create");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }

    @PostMapping("/province/create")
    public String saveCustomer(@ModelAttribute("province") Province province, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message", "Create province success");
        provinceService.save(province);
        return "redirect:/province";
    }

    @GetMapping("/province/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("province", provinceService.findById(id));
        return "province/edit";
    }

    @PostMapping("/province/update")
    public String update(Province province, RedirectAttributes redirectAttributes) {
        provinceService.update(province);
        redirectAttributes.addFlashAttribute("message", "Update province success");
        return "redirect:/province";
    }

    @GetMapping("/province/delete/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes){
        Province province = provinceService.findById(id);
        redirectAttributes.addFlashAttribute("message", "Delete province success");
        provinceService.remove(province);
        return "redirect:/province";
    }
}