package lelental.imager.service;

import lelental.imager.model.User;

public interface IUserService {

    User findByNick(String nick);

    User findByEmail(String email);

    User findById(long id);

    void saveUser(User user);

    User findByNickAndPassword(String nick, String password);
}
