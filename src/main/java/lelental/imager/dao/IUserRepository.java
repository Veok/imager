package lelental.imager.dao;

import lelental.imager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface IUserRepository extends JpaRepository<User,Long> {

    User findByNick(String nick);
    User findByEmail(String email);
    User findById(long id);
    User findByNickAndPassword(String nick, String password);

}
