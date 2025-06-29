package denzelse.waste_management.DTOs;

import com.fasterxml.jackson.annotation.JsonBackReference;

import denzelse.waste_management.Model.WasteCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for representing recycling tips in the Waste Management 
 * Spring Boot application. This class is used to transfer data between layers of the application.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecyclingTipDTO {
    private Long id;
    private String Tip;
    
    @JsonBackReference
    private WasteCategory wasteCategory;
    
}