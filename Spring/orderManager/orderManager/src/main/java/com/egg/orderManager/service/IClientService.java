package com.egg.orderManager.service;

import com.egg.orderManager.model.dto.ClientDTO;

import java.util.List;

public interface IClientService {

    public ClientDTO createClient(ClientDTO clientDTO) throws Exception;
    public List<ClientDTO> getAllClients() throws Exception;
    public ClientDTO getClientById(Long id) throws Exception;
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) throws Exception;

}
