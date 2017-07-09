package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.henallux.dataAccess.entity.ClientEntity;
import com.spring.henallux.dataAccess.repository.ClientRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Client;

@Service
@Transactional
public class ClientDAO {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ProviderConverter providerConverter;

	
	public Client save(Client client){
		ClientEntity clientEntity = providerConverter.clientModelToClientEntity(client);
		
		clientEntity = clientRepository.save(clientEntity);

		return providerConverter.clientEntitytoClientModel(clientEntity);
	}
	
	public ArrayList<Client> getAllClient(){
		List<ClientEntity> clientEntities = clientRepository.findAll();
		ArrayList<Client> clients = new ArrayList<>();
		for(ClientEntity entity : clientEntities){
			Client client = providerConverter.clientEntitytoClientModel(entity);
			clients.add(client);
		}
		return clients;
	}
	
	public Client findByEmail(String email){
		ClientEntity clientEntity = clientRepository.findByEmail(email);
		if(clientEntity == null) return null;
		Client client = providerConverter.clientEntitytoClientModel(clientEntity);
		return client;
	}
	

}
