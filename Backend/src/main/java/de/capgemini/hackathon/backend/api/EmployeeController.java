package de.capgemini.hackathon.backend.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.capgemini.hackathon.backend.data.Employee;
import de.capgemini.hackathon.backend.data.EmployeeRepository;
import de.capgemini.hackathon.backend.data.Tree;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;

@RestController
@RequestMapping(path = "/employee", produces = "application/json")
public class EmployeeController {
    
	@Autowired
	EmployeeRepository er;
	
	@Operation(summary = "get trees planted by employee", 
			description="given the id of an employee this method returns the number of trees the employee has planted.")
    @GetMapping(value = "getTreeCount/{id}")
    public ResponseEntity<Integer> getTreeCount(@PathVariable("id") Long id) {
        //TODO implement fetch from db
		Optional<Employee> oE = er.findById(id);
		if(oE.isEmpty()){
			return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
		}
        int treesPlanted = oE.get().getPlantedTrees().size();
        return new ResponseEntity<Integer>(treesPlanted, HttpStatus.OK);
    }

	@Operation(summary = "icrease the number of trees planted by an employe", 
			description="given the id of an employee and a diff, this method updates the number of trees the employee has planted.")
    @PostMapping(value = "/{id}")
    public ResponseEntity<Void> addTree(@PathVariable("id") Long id, 
    		@io.swagger.v3.oas.annotations.parameters.RequestBody(
    				content = @Content(examples = {
    						@ExampleObject(value="0")}))
    		@RequestBody Tree tree) {
		
		Optional<Employee> oE = er.findById(id);
		if(oE.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		Employee e = oE.get();
		e.getPlantedTrees().add(tree);
		er.save(e);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
