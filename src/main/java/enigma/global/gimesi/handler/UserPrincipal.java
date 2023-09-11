//package enigma.global.gimesi.handler;
//
//import enigma.global.gimesi.model.UserInfor;
//import enigma.global.gimesi.model.UserRole;
//import enigma.global.gimesi.repo.UserRoleRepo;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//public class UserPrincipal {
//
//
//    private static UserRoleRepo userRoleRepo;
//
//    private int userId;
//    private String userName;
//    private String password;
//
//    private Collection<? extends GrantedAuthority> authorities;
//
//    public UserPrincipal(int userId, String userName, String password, Collection<? extends GrantedAuthority> authorities) {
//        this.userId = userId;
//        this.userName = userName;
//        this.password = password;
//        this.authorities = authorities;
//    }
//
//    public static UserPrincipal create(UserInfor userInfor){
//        Set<UserRole> roles = userRoleRepo.findAllById(userInfor.getRoleId());
//
//        List<GrantedAuthority> authorities = roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
//
//        return new UserPrincipal(userInfor.getUserId(), userInfor.getUserName(), userInfor.getPassword(), authorities);
//    }
//}
