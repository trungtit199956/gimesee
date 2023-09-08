package enigma.global.gimesi.config;

import enigma.global.gimesi.model.UserInfor;
import enigma.global.gimesi.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        UserInfor userInfor = (UserInfor) customUserDetailService.loadUserByUsername(authentication.getName());

        return new UsernamePasswordAuthenticationToken(userInfor, authentication.getCredentials(), userInfor.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
        return true;
    }
}
