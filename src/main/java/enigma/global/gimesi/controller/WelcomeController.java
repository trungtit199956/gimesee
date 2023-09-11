package enigma.global.gimesi.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class WelcomeController {

//    @GetMapping("/")
//    public String index(){
//        return "success";
//    }

    @GetMapping("/")
    public String publicHome(){
        return "public/home";
    }

    @GetMapping("/public/login")
    public String messagingLogin(HttpServletRequest request, HttpSession session) {
        session.setAttribute(
                "error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION")
        );
        return "/public/login";
    }

    @GetMapping("/business/login")
    public String businessLogin(HttpServletRequest request, HttpSession session) {
        session.setAttribute(
                "error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION")
        );
        return "/business/login";
    }

    @GetMapping("/business/home")
    public String businessHome(){
        return "/business/home";
    }

    @GetMapping("/public/home")
    public String publicHome1(){
        return "/public/home";
    }
//    @PreAuthorize("hasAnyRole('ROLE_GMS_ADMIN','ROLE_DEALER_ADMIN')")
    @GetMapping("/success")
    public String loginSuccess(){
        return "/success";
    }

    private String getErrorMessage(HttpServletRequest request, String key) {
        Exception exception = (Exception) request.getSession().getAttribute(key);
        String error = "";
        if (exception instanceof BadCredentialsException) {
            error = "Invalid username and password!";
        } else if (exception instanceof LockedException) {
            error = exception.getMessage();
        } else {
            error = "Invalid username and password!";
        }
        return error;
    }

}
