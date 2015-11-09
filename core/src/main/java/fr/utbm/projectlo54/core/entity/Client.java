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
public class Client {
    private int id;
    private String lastName;
    private String firstName;
    private String address;
    private String phone;
    private String email;
    private CourseSession courseSessionId;

    public Client() {

    }
    
    public Client(int id, String lastName, String firstName, String address, String phone, String email, CourseSession courseSessionId) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.courseSessionId = courseSessionId;
    }
    
    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public CourseSession getCourseSessionId() {
        return courseSessionId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourseSessionId(CourseSession courseSessionId) {
        this.courseSessionId = courseSessionId;
    }

}
