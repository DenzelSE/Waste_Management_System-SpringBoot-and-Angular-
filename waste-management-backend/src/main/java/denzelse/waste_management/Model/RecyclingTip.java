package denzelse.waste_management.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class representing a recycling tips in the Waste Management Spring Boot application. 
 * This class is mapped to the "Recycling_Tips" table in the database and defines the attributes 
 * and relationships of a recycling tips.
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Recycling_Tips")
public class RecyclingTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotBlank
    private String Tip;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "category_id", nullable = false)
    private WasteCategory wasteCategory;
    
}