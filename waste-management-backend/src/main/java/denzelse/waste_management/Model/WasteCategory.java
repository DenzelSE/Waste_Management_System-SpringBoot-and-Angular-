package denzelse.waste_management.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class representing a waste category in the Waste Management Spring Boot application. 
 * This class is mapped to the "Waste_Categories" table in the database and defines the attributes 
 * and relationships of a waste categories.
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Waste_Categories")
public class WasteCategory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false, unique = true)
    private String name;

    @NotBlank
    private String description;
    
    @JsonManagedReference
    @OneToMany(mappedBy = "wasteCategory", cascade = CascadeType.ALL)
    private List<RecyclingTip> recyclingTips = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "wasteCategory",cascade = CascadeType.ALL)
    private List<DisposalGuideline> disposalGuidelines = new ArrayList<>();
}
