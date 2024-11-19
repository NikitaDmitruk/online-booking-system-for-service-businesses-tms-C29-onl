package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.controller;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.Role;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> getRoles() {
        List<Role> roles = roleService.findAllRoles();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRole(@PathVariable Long id) {
        Role role = roleService.findRoleById(id);
        return ResponseEntity.ok(role);
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        Role createdRole = roleService.createRole(role);
        return ResponseEntity.ok(createdRole);
    }
}
