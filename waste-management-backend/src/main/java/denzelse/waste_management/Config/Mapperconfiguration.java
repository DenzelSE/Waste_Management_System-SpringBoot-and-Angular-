package denzelse.waste_management.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;
/**
 * Configuration class for setting up the ModelMapper bean in the Waste Management 
 * Spring Boot application. This class enables the application to use ModelMapper for 
 * object mapping and transformation between DTOs and entities
 */

 @Configuration
 public class Mapperconfiguration {
     @Bean
     public ModelMapper modelMapper() {
         return new ModelMapper();
     }
 
 }