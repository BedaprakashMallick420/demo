package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "login_history")
public class LoginHistoryEntity {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private String status;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "created_ip", nullable = false)
    private String createdIp;

    @Column(name = "created_time", nullable = false, updatable = false)
    private LocalDateTime createdTime;
}
