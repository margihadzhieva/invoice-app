package org.myproject.invoicesystem.services;

import org.myproject.invoicesystem.models.service.ClientServiceModel;

import java.util.Set;

public interface ClientService {
    boolean addClient(ClientServiceModel clientServiceModel);
    
    Set<ClientServiceModel> allClients();
}
