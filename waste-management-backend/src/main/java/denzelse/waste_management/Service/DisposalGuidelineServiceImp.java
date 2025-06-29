package denzelse.waste_management.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import denzelse.waste_management.DTOs.DisposalGuidelineDTO;
import denzelse.waste_management.Model.DisposalGuideline;
import denzelse.waste_management.Repository.DisposalGuidelineRepository;
import denzelse.waste_management.Service.interfaces.DisposalGuidelineService;


/**
 * Implementation of the DisposalGuidelineService interface for managing disposal guidelines 
 * in the Waste Management Spring Boot application. This class contains the business logic 
 * for retrieving, creating, updating, and deleting disposal guidelines.
 */

@Service
public class DisposalGuidelineServiceImp implements DisposalGuidelineService {
    
    @Autowired
    private DisposalGuidelineRepository repository;
    
    @Autowired
    private ModelMapper modelMapper;

    public List<DisposalGuidelineDTO> getAllGuidelines(){
        List<DisposalGuideline> guidelines = repository.findAll();
        
        return guidelines.stream()
                    .map((guideline) -> modelMapper
                    .map(guideline, DisposalGuidelineDTO.class))
                    .collect(Collectors.toList());
    }

    @Override
    public DisposalGuidelineDTO getGuidelineById(Long id) {
        DisposalGuideline guideline = repository.findById(id)
                        .orElseThrow(() -> new theNotFoundException("category", "id", id)); //plan for exception
        
        return modelMapper.map(guideline, DisposalGuidelineDTO.class);
    }

    @Override
    public DisposalGuidelineDTO addGuideline(DisposalGuidelineDTO disposalGuidelinedDto) {
        DisposalGuideline guideline = modelMapper
                                        .map(disposalGuidelinedDto, DisposalGuideline.class);
        DisposalGuideline guidelineSaved = repository.save(guideline);
        return modelMapper.map(guidelineSaved, DisposalGuidelineDTO.class);
    }

    @Override
    public DisposalGuidelineDTO updateGuideline(Long id, 
                            DisposalGuidelineDTO disposalGuidelinedDto) {
        
        DisposalGuideline guideline = repository.findById(id)
        .orElseThrow(() -> new theNotFoundException("category", "id", id));
        
        guideline.setDescription(disposalGuidelinedDto.getDescription());
        guideline.setName(disposalGuidelinedDto.getName());
        guideline.setId(id);

        DisposalGuideline guidelineUpdated = repository.save(guideline);

        return modelMapper.map(guidelineUpdated, DisposalGuidelineDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        DisposalGuideline guideline = repository.findById(id)
        .orElseThrow(() -> new theNotFoundException("category", "id", id));

        repository.delete(guideline);
    }

}
