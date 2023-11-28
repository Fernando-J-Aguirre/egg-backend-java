package com.egg.orderManager.service.impl;

import com.egg.orderManager.model.dto.ClientDTO;
import com.egg.orderManager.model.entity.Client;
import com.egg.orderManager.repository.IClientRepository;
import com.egg.orderManager.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements IClientService {

    private final IClientRepository clientRepository;
    private final ModelMapper modelMapper;

    @Transactional
    @Override
    public ClientDTO createClient(ClientDTO clientDTO) throws Exception {
        if (Objects.nonNull(clientDTO)) {
            if (clientDTO.getName() == null || clientDTO.getName().trim().isEmpty())
                throw new IllegalArgumentException("El nombre no puede estar vacío");
            if (clientDTO.getEmail() == null || clientDTO.getEmail().trim().isEmpty())
                throw new IllegalArgumentException("El email no puede estar vacío");
            if (clientDTO.getPhone() == null) throw new IllegalArgumentException("El teléfono no puede estar vacío");
            Client client = modelMapper.map(clientDTO, Client.class);
            clientRepository.save(client);
            return clientDTO;
        } else {
            throw new Exception("No se pudo crear el cliente");
        }
//        return null;
    }

    @Override
    public List<ClientDTO> getAllClients() throws Exception {
        List<Client> clients = clientRepository.findAll();
        if(!clients.isEmpty()) {
            return clients.stream().map((client) -> modelMapper.map(client, ClientDTO.class)).toList();
        } else {
            throw new Exception("No se pudo obtener la lista de clientes");
        }
    }

    @Override
    public ClientDTO getClientById(Long id) throws Exception {
        Optional<Client> clientOpt = clientRepository.findById(id);
        if(clientOpt.isPresent()) {
            Client client = clientOpt.get();
            return modelMapper.map(client, ClientDTO.class);
        } else {
            throw new Exception("No se encuentra cliente con el id proporcionado");
        }
    }

    @Transactional
    @Override
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) throws Exception {
        Optional<Client> clientOpt = clientRepository.findById(id);
        if(clientOpt.isPresent()) {
            Client client = modelMapper.map(clientDTO, Client.class);
            client.setId(id);
            clientRepository.save(client);
            return clientDTO;
        } else {
            throw new Exception("No se pudo modificar porque no se encuentra el cliente con ese id");
        }
    }
}
