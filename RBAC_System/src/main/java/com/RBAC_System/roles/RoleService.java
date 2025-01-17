package com.RBAC_System.roles;

import java.util.List;

public interface RoleService {

    String createRole(RoleEntity role);

    RoleEntity getRoleById(int roleId);

    List<RoleEntity> getAllRoles();

    String assignPermissionToRole(int roleId, int permissionId);

}
