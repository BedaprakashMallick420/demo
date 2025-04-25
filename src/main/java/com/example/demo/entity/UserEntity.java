package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    private String id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_type", nullable = false)
    private String userType;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LoginHistoryEntity> loginHistories = new ArrayList<>();

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "created_ip", nullable = false)
    private String createdIp;

    @Column(name = "created_time", nullable = false, updatable = false)
    private LocalDateTime createdTime;

    @Column(name = "updated_by", nullable = false)
    private String updatedBy;

    @Column(name = "updated_ip", nullable = false)
    private String updatedIp;

    @Column(name = "updated_time", nullable = false)
    private LocalDateTime updatedTime;
}