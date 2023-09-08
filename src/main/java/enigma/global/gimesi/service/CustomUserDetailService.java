package enigma.global.gimesi.service;

import enigma.global.gimesi.model.UserInfor;
import enigma.global.gimesi.repo.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserInfoRepo userInfoRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfor userInfor = null;
        userInfor = userInfoRepo.findByUserName(username);
        return userInfor;
    }
}
