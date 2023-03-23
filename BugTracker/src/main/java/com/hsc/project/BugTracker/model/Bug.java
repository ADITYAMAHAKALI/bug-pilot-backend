package com.hsc.project.BugTracker.model;

import java.time.LocalDateTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.Data;


@Data
@Entity
public class Bug {
    @Id
    @GeneratedValue(generator = "bug_id_seq", strategy = GenerationType.SEQUENCE)
    private Long bugId;
    private String bugTitle;
    @Column
    private LocalDateTime bugCreatedOn;
    private String bugAuthor;
    private String bugLabel;
    private boolean isOpen;
    @PrePersist
    public void setCreationDateTime() {
        this.bugCreatedOn = LocalDateTime.now();
    }
    // default constructor as lombok does not generate it
    Bug(){}
}
