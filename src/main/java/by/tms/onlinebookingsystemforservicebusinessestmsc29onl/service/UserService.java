package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.service;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.User;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception.UserNotFoundException;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) throws UserNotFoundException {
       User userToUpdate = userRepository.findById(user.getId()).
               orElseThrow(()-> new UserNotFoundException("User Not Found!"));
       userToUpdate.setName(user.getName());
       userToUpdate.setEmail(user.getEmail());
       userToUpdate.setPhone(user.getPhone());
       userToUpdate.setPassword(user.getPassword());
       userToUpdate.setRoles(user.getRoles());
       userToUpdate.setOwnedProjects(user.getOwnedProjects());
       userToUpdate.setProjects(user.getProjects());
       return userRepository.save(userToUpdate);
    }
    public User getUserById(Long id) throws UserNotFoundException {
        return userRepository.findById(id).
                orElseThrow(()-> new UserNotFoundException("User Not Found!"));
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
