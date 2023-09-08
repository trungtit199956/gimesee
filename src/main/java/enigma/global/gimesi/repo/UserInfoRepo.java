package enigma.global.gimesi.repo;

import enigma.global.gimesi.model.UserInfor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepo extends CrudRepository<UserInfor, Integer> {

    UserInfor findByUserName(String userName);

}
