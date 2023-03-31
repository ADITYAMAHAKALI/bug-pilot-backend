package com.example.MajorProject.service;

import java.util.List;

import com.example.MajorProject.entity.Bugs;

public interface BugsService {
    public List<Bugs> findAll();
    public Bugs findById(int Id);
    public void deleteById(int id);
    public void save(Bugs bug);
}
