package com.hsc.project.BugTracker.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import lombok.Data;

@Data
@Entity
public class Bug {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    // many bugs can be associated with one project
    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project project;

    // one bug can be created by one user as author
    @OneToOne
    @JoinColumn(name = "userId")
    private User author;

    // default constructor as lombok does not generate it
    Bug() {
    }
}
