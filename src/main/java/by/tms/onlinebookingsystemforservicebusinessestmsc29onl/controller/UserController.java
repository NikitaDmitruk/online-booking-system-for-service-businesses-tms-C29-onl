package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.controller;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.dto.UserRegisterDto;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.Project;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.Role;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.User;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.mapper.UserMapper;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.service.ProjectService;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        User updatedUser = userService.updateUser(user);
        return ResponseEntity.ok(updatedUser);

    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserRegisterDto userRegisterDto) {
        User user = userMapper.toEntity(userRegisterDto);
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/projects")
    @PreAuthorize("#id == authentication.principal.id or hasRole('ADMIN')")
    public ResponseEntity<List<Project>> getAllProjects(@PathVariable Long id) {
        List<Project> projects = projectService.getProjectsByOwnerId(id);
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{id}/roles")
    @PreAuthorize("#id == authentication.principal.id or hasRole('ADMIN')")
    public ResponseEntity<Set<Role>> getAllRoles(@PathVariable Long id, @AuthenticationPrincipal User user) {
        Set<Role> roles = user.getRoles();
        return ResponseEntity.ok(user.getRoles());
    }
}
