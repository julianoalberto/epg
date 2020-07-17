package com.epg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "channel")
public class Channel {

    private String id;
    private String name;
    private int position;
    private String category;

    public Channel() {

    }

    public Channel(String name, int position, String category) {
        this.setName(name);
        this.setPosition(position);
        this.category = category;
    }

    @Id
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "position", nullable = false)
    public int getPosition() {
        return position;
    }
    
    public void setPosition(int position) {
        this.position = position;
    }

    @Column(name = "category", nullable = false)
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
}
