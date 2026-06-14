package com.university.club.mapper;

import com.university.club.model.Club;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClubMapper {
    List<Club> findAll();
    Club findById(@Param("id") Integer id);
    int insert(Club club);
    int update(Club club);
    int delete(@Param("id") Integer id);
    List<Club> search(@Param("name") String name, @Param("category") String category);
}
