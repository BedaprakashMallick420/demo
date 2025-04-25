package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Mapper.UserMapper;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.LoginHistoryEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.DataNotFoundException;
import com.example.demo.exception.RequiredFieldException;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public static final String USER_TYPE_ADMIN = "ADMIN";
    public static final String STATUS_PENDING = "PENDING";
    public static final String STATUS_ACTIVE = "ACTIVE";

    private UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDto save(UserDto userDto) {

        /* Start Validating */
        validateUserInput(userDto, false);
        /* End Validating */

        /* Start Creating the Primary id */
        String userId = UUID.randomUUID().toString();
        String loginHistoryId = UUID.randomUUID().toString();
        LocalDateTime timeNow = LocalDateTime.now();
        /* End Creating the Primary id */

        /* Start Setting the User Entity */
        UserEntity userEntity = UserMapper.toeEntities(Collections.singletonList(userDto)).get(0);
        userEntity.setId(userId);
        userEntity.setUserType(USER_TYPE_ADMIN);
        userEntity.setStatus(STATUS_PENDING);
        userEntity.setCreatedBy("");
        userEntity.setCreatedIp("");
        userEntity.setCreatedTime(timeNow);
        userEntity.setUpdatedBy("");
        userEntity.setUpdatedIp("");
        userEntity.setUpdatedTime(timeNow);
        /* End Setting the User Entity */

        /* Start Setting the Login History Entity */
        LoginHistoryEntity loginHistoryEntity = new LoginHistoryEntity();
        loginHistoryEntity.setId(loginHistoryId);
        loginHistoryEntity.setUser(userEntity);
        loginHistoryEntity.setStatus(STATUS_ACTIVE);
        loginHistoryEntity.setCreatedBy("");
        loginHistoryEntity.setCreatedIp("");
        loginHistoryEntity.setCreatedTime(timeNow);
        /* End Setting the Login History Entity */

        userEntity.getLoginHistories().add(loginHistoryEntity);
        userRepository.save(userEntity);

        UserDto toResponse = UserMapper.toDtos(Arrays.asList(userEntity)).get(0);

        return toResponse;
    }

    @Override
    @Transactional
    public UserDto update(UserDto userDto) {

        /* Start Validating */
        validateUserInput(userDto, true);
        /* End Validating */

        /* Start Creating the Primary id */
        String loginHistoryId = UUID.randomUUID().toString();
        LocalDateTime timeNow = LocalDateTime.now();
        /* End Creating the Primary id */

        /* Start Setting the User Entity */
        UserEntity userEntity = UserMapper.toeEntities(Collections.singletonList(userDto)).get(0);
        userEntity.setUpdatedBy("");
        userEntity.setUpdatedIp("");
        userEntity.setUpdatedTime(timeNow);
        /* End Setting the User Entity */

        /* Start Setting the Login History Entity */
        LoginHistoryEntity loginHistoryEntity = new LoginHistoryEntity();
        loginHistoryEntity.setId(loginHistoryId);
        loginHistoryEntity.setUser(userEntity);
        loginHistoryEntity.setStatus(STATUS_ACTIVE);
        loginHistoryEntity.setCreatedBy("");
        loginHistoryEntity.setCreatedIp("");
        loginHistoryEntity.setCreatedTime(timeNow);
        /* End Setting the Login History Entity */

        userEntity.getLoginHistories().add(loginHistoryEntity);

        userRepository.save(userEntity);

        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<UserDto> findAllByUserType(String userType) {

        List<UserEntity> userEntities = userRepository.findAllByUserTypeAndStatusList(userType,
                Arrays.asList("ACTIVE", "INACTIVE"));

        return UserMapper.toDtos(userEntities);
    }

    @Override
    public List<UserDto> findAllByUserTypeListAndStatusList(String userTypes, String statuses) {

        List<UserEntity> userEntities = userRepository.findAllByUserTypeListAndStatusList(Arrays.asList(userTypes),
                Arrays.asList("ACTIVE, INACTIVE"));

        return UserMapper.toDtos(userEntities);
    }

    private void validateUserInput(UserDto userDto, boolean isUpdate) {

        String userName = userDto.getUserName();
        String password = userDto.getPassword();

        if (isUpdate) {
            String id = userDto.getId();
            throw new DataNotFoundException("User Not Found.");
        }

        if (userName == null || userName.isBlank() || password == null || password.isBlank()) {
            throw new RequiredFieldException("User Name or Password is Invalid.");
        }
    }

}
