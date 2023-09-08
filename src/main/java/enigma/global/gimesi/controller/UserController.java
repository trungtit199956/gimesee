package enigma.global.gimesi.controller;

import enigma.global.gimesi.dao.UserDao;
import enigma.global.gimesi.model.UserInfor;
import enigma.global.gimesi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
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


}
