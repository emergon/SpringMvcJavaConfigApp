package emergon.controller;

import emergon.entity.User;
import emergon.service.AuthenticationService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("xrhsths")
//Checks the Model. If the model contains values for xrhsths, then we can read these values
//If xrhsths is not in session, then @SessionAttributes will put xrhsths in Session
public class AuthenticationController {
    
    @Autowired
    AuthenticationService service;
    
    /**
     * @ModelAttribute will be used to add Object User in the model
     * This method will be called before every handler mapping method
     * @return 
     */
    @ModelAttribute("xrhsths")
    public User getUser(HttpSession session){
        Object o = session.getAttribute("xrhsths");
        System.out.println("Model Attribute method, xrhsths:"+o);
        return new User();
    }
    
    //@RequestMapping(value = "/login", method = RequestMethod.GET)
    @GetMapping("/login")
    public String showLoginForm(){
        //model.addAttribute("xrhsths", new User());
        return "login";
    }
    
    /**
     * @ModelAttribute will be used to read Object User from the Model (submitted in the form)
     * @param user
     * @param model
     * @param result must be after @Valid Object
     * @return 
     */
    @PostMapping("/login")
    public String checkLogin(@ModelAttribute("xrhsths") @Valid User user, BindingResult result, Model model){
        if(result.hasErrors()){
            System.out.println("errors:"+result);
            return "login";
        }
        //check if username/password are correct
        boolean userExists = service.isUserCorrect(user);
        if(userExists){//if correct, send user to the next page
            return "redirect:/";
        }else{//if wrong, send user back to login page and inform user that credentials are wrong
            model.addAttribute("message", "Username/Password are wrong");
            return "login";
        }
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(SessionStatus status){
        status.setComplete();//Finds the @SessionAttributes of this Controller and removes them from Session
        return "login";
    }
}
