package fr.utbm.projectlo54.core.service;

import fr.utbm.projectlo54.core.entity.CourseSession;
import fr.utbm.projectlo54.core.repositoryHibernate.HibernateCourseSessionRepository;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Emmanuel TOSI
 */
public class CourseSessionService {
    public CourseSessionService()
    {
        
    }
    
      public List<CourseSession> getCourseByCriteria(String keyword, Date date, String cityLocation)
    {
        List <CourseSession> courseSessionList = null;
        System.out.println("Liste des formations disponibles ");
        System.out.println("");
                
        HibernateCourseSessionRepository repository = new HibernateCourseSessionRepository();
        courseSessionList = repository.getByCriteria(keyword,date,cityLocation);
        
        for(int i = 0; i < courseSessionList.size(); i++) {
            System.out.println(i + " - cours nommé " + courseSessionList.get(i).getCourseCode().getCode() + " Lieu: " + courseSessionList.get(i).getLocationId().getCity() + " Start date: " + courseSessionList.get(i).getStartDate());
            System.out.println("");
        }
        
        return courseSessionList; 
    }
      
    public List<CourseSession> getCourseSession()
    {
        List <CourseSession> courseSessionList = null;
        
        HibernateCourseSessionRepository repository = new HibernateCourseSessionRepository();
        courseSessionList = repository.getListCourseSession();
        
        return courseSessionList;
    }
    
    public CourseSession getCourseSessionById(int id)
    {
        CourseSession searchedCourse;
        
        HibernateCourseSessionRepository repository = new HibernateCourseSessionRepository();
        searchedCourse = repository.getById(id);
        
        return searchedCourse;
    }
}
