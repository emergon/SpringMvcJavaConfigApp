package emergon.controller;

import emergon.entity.Product;
import emergon.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    
    
}
