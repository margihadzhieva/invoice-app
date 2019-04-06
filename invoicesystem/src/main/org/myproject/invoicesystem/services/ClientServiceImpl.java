package org.myproject.invoicesystem.services;

import org.modelmapper.ModelMapper;
import org.myproject.invoicesystem.entities.Client;
import org.myproject.invoicesystem.models.service.ClientServiceModel;
import org.myproject.invoicesystem.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ClientServiceImpl(ModelMapper modelMapper, ClientRepository clientRepository) {
        this.modelMapper = modelMapper;
        this.clientRepository = clientRepository;
    }

    @Override
    public boolean addClient(ClientServiceModel clientServiceModel) {
        Client clientEntity = this.modelMapper.map(clientServiceModel, Client.class);

        try {
            this.clientRepository.save(clientEntity);
        } catch (Exception ignored) {
            return false;
        }
        return true;
    }

    @Override
    public Set<ClientServiceModel> allClients() {
        return this.clientRepository
                .findAll()
                .stream()
                .map(x-> this.modelMapper.map(x, ClientServiceModel.class))
                .collect(Collectors.toSet());

    }

}
