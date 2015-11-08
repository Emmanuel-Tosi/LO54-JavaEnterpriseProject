/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projectlo54.core.service;
import fr.utbm.projectlo54.core.entity.Client;
import fr.utbm.projectlo54.core.repositoryHibernate.HibernateClientRepository;

/**
 *
 * @author java
 */
public class ClientService {
    public void registerClient(Client c)
    {
        System.out.println("L'insciption de " + c.getFirstName() + " " + c.getLastName() + " a été prise en compte");
        
        HibernateClientRepository repository = new HibernateClientRepository();
        repository.save(c);
    }
}
