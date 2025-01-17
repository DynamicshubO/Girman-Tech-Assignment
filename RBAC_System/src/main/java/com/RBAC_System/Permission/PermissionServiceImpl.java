package com.RBAC_System.Permission;

import com.RBAC_System.roles.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public List<PermissionEntity> getAllPermission() {
        return permissionRepository.findAll();
    }

    @Override
    public List<PermissionEntity> getPermissionsByRoleId(int roleId) {
        if (roleRepository.findById(roleId).isPresent()) {

            return permissionRepository.findAllById(Collections.singleton(roleId));
        }
        return null;
    }
}
