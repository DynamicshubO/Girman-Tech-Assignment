package com.RBAC_System.Permission;


import java.util.List;

public interface PermissionService {

    List<PermissionEntity> getAllPermission();
    List<PermissionEntity> getPermissionsByRoleId(int roleId);
}
