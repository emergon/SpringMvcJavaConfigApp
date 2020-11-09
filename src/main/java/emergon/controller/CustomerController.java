
package emergon.controller;

import emergon.entity.Customer;
import emergon.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired//Dependency Injection
    private CustomerService service;
    
    public void hello(){
        System.out.println("hello");
    }
    
    @RequestMapping
    public String showCustomers(Model model){
        List<Customer> customers = service.findAll();
        model.addAttribute("customers", customers);
        model.addAttribute("message", "These are the customers in the model");
        return "customer/list";
    }
    
    @GetMapping("/rest/customers")
    @ResponseBody
    public List<Customer> getCustomersInJson(){
        return service.findAll();
    }
    
    @PostMapping("/rest/customers")
    @ResponseBody
    public ResponseEntity save(@RequestBody Customer customer){
        int id = service.create(customer);
        return ResponseEntity.ok().body("Customer was successfully created with id:"+id);
    }
    
    @GetMapping("/rest/customers/{kwdikos}")
    @ResponseBody
    public ResponseEntity getCustomerById(@PathVariable("kwdikos") int kwdikos){
        Customer customer = service.findById(kwdikos);
        if(customer != null){
            return ResponseEntity.ok().body(customer);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer with id:"+kwdikos+" doesn't exist!!!");
        }
    }
    
    @DeleteMapping(value = "/rest/customers/{kwdikos}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable("kwdikos") int ccode){
        String minima = service.delete(ccode);
        return ResponseEntity.ok().body(minima);
    }
    
    @PutMapping(value = "/rest/customers/{kwdikos}")
    @ResponseBody
    public ResponseEntity edit(@PathVariable("kwdikos") int ccode, @RequestBody Customer updatedCustomer){
        Customer oldCustomer = service.findById(ccode);
        oldCustomer.setCname(updatedCustomer.getCname());
        service.edit(oldCustomer);
        return ResponseEntity.ok().body("Customer updated successfully!!!!");
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView showCustomerForm(ModelAndView model){
        model.setViewName("customer/create");//  WEB-INF/view/customer/create.jsp
        model.addObject("customer", new Customer());
        return model;
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes ra){
        int id = service.create(customer);
        String minima = "Customer successfully created with id:"+id;
        ra.addFlashAttribute("customerMessage", minima);
        return "redirect:/customer";
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView showCustomerUpdateForm(@RequestParam("kwdikos")int id, ModelAndView model){
        Customer c = service.findById(id);
        model.setViewName("customer/edit");//  WEB-INF/view/customer/update.jsp
        model.addObject("customer", c);
        return model;
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editCustomer(@ModelAttribute("customer") Customer customer){
        service.edit(customer);
        return "redirect:/customer";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteCustomer(@RequestParam("id") int ccode, RedirectAttributes ra){
        String minima = service.delete(ccode);
        ra.addFlashAttribute("customerMessage", minima);
        return "redirect:/customer";
    }
}
