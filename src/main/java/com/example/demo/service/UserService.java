package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDto;

public interface UserService {

    UserDto save(UserDto userDto);

    UserDto update(UserDto userDto);

    List<UserDto> findAllByUserType(String userType);

    List<UserDto> findAllByUserTypeListAndStatusList(String userTypes, String statuses);
}
