package lelental.imager.service;

import lelental.imager.dao.IRoleRepository;
import lelental.imager.dao.IUserRepository;
import lelental.imager.model.Role;
import lelental.imager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public User findByNick(String nick) {
        return userRepository.findByNick(nick);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        user.setPictureList(new ArrayList<>());
        userRepository.save(user);
    }

    @Override
    public User findByNickAndPassword(String nick, String password) {
        return userRepository.findByNickAndPassword(nick, password);
    }
}
