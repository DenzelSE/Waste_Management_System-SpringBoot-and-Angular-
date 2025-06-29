package denzelse.waste_management.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import denzelse.waste_management.DTOs.WasteCategoryDTO;
import denzelse.waste_management.Model.WasteCategory;
import denzelse.waste_management.Repository.WasteCategoryRepository;
import denzelse.waste_management.Service.interfaces.WasteCategoryService;


/**
 * Implementation of the WasteCategotyService interface for managing disposal guidelines 
 * in the Waste Management Spring Boot application. This class contains the business logic 
 * for retrieving, creating, updating, and deleting disposal guidelines.
 */

@Service
public class WasteCategoryServiceImp implements WasteCategoryService{

    @Autowired
    private WasteCategoryRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    
    @Override
    public List<WasteCategoryDTO> getAllcategories(){
        List<WasteCategory> categories = repository.findAll();
        
        return categories.stream()
                        .map((category) -> modelMapper
                        .map(category, WasteCategoryDTO.class))
                        .collect(Collectors.toList());
    }

  
    @Override
    public WasteCategoryDTO getCategoryById(Long id){

        WasteCategory category = repository.findById(id)
                    .orElseThrow(() -> new theNotFoundException("Category", "id", id));
        return modelMapper.map(category, WasteCategoryDTO.class);
    }

    @Override
    public WasteCategoryDTO addCategory(WasteCategoryDTO wasteCategoryDto) {
        WasteCategory category = modelMapper.map(wasteCategoryDto, WasteCategory.class);
        WasteCategory categorySaved = repository.save(category);
        return modelMapper.map(categorySaved, WasteCategoryDTO.class);
    }

    @Override
    public WasteCategoryDTO updateCategory(Long id,WasteCategoryDTO wasteCategoryDto) {
        WasteCategory category = repository.findById(id)
        .orElseThrow(() -> new theNotFoundException("Category", "id", id));

        category.setDescription(wasteCategoryDto.getDescription());
        category.setName(wasteCategoryDto.getName());
        category.setId(id);

        WasteCategory categoryUpdated = repository.save(category);
        return modelMapper.map(categoryUpdated, WasteCategoryDTO.class);
        }

    @Override
    public void deleteById(Long id) {
        WasteCategory category = repository.findById(id)
        .orElseThrow(() -> new theNotFoundException("Category", "id", id));
        repository.delete(category);
    }

}