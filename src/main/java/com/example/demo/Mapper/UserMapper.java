package com.example.demo.Mapper;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;

public class UserMapper {

    public static List<UserDto> toDtos(List<UserEntity> userEntities) {

        List<UserDto> userDtos = new ArrayList<>();

        userEntities.stream().forEach(e -> {

            UserDto dto = new UserDto();
            dto.setId(e.getId());
            dto.setUserName(e.getUserName());
            dto.setUserType(e.getUserType());
            dto.setPassword(e.getPassword());
            dto.setLoginHistories(e.getLoginHistories());
            dto.setStatus(e.getStatus());

            dto.setCreatedBy(e.getCreatedBy());
            dto.setCreatedIp(e.getCreatedIp());
            dto.setCreatedTime(e.getCreatedTime());

            dto.setUpdatedBy(e.getUpdatedBy());
            dto.setUpdatedIp(e.getUpdatedIp());
            dto.setUpdatedTime(e.getUpdatedTime());

            userDtos.add(dto);
        });

        return userDtos;
    }

    public static List<UserEntity> toeEntities(List<UserDto> userDtos) {

        List<UserEntity> userEntities = new ArrayList<>();

        userDtos.stream().forEach(e -> {

            UserEntity entity = new UserEntity();
            entity.setId(e.getId());
            entity.setUserName(e.getUserName());
            entity.setUserType(e.getUserType());
            entity.setPassword(e.getPassword());
            entity.setLoginHistories(e.getLoginHistories());
            entity.setStatus(e.getStatus());

            entity.setCreatedBy(e.getCreatedBy());
            entity.setCreatedIp(e.getCreatedIp());
            entity.setCreatedTime(e.getCreatedTime());

            entity.setUpdatedBy(e.getUpdatedBy());
            entity.setUpdatedIp(e.getUpdatedIp());
            entity.setUpdatedTime(e.getUpdatedTime());

            userEntities.add(entity);
        });

        return userEntities;
    }
}
