/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projectlo54.core.entity;

import java.util.Date;

/**
 *
 * @author java
 */
public class CourseSession {
    private int id;
    private Date startDate;
    private Date endDate;
    private Course courseCode;
    private Location locationId;

    public CourseSession() {
        
    }
    
    public CourseSession(int id, Date startDate, Date endDate, Course courseCode, Location locationId) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.courseCode = courseCode;
        this.locationId = locationId;
    }
    
    public int getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Course getCourseCode() {
        return courseCode;
    }

    public Location getLocationId() {
        return locationId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setCourseCode(Course courseCode) {
        this.courseCode = courseCode;
    }

    public void setLocationId(Location locationId) {
        this.locationId = locationId;
    }
    
    
}
