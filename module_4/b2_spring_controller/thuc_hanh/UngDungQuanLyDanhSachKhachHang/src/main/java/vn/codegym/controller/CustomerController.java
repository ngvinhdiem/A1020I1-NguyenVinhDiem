package vn.codegym.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Customer;
import vn.codegym.service.CustomerService;


@Controller
@RequestMapping(value = {"/customers", "/"})
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = {"/list", "/"}, method = RequestMethod.GET)
    public ModelAndView showlist(){
        return new ModelAndView("list", "customerList", customerService.findAll());
    }

    @GetMapping(value = "/info/{id}")
    public String showInfo(@PathVariable("id") int customerId, ModelMap modelMap){
        modelMap.addAttribute("customerInfo", customerService.findById(customerId));
        return "info";
    }

    @GetMapping(value = "/update/{id}")
    public String showUpdate(@PathVariable("id") int customerId, ModelMap modelMap){
        modelMap.addAttribute("customerInfo", customerService.findById(customerId));
        return "update";
    }

    @PostMapping(value = "/update/{id}")
    public String updateCustomer(@PathVariable("id") int customerId, @RequestParam String name,
                                 @RequestParam String email, @RequestParam String address){
        Customer customer = customerService.findById(customerId);
        customer.setName(name);
        customer.setEmail(email);
        customer.setAddress(address);
        customerService.update(customerId, customer);
        return "redirect:/list";
    }
}