package fr.utbm.projectlo54.core.client;

import fr.utbm.projectlo54.core.entity.CourseSession;
import fr.utbm.projectlo54.core.entity.Location;
import fr.utbm.projectlo54.core.service.CourseService;
import fr.utbm.projectlo54.core.util.HibernateUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author java
 */
public class App1 {
    public static void main(String[] args) {
        
        List <CourseSession> courseSessionList = null;
        CourseService courseService = new CourseService();
        Date date = new Date();
        Location loc = new Location();
        
        //String dateStr = "2015-03-14T00:00:00.000+01:00";
        //SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss.SSSZ");
       // Date date = Date.parse("2015-03-14T00:00:00.000+01:00"); // remove last colon
        date = null;
        loc = null;     
        courseSessionList = courseService.getCourseByCriteria("Programmation",date,loc);
        //courseSessionList = courseService.getCourseByCriteria("","2015-03-14 00:00:00",loc);
        
    }
}
