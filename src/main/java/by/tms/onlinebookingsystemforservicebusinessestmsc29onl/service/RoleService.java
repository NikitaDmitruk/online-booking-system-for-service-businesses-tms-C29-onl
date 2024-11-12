package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.service;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.Role;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception.RoleNotFoundException;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Role updateRole(Role role) throws RoleNotFoundException {
        Role roleToUpdate = roleRepository.findById(role.getId()).
                orElseThrow(() -> new RoleNotFoundException("Role Not Found!"));
        roleToUpdate.setName(role.getName());
        roleToUpdate.setUsers(role.getUsers());
        return roleRepository.save(roleToUpdate);
    }

    public Role findRoleById(Long id) throws RoleNotFoundException {
        return roleRepository.findById(id).
                orElseThrow(() -> new RoleNotFoundException("Role Not Found!"));
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    public void deleteRole(Role role) {
        roleRepository.delete(role);
    }

    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }
}