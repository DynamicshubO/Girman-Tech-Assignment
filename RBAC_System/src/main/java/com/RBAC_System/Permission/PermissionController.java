package com.RBAC_System.Permission;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/perm")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/all")
    public ResponseEntity<List<PermissionEntity>> getAllPermission(){
        return ResponseEntity.of(Optional.ofNullable(permissionService.getAllPermission()));
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<List<PermissionEntity>> getPermissionsByRoleId(@PathVariable int roleId){
        return ResponseEntity.ok(permissionService.getPermissionsByRoleId(roleId));
    }

}
