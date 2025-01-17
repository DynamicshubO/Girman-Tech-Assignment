package com.RBAC_System.user;

import com.RBAC_System.roles.RoleEntity;
import com.RBAC_System.roles.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private MessageSource messageSource;

    @Override
    @Transactional
    public String registerUser(UserEntity user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already in use");
        }
        userRepository.save(user);
        return messageSource.getMessage("user.create", null,
                "User has been created successfully.", Locale.ENGLISH);
    }

    @Override
    public UserEntity getUsersById(int userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found by id "+ userId));
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }


    @Override
    public String assignRoleToUser(int userId, int roleId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found by id "+ userId));
        RoleEntity role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        user.setRole(role);
        userRepository.save(user);

        return messageSource.getMessage("user.role.assigned", null,
                "Role assigned to user.", Locale.ENGLISH);
    }

}
