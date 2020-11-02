package emergon.service;

import emergon.entity.User;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    
    public boolean isUserCorrect(User user){
        boolean isUserCorrect = false;
        if(user.getUsername().equals("admin")&& user.getPassword().equals("1234")){
            isUserCorrect = true;
        }
        return isUserCorrect;
    }
}
