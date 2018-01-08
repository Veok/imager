package lelental.imager.service;

import lelental.imager.model.User;

public interface IUserService {

    public User findByNick(String nick);

    public User findByEmail(String email);

    public User findById(long id);

    public void saveUser(User user);

    public User findByNickAndPassword(String nick, String password);
}
