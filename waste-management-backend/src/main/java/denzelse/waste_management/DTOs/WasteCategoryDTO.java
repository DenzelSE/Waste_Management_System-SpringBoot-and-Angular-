package denzelse.waste_management.DTOs;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import denzelse.waste_management.Model.RecyclingTip;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for representing waste categories in the Waste Management 
 * Spring Boot application. This class is used to transfer data between layers of the application.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WasteCategoryDTO {
    private Long id;
    private String name;
    private String description;

    @JsonManagedReference
    private List<DisposalGuidelineDTO> guidelines;
    @JsonManagedReference
    private List<RecyclingTip> recyclingTips;

    
}