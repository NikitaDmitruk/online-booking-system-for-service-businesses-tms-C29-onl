package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.service;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.User;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception.UserNotFoundException;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>());
        user.getRoles().add(roleService.findRoleById(1L));
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        User userToUpdate = userRepository.findById(user.getId()).
                orElseThrow(UserNotFoundException::new);
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPhone(user.getPhone());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setRoles(user.getRoles());
        userToUpdate.setOwnedProjects(user.getOwnedProjects());
        userToUpdate.setProjects(user.getProjects());
        return userRepository.save(userToUpdate);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).
                orElseThrow(UserNotFoundException::new);
    }

    public void deleteUserById(Long id) {
        userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        userRepository.deleteById(id);
    }

    public void deleteUser(User user) {
        userRepository.findById(user.getId()).orElseThrow((UserNotFoundException::new));
        userRepository.delete(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
