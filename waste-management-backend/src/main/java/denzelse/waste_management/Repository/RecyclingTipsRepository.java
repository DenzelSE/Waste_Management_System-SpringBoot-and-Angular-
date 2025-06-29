package denzelse.waste_management.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import denzelse.waste_management.Model.RecyclingTip;


/**
 * 
 * Repository interface for performing CRUD operations on the RecyclingTips entity 
 * in the Waste Management Spring Boot application. This interface extends the JpaRepository, 
 * providing pre-defined methods for interacting with the database.
 * 
 */

@Repository
public interface RecyclingTipsRepository extends JpaRepository<RecyclingTip, Long>{
    
}
