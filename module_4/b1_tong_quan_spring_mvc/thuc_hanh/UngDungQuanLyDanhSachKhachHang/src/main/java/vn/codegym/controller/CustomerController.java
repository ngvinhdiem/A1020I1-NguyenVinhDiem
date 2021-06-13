package vn.codegym.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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
}