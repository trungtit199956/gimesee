package enigma.global.gimesi.service;

import enigma.global.gimesi.model.UserInfor;
import enigma.global.gimesi.model.UserRole;
import enigma.global.gimesi.repo.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepo userInfoRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfor userInfor = userInfoRepo.findByUserName(username);

        if (userInfor == null) {
            throw new UsernameNotFoundException("user not found!!!");
        }


        return new User(userInfor.getUserName(), userInfor.getPassword(), getAuthorities(userInfor.getUserRole()));
    }

    private Set<GrantedAuthority> getAuthorities(Set<UserRole> userRoles){

        Set<GrantedAuthority> authorities = new HashSet<>();

        for (UserRole role : userRoles){
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }



}
