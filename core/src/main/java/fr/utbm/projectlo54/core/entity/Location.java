/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projectlo54.core.entity;

/**
 *
 * @author java
 */
public class Location {
    private int id;
    private String city;

    public Location() {
    }
    
    public Location(int id, String city) {
        this.id = id;
        this.city = city;
    }
    
    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    
    
}
