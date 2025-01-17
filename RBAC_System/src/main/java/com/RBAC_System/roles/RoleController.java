package com.RBAC_System.roles;


import com.RBAC_System.common.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;


    @GetMapping("/create")
    public ResponseEntity<ApiResponse>  createRole(@RequestBody RoleEntity role){
        String message = roleService.createRole(role);
        ApiResponse response = new ApiResponse(message,true);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RoleEntity>> getAllRoles(){
        return  ResponseEntity.ok(roleService.getAllRoles());
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<RoleEntity> getRoleById(@PathVariable int roleId){
        return ResponseEntity.ok(roleService.getRoleById(roleId));
    }

    @PostMapping("/assign/{roleId}/{permissionId}")
    public ResponseEntity<ApiResponse> assignPermissionToRole(@PathVariable int roleId,@PathVariable int permissionId){
        String message = roleService.assignPermissionToRole(roleId,permissionId);
        ApiResponse response = new ApiResponse(message, true);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

}
