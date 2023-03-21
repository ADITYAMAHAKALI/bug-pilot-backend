package com.example.MajorProject.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bugs")
public class Bugs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Bug_Id")
    int bugId;
    @Column(name="Bug_Title")
    String bugTitle;
    @Column(name="Bug_Status")
    String status;
    @Column(name="Priority")
    String priority;
    @Column(name="Author")
    String author;
    @Column(name="Label")
    String label;
    @Column(name="Created_On")
    Date createdOn;
    public int getBugId() {
        return bugId;
    }
    public String getBugTitle() {
        return bugTitle;
    }
    public String getStatus() {
        return status;
    }
    public String getPriority() {
        return priority;
    }
    public String getAuthor() {
        return author;
    }
    public String getLabel() {
        return label;
    }
    public Date getCreatedOn() {
        return createdOn;
    }
    public void setBugId(int bugId) {
        this.bugId = bugId;
    }
    public void setBugTitle(String bugTitle) {
        this.bugTitle = bugTitle;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
    public Bugs(int bugId, String bugTitle, String status, String priority, String author, String label,
            Date createdOn) {
        this.bugId = bugId;
        this.bugTitle = bugTitle;
        this.status = status;
        this.priority = priority;
        this.author = author;
        this.label = label;
        this.createdOn = createdOn;
    }
    public Bugs() {
    }
    @Override
    public String toString() {
        return "Bugs [bugId=" + bugId + ", bugTitle=" + bugTitle + ", status=" + status + ", priority=" + priority
                + ", author=" + author + ", label=" + label + ", createdOn=" + createdOn + "]";
    }
}
/* Errors faced
Spring Boot JPA unknown column in field list
Error: org.springframework.web.HttpMediaTypeNotSupportedException: Content type 'text/plain;charset=UTF-8' not supported
*/ 