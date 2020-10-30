
package emergon.controller;

import emergon.entity.Customer;
import emergon.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView showCustomerForm(ModelAndView model){
        model.setViewName("customer/create");//  WEB-INF/view/customer/create.jsp
        model.addObject("customer", new Customer());
        return model;
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createCustomer(@ModelAttribute("customer") Customer customer){
        service.create(customer);
        return "redirect:/customer";
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView showCustomerUpdateForm(@RequestParam("onoma")String name, ModelAndView model){
        Customer c = service.findByName(name);
        model.setViewName("customer/edit");//  WEB-INF/view/customer/update.jsp
        model.addObject("customer", c);
        return model;
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editCustomer(@ModelAttribute("customer") Customer customer){
        service.edit(customer);
        return "redirect:/customer";
    }
}
