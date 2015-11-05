package fr.utbm.projectlo54.core.client;

import fr.utbm.projectlo54.core.service.CourseService;
import fr.utbm.projectlo54.core.util.HibernateUtil;
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
     
        CourseService courseService = new CourseService();
       
        courseService.getCourseByKeyword("Programmation");
        
    }
}
