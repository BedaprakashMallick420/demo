package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.LoginHistoryEntity;

public interface LoginHistoryRepository extends JpaRepository<LoginHistoryEntity, String> {

}
