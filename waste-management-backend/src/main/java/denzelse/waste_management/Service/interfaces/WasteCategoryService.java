package denzelse.waste_management.Service.interfaces;

import java.util.List;

import denzelse.waste_management.DTOs.WasteCategoryDTO;


/**
 * Service interface for managing waste category in the Waste Management Spring Boot application.
 * This interface defines the contract for the operations that can be performed on 
 * DisposalGuidelineDTO objects, including retrieval, creation, updating, and deletion.
 */


public interface WasteCategoryService {
    public List<WasteCategoryDTO> getAllcategories();
    public WasteCategoryDTO getCategoryById(Long id);
    public WasteCategoryDTO addCategory(WasteCategoryDTO wasteCategoryDto);
    public WasteCategoryDTO updateCategory(Long id,WasteCategoryDTO wasteCategoryDto);
    void deleteById(Long id);

}