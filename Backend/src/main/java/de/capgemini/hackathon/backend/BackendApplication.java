package de.capgemini.hackathon.backend;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.PostConstruct;

import de.capgemini.hackathon.backend.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	@Autowired
	UserRepository er;
	
	@Autowired
	TripsRepository tr;
	
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	
	@PostConstruct
	public void setupTables() {
		//in the real world you would of course initialize from an sql file

		User alice = new User("alice", "google" , List.of(
				new Trip(Vehicle.Bahn_Fernverkehr, 6.7, new Timestamp(System.currentTimeMillis())),
				new Trip(Vehicle.Bahn_Fernverkehr,  6.7,new Timestamp(System.currentTimeMillis())),
				new Trip(Vehicle.Bahn_Fernverkehr,  6.7,new Timestamp(System.currentTimeMillis()))));
		alice.calculateTotalCo2();
		er.save(alice);
		User bob = new User("bob", "google", List.of(
				new Trip(Vehicle.Bahn_Fernverkehr,  6.7,new Timestamp(System.currentTimeMillis())),
				new Trip(Vehicle.Bahn_Fernverkehr,  6.7,new Timestamp(System.currentTimeMillis()))));
		bob.calculateTotalCo2();
		er.save(bob);
	}

}
