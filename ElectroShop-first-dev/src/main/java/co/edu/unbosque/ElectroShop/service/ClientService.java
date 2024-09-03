package co.edu.unbosque.ElectroShop.service;

import co.edu.unbosque.ElectroShop.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.ElectroShop.repository.ClientRepository;

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
	public boolean saveClient(Client client) {
		try {
			clientRepository.save(client);
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
	public Client getClient(long id) {
		if (clientRepository.findById(id).isPresent()) {
			return clientRepository.findById(id).get();
		}
		return null;
	}

	/**
	 * Deletes a client from the database by its ID.
	 *
	 * @param  id  the ID of the client to be deleted
	 * @return     true if the client was deleted successfully, false otherwise
	 */
	public boolean deleteClient(long id) {
		try {
			clientRepository.deleteById(id);
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * Updates a client in the database.
	 *
	 * @param  client  the client to be updated
	 * @return        true if the client was updated successfully, false otherwise
	 */
	public boolean updateClient(Client client) {
		try {
			clientRepository.save(client);
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * Saves multiple clients to the database.
	 *
	 * @param  clients  the list of clients to be saved
	 * @return          true if all clients were saved successfully, false otherwise
	 */
	public boolean saveAll(List<Client> clients) {
		try {
			clientRepository.saveAll(clients);
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}

}
