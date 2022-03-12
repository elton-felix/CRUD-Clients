package com.personalproject.crudclients.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.personalproject.crudclients.dto.ClientDTO;
import com.personalproject.crudclients.entities.Client;
import com.personalproject.crudclients.repositories.ClientRepository;
import com.personalproject.crudclients.services.exeptions.ResourceNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> list = repository.findAll(pageRequest);
		
		return list.map(x -> new ClientDTO(x));
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findByid(Long id) {
		
		Optional<Client> client = repository.findById(id);
		
		Client entity = client.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		
		return new ClientDTO(entity);
	}

}
