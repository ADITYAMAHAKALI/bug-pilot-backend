package com.example.MajorProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MajorProject.DAO.BugsDao;
import com.example.MajorProject.entity.Bugs;


@Service
public class BugsServiceImpl implements BugsService{
    @Autowired
    private BugsDao obj;
    @Override
    public List<Bugs> findAll() {
        return obj.findAll();
    }

    @Override
    public Bugs findById(int Id) {
        Optional<Bugs> res = obj.findById(Id);
		Bugs theobj=null;
		if(res.isPresent())
		{
			theobj=res.get();
		}
		else
		{
			throw new RuntimeException("Sorry the ID was not found! :-(" + Id);
		}
		return theobj;
    }

    @Override
    public void deleteById(int id) {
       obj.deleteById(id);
    }

    @Override
    public void save(Bugs bug) {
        obj.save(bug);
    }
    
}
