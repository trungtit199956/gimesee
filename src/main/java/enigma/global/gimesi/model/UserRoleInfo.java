package enigma.global.gimesi.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_role_info")
@Data
public class UserRoleInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_info_id")
    private int userRoleInfoId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "role_id")
    private int roleId;



}
