package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.exception.CustomerNotFoundException;
import vn.codegym.exception.DuplicateEmailException;
import vn.codegym.model.Customer;
import vn.codegym.model.Province;
import vn.codegym.service.CustomerService;
import vn.codegym.service.ProvinceService;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    ProvinceService provinceService;

    @ModelAttribute("provinces")
    public List<Province> provinces(){
        return provinceService.findAll();
    }

    @GetMapping(value = {"/", "/customer"})
    public String showList(@RequestParam("kq") Optional<String> kq, Model model, @PageableDefault(value = 3) Pageable pageable) {
        Page<Customer> customerList;
        if (kq.isPresent()){
            customerList = customerService.findAllByFirstNameContaining(kq.get(), pageable);
        }
        else {
            customerList = customerService.findAll(pageable);
        }
        model.addAttribute("customerList", customerList);
        return "customer/list";
    }

    @GetMapping("/customer/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/customer/create")
    public String saveCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) throws DuplicateEmailException {
        redirectAttributes.addFlashAttribute("message", "Create customer success");
        customerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/customer/edit/{id}")
    public String edit(@PathVariable int id, Model model) throws CustomerNotFoundException {
        Customer customer = customerService.findById(id);
        if ((customer == null)){
            throw new CustomerNotFoundException();
        }
        model.addAttribute("customer", customer);
        return "customer/edit";
    }

    @PostMapping("/update")
    public String update(Customer customer, RedirectAttributes redirectAttributes) throws DuplicateEmailException {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Update customer success");
        return "redirect:/customer";
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
        return "redirect:/customer";
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public String showErrorPage(){
        return "error/error_not_found";
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("error/error_email");
    }

}