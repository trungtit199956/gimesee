package enigma.global.gimesi.controller;

import enigma.global.gimesi.dao.UserDao;
import enigma.global.gimesi.model.UserInfor;
import enigma.global.gimesi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<HttpStatus> userRegister(@Validated UserDao userDao){

        userService.accountRegister(userDao);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/userInfor")
    public UserInfor getUserInfor(@RequestParam String userName){
        UserInfor userInfor = new UserInfor();
        userInfor = userService.getUserInfor(userName);

        return userInfor;
    }

//    @GetMapping("/login")
//    public String login(HttpServletRequest request, HttpSession session) {
//        session.setAttribute("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
//        return "login";
//    }


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
