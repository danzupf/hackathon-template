package de.capgemini.hackathon.backend.api;

import java.sql.Timestamp;
import java.util.*;

import de.capgemini.hackathon.backend.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;

@RestController
@RequestMapping(path = "/user", produces = "application/json")
public class UserController {
    
	@Autowired
	UserRepository ur;

	@Operation(summary = "add an user", description="")
	@PostMapping(value = "add/{googleID}/{nameOrEmail}")
	public ResponseEntity<Void> addUser(@PathVariable("googleID") String googleID, @PathVariable("nameOrEmail") String nameOrEmail) {
		User user = new User(nameOrEmail, googleID, new LinkedList<>());
		ur.save(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Operation(summary = "get user", description="")
	@GetMapping(value = "{googleID}")
	public ResponseEntity<User> getUser(@PathVariable("googleID") String googleID) {
		Optional<User> oU = ur.findUserByGoogleID(googleID);
		if(oU.isEmpty()){
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<User>(oU.get(),HttpStatus.OK);
	}

	@Operation(summary = "get all user", description="")
	@GetMapping(value = "all")
	public ResponseEntity<Iterable<User>> getAllUser() {
		Iterable<User> e = ur.findAll();
		return new ResponseEntity<Iterable<User>>(e, HttpStatus.OK);
	}

	@Operation(summary = "delete user", description="")
	@DeleteMapping(value = "{googleID}")
	public ResponseEntity<Void> deleteUser(@PathVariable("googleID") String googleID) {
		Optional<User> oU = ur.findUserByGoogleID(googleID);
		if(oU.isEmpty()){
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		ur.delete(oU.get());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Operation(summary = "get trips count", description="")
    @GetMapping(value = "getTripsCount/{googleID}")
    public ResponseEntity<Integer> getTripsCount(@PathVariable("googleID") String googleID) {
		Optional<User> oU = ur.findUserByGoogleID(googleID);
		if(oU.isEmpty()){
			return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
		}
        int trips = oU.get().getTrips().size();
        return new ResponseEntity<Integer>(trips, HttpStatus.OK);
    }

	@Operation(summary = "add trip", description="")
	@GetMapping(value = "addTrip/{googleID}/{type}/{length}")
	public ResponseEntity<Void> addTrip(@PathVariable("googleID") String googleID, @PathVariable("type")Vehicle type, @PathVariable("length") double length) {
		Optional<User> oU = ur.findUserByGoogleID(googleID);
		if(oU.isEmpty()){
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		Trip t = new Trip(type, length, new Timestamp(System.currentTimeMillis()));
		User u = oU.get();
		u.getTrips().add(t);
		u.setCo2Total(u.getCo2Total() + t.getVehicleType().co2 * t.getLength());
		ur.save(u);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	/*
	@Operation(summary = "icrease the number of trees planted by an employe", 
			description="given the id of an employee and a diff, this method updates the number of trees the employee has planted.")
    @PostMapping(value = "/{id}")
    public ResponseEntity<Void> addTree(@PathVariable("id") Long id, 
    		@io.swagger.v3.oas.annotations.parameters.RequestBody(
    				content = @Content(examples = {
    						@ExampleObject(value="0")}))
    		@RequestBody Trip trip) {
		
		Optional<User> oE = ur.findById(id);
		if(oE.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		User e = oE.get();
		//e.getPlantedTrees().add(trips);
		ur.save(e);
        return new ResponseEntity<>(HttpStatus.OK);
    }
*/
}
