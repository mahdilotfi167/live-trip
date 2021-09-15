package co.live.trip.service.imples;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.live.trip.model.Role;
import co.live.trip.model.User;
import co.live.trip.repository.UserRepository;
import co.live.trip.service.UserService;

@Primary
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> res = userRepository.findByUsername(username);
        if (!res.isPresent()) {
            throw new UsernameNotFoundException("User not found !");
        }
        return res.get();
    }

    @Override
    public void addUser(User user) {
        Collection<Role> roles = new HashSet<>();
        roles.add(Role.USER);
        user.setAuthorities(roles);
        user.setPassword("{noop}" + user.getPassword());
        this.userRepository.save(user);
    }
}
