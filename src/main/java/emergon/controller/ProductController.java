package emergon.controller;

import emergon.entity.Product;
import emergon.service.ProductService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    private ProductService service;
    
    @GetMapping
    public String showProducts(Model model){
        List<Product> products = service.findAll();
        model.addAttribute("products", products);
        return "product/list";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView showProductForm(ModelAndView model){
        model.setViewName("product/create");//  WEB-INF/view/product/create.jsp
        model.addObject("product", new Product());
        return model;
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createProduct(@ModelAttribute("product") @Valid Product product, BindingResult result, RedirectAttributes ra){
        if(result.hasErrors()){
            System.out.println("errors:"+result);
            return "product/create";
        }
        int id = service.create(product);
        String minima = "Product successfully created with id:"+id;
        ra.addFlashAttribute("productMessage", minima);
        return "redirect:/product";
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView showProductUpdateForm(@RequestParam("kwdikos")int id, ModelAndView model){
        Product c = service.findById(id);
        model.setViewName("product/edit");//  WEB-INF/view/product/update.jsp
        model.addObject("product", c);
        return model;
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editProduct(@ModelAttribute("product") Product product){
        service.edit(product);
        return "redirect:/product";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteProduct(@RequestParam("id") int pcode, RedirectAttributes ra){
        String minima = service.delete(pcode);
        ra.addFlashAttribute("productMessage", minima);
        return "redirect:/product";
    }
    
}
