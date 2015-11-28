package fr.utbm.projectlo54.core.service;

import fr.utbm.projectlo54.core.entity.Client;
import fr.utbm.projectlo54.core.entity.ClientDTO;
import fr.utbm.projectlo54.core.repositoryHibernate.HibernateClientRepository;

/**
 *
 * @author Emmanuel TOSI
 */
public class ClientService {
    public void fromDTOtoClient(ClientDTO cDTO)
    {
        Client clientToAdd = new Client();
        CourseSessionService csService = new CourseSessionService();
        
        clientToAdd.setFirstName(cDTO.getFirstName());
        clientToAdd.setLastName(cDTO.getLastName());
        clientToAdd.setAddress(cDTO.getAddress());
        clientToAdd.setPhone(cDTO.getPhone());
        clientToAdd.setEmail(cDTO.getEmail());
        
        clientToAdd.setCourseSessionId(csService.getCourseSessionById(cDTO.getCourseSessionId()));
        
        registerClient(clientToAdd);
    }
    
    public void registerClient(Client c)
    {
        System.out.println("L'insciption de " + c.getFirstName() + " " + c.getLastName() + " a été prise en compte");
        
        HibernateClientRepository repository = new HibernateClientRepository();
        repository.save(c);
    }
}
