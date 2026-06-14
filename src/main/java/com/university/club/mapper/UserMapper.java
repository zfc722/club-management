package com.university.club.mapper;

import com.university.club.model.UserAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    UserAccount findByUsername(@Param("username") String username);
}
