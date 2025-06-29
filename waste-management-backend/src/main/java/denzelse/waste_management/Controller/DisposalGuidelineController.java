package denzelse.waste_management.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller for managing diposal guidelines in the Waste Management Spring Boot application.
 * Handles incoming HTTP requests related to disposal guidelines, such as retrieving, adding, 
 * updating, and deleting.
 * 
 * Endpoints:
 *  - GET /api/categories
 *  - GET /api/categories/{id}
 *  - POST /api/categories
 *  - POST /api/categories/{id}
 *  - Delete /api/categories/{id}
 */

@RestController
@CrossOrigin
@RequestMapping("/api")
public class DisposalGuidelineController {
    
    @Autowired
    private DisposalGuidelineServiceImp service;

    @GetMapping("/guidelines")
    public ResponseEntity<List<DisposalGuidelineDTO>> getAllGuidelines(){
        return new ResponseEntity<>(service.getAllGuidelines(), HttpStatus.OK);
    }

    @GetMapping("/guidelines/{id}")
    public ResponseEntity<DisposalGuidelineDTO> getGuidelineById(@PathVariable long id){
        DisposalGuidelineDTO guidelineDto = service.getGuidelineById(id);

        if(guidelineDto != null){
            return new ResponseEntity<>(guidelineDto,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(guidelineDto, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/guidelines")
    public ResponseEntity<DisposalGuidelineDTO> addGuidline(
        @RequestBody DisposalGuidelineDTO disposalGuidelineDto){
            
            DisposalGuidelineDTO guidelineDTO = service
                                    .addGuideline(disposalGuidelineDto);
            return new ResponseEntity<>(service.addGuideline(guidelineDTO),HttpStatus.OK);
        }
    @PostMapping("/guidelines/{id}")
        public ResponseEntity<DisposalGuidelineDTO> updateGuideline(@PathVariable Long id, 
                        @RequestBody DisposalGuidelineDTO disposalGuidelinedDto){

            return new ResponseEntity<>(service.updateGuideline(id, disposalGuidelinedDto), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteGuideline(@PathVariable Long id){
        service.deleteById(id);
        return new ResponseEntity<>("successfully deleted", HttpStatus.OK);
    }
}