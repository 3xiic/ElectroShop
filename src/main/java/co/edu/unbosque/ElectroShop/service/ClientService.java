package co.edu.unbosque.ElectroShop.service;

import co.edu.unbosque.ElectroShop.model.Client;
import co.edu.unbosque.ElectroShop.model.ClientDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import co.edu.unbosque.ElectroShop.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public ClientService() {
		
	}

	/**
	 * Saves a client to the database.
	 *
	 * @param  client  the client to be saved
	 * @return        true if the client was saved successfully, false otherwise
	 */
	public boolean saveClient(ClientDTO client) {
		try {
			clientRepository.save(DataMapper.clientDTOToClient(client));
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * Retrieves a Client object from the database by its ID.
	 *
	 * @param  id  the ID of the Client object to be retrieved
	 * @return     the Client object if found, null otherwise
	 */
	@Cacheable(value = "clientCache", key = "#id")
	public ClientDTO getClient(long id) {
		if (clientRepository.findById(id).isPresent()) {
			return DataMapper.clientToClientDTO(clientRepository.findById(id).get());
		}
		return null;
	}




	/**
	 * Saves multiple clients to the database.
	 *
	 * @param  clients  the list of clients to be saved
	 * @return          true if all clients were saved successfully, false otherwise
	 */
	public boolean saveAll(List<ClientDTO> clients) {
		try {
			for (ClientDTO clientDTO : clients) {
				clientRepository.save(DataMapper.clientDTOToClient(clientDTO));
			}
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Retrieves all clients from the database.
	 *
	 * @return a list of all clients in the database
	 */
	public List<ClientDTO> getAllClients(){
		Iterable<Client> clients = clientRepository.findAll();
		List<ClientDTO> clientDTOs = new ArrayList<>();
		for (Client client : clients) {
			clientDTOs.add(DataMapper.clientToClientDTO(client));
		}
		return clientDTOs;
	}

}
