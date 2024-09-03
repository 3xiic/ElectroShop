package co.edu.unbosque.ElectroShop.service;

import co.edu.unbosque.ElectroShop.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.ElectroShop.repository.CategoryRepository;

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
	public boolean saveCategory(Category category) {
		try {
			categoryRepository.save(category);
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
	public Category getCategory(long id) {
		if (categoryRepository.findById(id).isPresent()) {
			return categoryRepository.findById(id).get();
		}
		return null;
	}

	/**
	 * Deletes a category from the database by its ID.
	 *
	 * @param  id  the ID of the category to be deleted
	 * @return     true if the category is deleted successfully, false otherwise
	 */
	public boolean deleteCategory(long id) {
		try {
			categoryRepository.deleteById(id);
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * Updates a category in the database.
	 *
	 * @param  category  the category to be updated
	 * @return          true if the category is updated successfully, false otherwise
	 */
	public boolean updateCategory(Category category) {
		try {
			categoryRepository.save(category);
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * Saves multiple categories to the database.
	 *
	 * @param  categories  the list of categories to be saved
	 * @return          true if all categories are saved successfully, false otherwise
	 */
	public boolean saveAll(List<Category> categories) {
		try {
			categoryRepository.saveAll(categories);
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}
}
