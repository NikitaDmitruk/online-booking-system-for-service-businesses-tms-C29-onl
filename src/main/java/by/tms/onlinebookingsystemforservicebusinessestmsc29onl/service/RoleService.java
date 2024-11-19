package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.service;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.Role;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception.RoleNotFoundException;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Role updateRole(Role role) {
        Role roleToUpdate = roleRepository.findById(role.getId())
                .orElseThrow(RoleNotFoundException::new);
        roleToUpdate.setName(role.getName());
        roleToUpdate.setUsers(role.getUsers());
        return roleRepository.save(roleToUpdate);
    }

    public Role findRoleById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(RoleNotFoundException::new);
    }

    public void deleteRole(Long id) {
        roleRepository.findById(id).orElseThrow(RoleNotFoundException::new);
        roleRepository.deleteById(id);
    }

    public void deleteRole(Role role) {
        roleRepository.findById(role.getId()).orElseThrow(RoleNotFoundException::new);
        roleRepository.delete(role);
    }

    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }
}
