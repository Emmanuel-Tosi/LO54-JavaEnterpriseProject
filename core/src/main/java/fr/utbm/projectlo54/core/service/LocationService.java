package fr.utbm.projectlo54.core.service;

import fr.utbm.projectlo54.core.entity.Location;
import fr.utbm.projectlo54.core.repositoryHibernate.HibernateLocationRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emmanuel TOSI
 */
public class LocationService {
    public LocationService()
    {
        
    }
    
    public List<String> getCity()
    {
        List <Location> locationList = null;
        List <String> cityList = new ArrayList<String>();
        String element = new String();
        element = null;
        
        HibernateLocationRepository repository = new HibernateLocationRepository();
        locationList = repository.getAllLocation();
        
        System.out.println("Liste des villes");
        for(int i = 0; i < locationList.size(); i++) {
            element = locationList.get(i).getCity();
            System.out.println(i + " - " + element);
            cityList.add(element);
        }
        
        return cityList;
        
    } 
}
