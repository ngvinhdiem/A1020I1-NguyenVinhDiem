package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Customer;
import vn.codegym.service.CustomerService;
import vn.codegym.service.CustomerServiceImpl;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = {"/", "/customer"})
    public String showList(Model model){
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customerList", customerList);
        return "list";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message", "Create student success");
        customerService.save(customer);
        return "redirect:/";
    }

    @GetMapping("/customer/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.update(customer);
        redirectAttributes.addFlashAttribute("message", "Update customer success");
        return "redirect:/";
    }

    @GetMapping("/customer/delete/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes){
        Customer customer = customerService.findById(id);
        if (customer != null){
            redirectAttributes.addFlashAttribute("message", "Delete customer success");
            customerService.remove(customer);
        } else {
            redirectAttributes.addFlashAttribute("message", "Customer not found");
        }
        return "redirect:/";
    }

    @GetMapping("/search")
    public ModelAndView searchCustomer(@RequestParam("kq") String kq){
        return new ModelAndView("list", "customerList", customerService.searchByFirstname(kq));
    }
}