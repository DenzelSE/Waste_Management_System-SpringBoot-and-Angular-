package denzelse.waste_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import denzelse.waste_management.Model.WasteCategory;


/**
 * 
 * Repository interface for performing CRUD operations on the WasteCategory entity 
 * in the Waste Management Spring Boot application. This interface extends the JpaRepository, 
 * providing pre-defined methods for interacting with the database.
 * 
 */

@Repository
public interface WasteCategoryRepository extends JpaRepository<WasteCategory,Long>{
    
}
