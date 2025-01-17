package com.RBAC_System.roles;

import com.RBAC_System.Permission.PermissionEntity;
import com.RBAC_System.Permission.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private MessageSource messageSource;


    @Override
    public String createRole(RoleEntity role) {
        roleRepository.save(role);
        return messageSource.getMessage("role.create", null,
                "Role has been created successfully.", Locale.ENGLISH);
    }

    @Override
    public List<RoleEntity> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public RoleEntity getRoleById(int roleId) {
        return roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("User not found by id "+ roleId));
    }

    @Override
    public String assignPermissionToRole(int roleId, int permissionId) {
        RoleEntity role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        PermissionEntity permission = permissionRepository.findById(permissionId)
                .orElseThrow(() -> new RuntimeException("Permission not found"));

        role.setPermission(role.getPermission());
        roleRepository.save(role);

        return messageSource.getMessage("role.permission.assigned", null,
                "Permission assigned to role.", Locale.ENGLISH);
    }

}
