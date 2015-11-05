/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projectlo54.core.service;

import fr.utbm.projectlo54.core.entity.Course;
import fr.utbm.projectlo54.core.entity.Location;
import fr.utbm.projectlo54.core.repositoryHibernate.HibernateCourseRepository;
import java.util.Date;
import java.util.List;

/**
 *
 * @author java
 */
public class CourseService {

    public CourseService() {
    }
    
    public List<Course> getCourseByKeyword(String keyword)
    {
        List <Course> courseList = null;
        System.out.println("Liste des formations disponibles dont le titre contient: " + keyword);
        System.out.println("");
        System.out.println("");
        
        HibernateCourseRepository repository = new HibernateCourseRepository();
        courseList = repository.getByKeyword(keyword);
        
        for(int i = 0; i < courseList.size(); i++) {
            System.out.println(i + " - cours nommé " + courseList.get(i).getTitle());
            System.out.println("");
            System.out.println("");
            System.out.println("");
        }
        
        return courseList;
    }
    
    public List<Course> getCourseByDate(Date startDate)
    {
        List <Course> courseList = null;
        System.out.println("Liste des formations disponibles pour la date demandée: ");
        
        HibernateCourseRepository repository = new HibernateCourseRepository();
        courseList = repository.getByDate(startDate);
        
        return courseList;
    }
    
    public List<Course> getCourseByLocation(Location location)
    {
        List <Course> courseList = null;
        System.out.println("Liste des formations disponibles à: " + location.getCity());
        
        HibernateCourseRepository repository = new HibernateCourseRepository();
        courseList = repository.getByLocation(location);
        
        return courseList;
    }
}
