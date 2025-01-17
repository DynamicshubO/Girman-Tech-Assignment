package com.RBAC_System.roles;

import com.RBAC_System.Permission.PermissionEntity;
import com.RBAC_System.enums.RoleType;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name ="role")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @ManyToMany(fetch = FetchType.LAZY, cascade =CascadeType.ALL)
    @JoinTable(name = "role_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private List<PermissionEntity> permission;



    public RoleEntity(int roleId, RoleType roleType) {
        this.roleId = roleId;
        this.roleType = roleType;
    }

    public RoleEntity() {
    }



    public int getRoleId() {

        return roleId;
    }

    public void setRoleId(int roleId) {

        this.roleId = roleId;

    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public List<PermissionEntity> getPermission() {

        return permission;
    }

    public void setPermission(List<PermissionEntity> permission) {

        this.permission = permission;
    }

}
