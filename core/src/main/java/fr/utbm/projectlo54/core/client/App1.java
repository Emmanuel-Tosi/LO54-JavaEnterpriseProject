package fr.utbm.projectlo54.core.client;

import fr.utbm.projectlo54.core.entity.CourseSession;
import fr.utbm.projectlo54.core.entity.Location;
import fr.utbm.projectlo54.core.service.CourseService;
import fr.utbm.projectlo54.core.service.CourseSessionService;
import fr.utbm.projectlo54.core.util.HibernateUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
        CourseSessionService courseService = new CourseSessionService();
        String cityLoc = new String();
        
        Date date = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String date1 = "2014-11-15";
        
        try {
          date = simpleDateFormat.parse(date1);
          System.out.println(date);
        } catch (ParseException e) {
          e.printStackTrace();
        }
        
        cityLoc = "Belfort";     
        courseSessionList = courseService.getCourseByCriteria(null,date,null);
        
        System.out.println("JE SUIS LA");
        System.out.println(courseSessionList);
        
    }
}
