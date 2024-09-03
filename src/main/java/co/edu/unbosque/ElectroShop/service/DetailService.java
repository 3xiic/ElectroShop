package co.edu.unbosque.ElectroShop.service;

import co.edu.unbosque.ElectroShop.model.Detail;
import co.edu.unbosque.ElectroShop.model.DetailDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import co.edu.unbosque.ElectroShop.repository.DetailRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetailService {

	@Autowired
	private DetailRepository detailRepository;
	
	public DetailService() {
		
	}
	/**
	 * Saves the provided details to the database.
	 *
	 * @param  details  the details object to be saved
	 * @return          true if the details were saved successfully, false otherwise
	 */
	public boolean saveDetails(DetailDTO detailDTO) {
		try {
			detailRepository.save(DataMapper.detailDTOToDetail(detailDTO));
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
	public DetailDTO getDetails(long id) {
		if (detailRepository.findById(id).isPresent()) {
			return DataMapper.detailToDetailDTO(detailRepository.findById(id).get());
		}
		return null;
	}


	/**
	 * Saves multiple details to the database.
	 *
	 * @param  details  the list of details objects to be saved
	 * @return          true if the details were saved successfully, false otherwise
	 */
	public boolean saveAll(List<DetailDTO> details) {
		try {
			for (DetailDTO detailDTO: details) {
				detailRepository.save(DataMapper.detailDTOToDetail(detailDTO));
			}
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}
	public List<DetailDTO> getAllDetails(){
		Iterable<Detail> details = detailRepository.findAll();
		List<DetailDTO> detailDTOs = new ArrayList<DetailDTO>();
		for (Detail detail : details) {
			detailDTOs.add(DataMapper.detailToDetailDTO(detail));
		}
		return detailDTOs;
	}
}
