/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projectlo54.core.service;

import fr.utbm.projectlo54.core.entity.Course;
import fr.utbm.projectlo54.core.entity.CourseSession;
import fr.utbm.projectlo54.core.entity.Location;
import fr.utbm.projectlo54.core.repositoryHibernate.HibernateCourseRepository;
import java.util.Date;
import java.util.List;

/**
 *
 * @author java
 */
public class CourseService {

    public CourseService() 
    {
        
    }
    
    public List<CourseSession> getCourseByCriteria(String keyword, Date date, Location location)
    {
        List <CourseSession> courseSessionList = null;
        System.out.println("Liste des formations disponibles ");
        System.out.println("");
                
        HibernateCourseRepository repository = new HibernateCourseRepository();
        courseSessionList = repository.getByCriteria(keyword,date,location);
        
       // System.out.println(courseSessionList.size());
        for(int i = 0; i < courseSessionList.size(); i++) {
            System.out.println(i + " - cours nommé " + courseSessionList.get(i).getCourseCode().getCode());
            System.out.println("");
        }
        
        return courseSessionList; 
    }
}
