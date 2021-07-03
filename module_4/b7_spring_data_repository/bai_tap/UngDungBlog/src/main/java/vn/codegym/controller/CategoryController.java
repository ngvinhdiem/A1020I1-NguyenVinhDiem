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
import vn.codegym.model.Category;
import vn.codegym.service.CategoryService;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = {"/category"})
    public String showList(Model model){
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "category/list";
    }

    @GetMapping("/category/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/category/create")
    public String saveCustomer(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message", "Create category success");
        categoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping("/category/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/edit";
    }

    @PostMapping("/category/update")
    public String update(Category category, RedirectAttributes redirectAttributes) {
        categoryService.update(category);
        redirectAttributes.addFlashAttribute("message", "Update category success");
        return "redirect:/category";
    }

    @GetMapping("/category/delete/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes){
        Category category = categoryService.findById(id);
        redirectAttributes.addFlashAttribute("message", "Delete category success");
        categoryService.remove(category);
        return "redirect:/category";
    }
}