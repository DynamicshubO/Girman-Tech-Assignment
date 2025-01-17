package com.RBAC_System.user;


import com.RBAC_System.common.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/create")
    public ResponseEntity<ApiResponse> registerUser(@RequestBody UserEntity user){
        String message = userService.registerUser(user);
        ApiResponse response = new ApiResponse(message,true);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable int id){
        return ResponseEntity.ok(userService.getUsersById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/assign/{userId}/{roleId}")
    public ResponseEntity<ApiResponse> assignRoleToUser(@PathVariable int userId,@PathVariable int roleId){
        String message = userService.assignRoleToUser(userId,roleId);
        ApiResponse response = new ApiResponse(message, true);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

}
