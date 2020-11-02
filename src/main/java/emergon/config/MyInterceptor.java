package emergon.config;

import emergon.entity.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class MyInterceptor extends HandlerInterceptorAdapter{

    @Override//This method will run after handler method
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("xrhsths");
        String requestUri = request.getRequestURI();
        boolean isUserTryingToGoToLoginPage = requestUri.contains("login");
        //an o user einai kenos kai prospathei na mpei se mia selida ektos tou login, tote mhn ton afhnei
        if(!isUserTryingToGoToLoginPage && (user == null || user.getUsername()==null)){
           response.sendRedirect(request.getContextPath()+"/login");
        }
    }
    
    
    
    
}
