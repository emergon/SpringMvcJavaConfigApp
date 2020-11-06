
package emergon.controller;

import emergon.entity.Salesman;
import emergon.service.SalesmanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/salesman")
public class SalesmanController {
    
    @Autowired//Dependency Injection
    private SalesmanService service;
    
    @RequestMapping
    public String showSalesmen(Model model){
        List<Salesman> salesmen = service.findAll();
        model.addAttribute("salesmen", salesmen);
        model.addAttribute("message", "These are the salesmen in the model");
        return "salesman/list";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView showSalesmanForm(ModelAndView model){
        model.setViewName("salesman/create");//  WEB-INF/view/salesman/create.jsp
        model.addObject("salesman", new Salesman());
        return model;
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createSalesman(@ModelAttribute("salesman") Salesman salesman, RedirectAttributes ra){
        int id = service.create(salesman);
        String minima = "Salesman successfully created with id:"+id;
        ra.addFlashAttribute("salesmanMessage", minima);
        return "redirect:/salesman";
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView showSalesmanUpdateForm(@RequestParam("kwdikos")int id, ModelAndView model){
        Salesman c = service.findById(id);
        model.setViewName("salesman/edit");//  WEB-INF/view/salesman/update.jsp
        model.addObject("salesman", c);
        return model;
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editSalesman(@ModelAttribute("salesman") Salesman salesman){
        service.edit(salesman);
        return "redirect:/salesman";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteSalesman(@RequestParam("id") int ccode, RedirectAttributes ra){
        String minima = service.delete(ccode);
        ra.addFlashAttribute("salesmanMessage", minima);
        return "redirect:/salesman";
    }
}
