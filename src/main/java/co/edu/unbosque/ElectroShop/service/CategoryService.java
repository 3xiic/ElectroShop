package co.edu.unbosque.ElectroShop.service;

import co.edu.unbosque.ElectroShop.model.Category;
import co.edu.unbosque.ElectroShop.model.CategoryDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.ElectroShop.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public CategoryService() {
		
	}

	/**
	 * Saves a category to the database.
	 *
	 * @param  category  the category to be saved
	 * @return          true if the category is saved successfully, false otherwise
	 */
	public boolean saveCategory(CategoryDTO categoryDTO) {
		try {
			categoryRepository.save(DataMapper.categoryDTOToCategory(categoryDTO));
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * Retrieves a category from the database by its ID.
	 *
	 * @param  id  the ID of the category to be retrieved
	 * @return     the category with the specified ID, or null if not found
	 */
	public CategoryDTO getCategory(long id) {
		if (categoryRepository.findById(id).isPresent()) {
			return DataMapper.categoryToCategoryDTO(categoryRepository.findById(id).get());
		}
		return null;
	}


	/**
	 * Saves multiple categories to the database.
	 *
	 * @param  categories  the list of categories to be saved
	 * @return          true if all categories are saved successfully, false otherwise
	 */
	public boolean saveAll(List<CategoryDTO> categories) {
		try {
			for (CategoryDTO categoryDTO : categories) {
				categoryRepository.save(DataMapper.categoryDTOToCategory(categoryDTO));
			}
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public List<CategoryDTO> getAllCategories(){
		Iterable<Category> categories = categoryRepository.findAll();
		List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
		for (Category category : categories) {
			categoryDTOs.add(DataMapper.categoryToCategoryDTO(category));
		}
		return categoryDTOs;
	}
}
