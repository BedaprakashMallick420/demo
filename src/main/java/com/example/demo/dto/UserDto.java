package com.example.demo.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.entity.LoginHistoryEntity;

import lombok.Data;

@Data
public class UserDto {

    private String id;

    private String userName;

    private String userType;

    private String password;

    private List<LoginHistoryEntity> loginHistories;

    private String status;

    private String createdBy;

    private String createdIp;

    private LocalDateTime createdTime;

    private String updatedBy;

    private String updatedIp;

    private LocalDateTime updatedTime;
}