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
public class Course {
    private int id;
    private String code;
    private String title;

    public Course() {
    }
    
    public Course(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
}
