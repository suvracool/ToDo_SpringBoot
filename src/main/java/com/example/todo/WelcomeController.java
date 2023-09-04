package com.example.todo;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController {


    @RequestMapping(value="/", method= RequestMethod.GET)

   public String gotoWelcomePage(ModelMap model){
        // Get the logged-in username and store it in the "name" attribute of the session
        model.put("name",getLoggedinUsername());
        // Return the name of the view to be rendered
        return "welcome";
    }

    // Helper method to get the logged-in username
    private String getLoggedinUsername(){
        // Retrieve the authentication object from the security context
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        // Get the username from the authentication object
        return authentication.getName();
    }


}
