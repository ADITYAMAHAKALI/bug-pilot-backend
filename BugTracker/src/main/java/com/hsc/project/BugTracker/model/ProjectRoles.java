package com.hsc.project.BugTracker.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class ProjectRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long projectRoleId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_project_id", referencedColumnName = "projectId")
    private Project project;

    // getting the project Creator
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_creator_id", referencedColumnName = "userId")
    private User creator; // same as authorId in schema

    // getting the project Managers
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "projectRoles")
    private List<User> managers;

}
