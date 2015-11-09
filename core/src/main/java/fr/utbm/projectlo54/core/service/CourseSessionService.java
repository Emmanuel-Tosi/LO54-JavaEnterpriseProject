/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projectlo54.core.service;

import fr.utbm.projectlo54.core.entity.CourseSession;
import fr.utbm.projectlo54.core.repositoryHibernate.HibernateCourseSessionRepository;
import java.util.List;

/**
 *
 * @author java
 */
public class CourseSessionService {
    List<CourseSession> getCourseSession(int min, int max)
    {
        List <CourseSession> courseSessionList = null;
        
        HibernateCourseSessionRepository repository = new HibernateCourseSessionRepository();
        courseSessionList = repository.getListCourseSession(min,max);
        
        return courseSessionList;
    }
}
