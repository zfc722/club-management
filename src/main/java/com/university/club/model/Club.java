package com.university.club.model;

import java.util.Date;

public class Club {
    private Integer id;
    private String name;
    private String category;
    private String president;
    private String description;
    private String contact;
    private Date createdAt;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getPresident() { return president; }
    public void setPresident(String president) { this.president = president; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
}
