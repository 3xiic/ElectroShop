package co.edu.unbosque.ElectroShop.service;

import co.edu.unbosque.ElectroShop.model.Detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.ElectroShop.repository.DetailsRepository;

import java.util.List;

@Service
public class DetailsService {

	@Autowired
	private DetailsRepository detailsRepository;
	
	public DetailsService() {
		
	}
	/**
	 * Saves the provided details to the database.
	 *
	 * @param  details  the details object to be saved
	 * @return          true if the details were saved successfully, false otherwise
	 */
	public boolean saveDetails(Detail details) {
		try {
			detailsRepository.save(details);
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * Retrieves a Details object from the database by its ID.
	 *
	 * @param  id  the ID of the Details object to be retrieved
	 * @return     the Details object if found, null otherwise
	 */
	public Detail getDetails(long id) {
		if (detailsRepository.findById(id).isPresent()) {
			return detailsRepository.findById(id).get();
		}
		return null;
	}

	/**
	 * Deletes a Details object from the database by its ID.
	 *
	 * @param  id  the ID of the Details object to be deleted
	 * @return     true if the Details object was deleted successfully, false otherwise
	 */
	public boolean deleteDetails(long id) {
		try {
			detailsRepository.deleteById(id);
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * Updates the provided details in the database.
	 *
	 * @param  details  the details object to be updated
	 * @return          true if the details were updated successfully, false otherwise
	 */
	public boolean updateDetails(Detail details) {
		try {
			detailsRepository.save(details);
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * Saves multiple details to the database.
	 *
	 * @param  details  the list of details objects to be saved
	 * @return          true if the details were saved successfully, false otherwise
	 */
	public boolean saveAll(List<Detail> details) {
		try {
			detailsRepository.saveAll(details);
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}
}
