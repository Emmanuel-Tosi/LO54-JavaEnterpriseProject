package fr.utbm.projectlo54.core.client;

import fr.utbm.projectlo54.core.entity.ClientDTO;
import fr.utbm.projectlo54.core.service.ClientService;

/**
 *
 * @author Emmanuel TOSI
 */
public class App3 {
    public static void main(String[] args) {
        ClientDTO cDTO =  new ClientDTO();
        
        cDTO.setFirstName("Nicolas");
        cDTO.setLastName("Dupond");
        cDTO.setAddress("rue blablab");
        cDTO.setPhone("0123456789");
        cDTO.setEmail("test@test.com");
        cDTO.setCourseSessionId(1);
        
        ClientService cliService = new ClientService();
        cliService.fromDTOtoClient(cDTO);
    }
}
