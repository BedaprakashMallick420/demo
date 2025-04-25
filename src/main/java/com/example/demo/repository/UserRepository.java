package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    @Query("SELECT u FROM UserEntity u where u.id = :id AND u.status = :status")
    UserEntity findByIdAndStatus(@Param("id") String id, @Param("status") String status);

    @Query("SELECT u FROM UserEntity u where u.userName = :userName AND u.password = :password AND u.status = :status")
    UserEntity findByUserNameAndPasswordAndStatus(@Param("userName") String userName,
            @Param("password") String password, @Param("status") String status);

    @Query("SELECT u FROM UserEntity u where u.userName = :userName AND u.status IN :statusList")
    UserEntity findByUserNameAndStatusList(@Param("userName") String userName,
            @Param("statusList") List<String> statusList);

    @Query("SELECT u FROM UserEntity u where u.userType = :userType AND u.status IN :statusList")
    List<UserEntity> findAllByUserTypeAndStatusList(@Param("userType") String userType,
            @Param("statusList") List<String> statusList);

    List<UserEntity> findAllByUserTypeListAndStatusList(@Param("userTypeList") List<String> userTypeList,
            @Param("statusList") List<String> statusList);
}