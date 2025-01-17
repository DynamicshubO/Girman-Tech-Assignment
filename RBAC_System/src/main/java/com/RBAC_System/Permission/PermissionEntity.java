package com.RBAC_System.Permission;

import com.RBAC_System.roles.RoleEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "permission")
public class PermissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String actions;
    private String resources;


    @ManyToMany(mappedBy = "permission")
    private List<RoleEntity> roles;
}
