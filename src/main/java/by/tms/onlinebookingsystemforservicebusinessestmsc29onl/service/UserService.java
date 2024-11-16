package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.service;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.Role;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.User;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception.UserNotFoundException;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.repository.RoleRepository;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleService roleService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>());
        user.getRoles().add(roleService.findRoleById(1L));
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        User userToUpdate = userRepository.findById(user.getId()).
                orElseThrow(() -> new UserNotFoundException("Пользователь не найден."));
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
                orElseThrow(() -> new UserNotFoundException("Пользователь не найден."));
    }

    public void deleteUserById(Long id) {
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Пользователь не найден."));
        userRepository.deleteById(id);
    }

    public void deleteUser(User user) {
        userRepository.findById(user.getId()).orElseThrow(() -> new UserNotFoundException("Пользователь не найден."));
        userRepository.delete(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
