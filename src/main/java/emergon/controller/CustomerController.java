
package emergon.controller;

import emergon.entity.Customer;
import emergon.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired//Dependency Injection
    private CustomerService service;
    
    @RequestMapping
    public String showCustomers(Model model){
        List<Customer> customers = service.findAll();
        model.addAttribute("customers", customers);
        model.addAttribute("message", "These are the customers in the model");
        return "customer/list";
    }
}
