package com.RBAC_System.user;

import java.util.List;

public interface UserService {

    String registerUser(UserEntity user);

    UserEntity getUsersById(int userId);

    List<UserEntity> getAllUsers();

    String assignRoleToUser(int userId, int roleId);

}
