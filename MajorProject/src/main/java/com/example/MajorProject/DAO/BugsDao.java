package com.example.MajorProject.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MajorProject.entity.Bugs;

public interface BugsDao extends JpaRepository<Bugs,Integer> {
    
}
