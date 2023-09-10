package enigma.global.gimesi.service;

import enigma.global.gimesi.dao.UserDao;
import enigma.global.gimesi.model.UserInfor;
import enigma.global.gimesi.model.UserRole;
import enigma.global.gimesi.repo.UserInfoRepo;
import enigma.global.gimesi.repo.UserRoleRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserInfoRepo userInfoRepo;

    @Autowired
    private UserRoleRepo userRoleRepo;

//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

    public ResponseEntity<HttpStatus> accountRegister(UserDao userDao){

        UserRole userRole = new UserRole();
        userRole = userRoleRepo.findByRoleName(userDao.getUserRole());

        UserInfor userInfor = new UserInfor();
        userInfor.setUserName(userDao.getUserName());
//        userInfor.setPassword(passwordEncoder().encode(userDao.getPassword()));
//        userInfor.setRoleId(userRole.getRoleId());
        userInfoRepo.save(userInfor);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public UserInfor getUserInfor(String userName){

        UserInfor userInfor = new UserInfor();
        userInfor = userInfoRepo.findByUserName(userName);

        return userInfor;
    }
}
