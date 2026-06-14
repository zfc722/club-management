package com.university.club.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.university.club.mapper.ClubMapper;
import com.university.club.model.Club;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {
    private final ClubMapper clubMapper;

    public ClubService(ClubMapper clubMapper) {
        this.clubMapper = clubMapper;
    }

    public PageInfo<Club> list(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Club> list = clubMapper.findAll();
        return new PageInfo<>(list);
    }

    public PageInfo<Club> search(String name, String category, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Club> list = clubMapper.search(name, category);
        return new PageInfo<>(list);
    }

    public Club findById(Integer id) { return clubMapper.findById(id); }
    public int save(Club club) {
        if (club.getId() == null) return clubMapper.insert(club);
        return clubMapper.update(club);
    }
    public int delete(Integer id) { return clubMapper.delete(id); }
}
