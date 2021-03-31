package de.capgemini.hackathon.backend;

import java.util.List;

import javax.annotation.PostConstruct;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.capgemini.hackathon.backend.data.Employee;
import de.capgemini.hackathon.backend.data.EmployeeRepository;
import de.capgemini.hackathon.backend.data.Tree;
import de.capgemini.hackathon.backend.data.TreeRepository;

@SpringBootApplication
public class BackendApplication {

	@Autowired
	EmployeeRepository er;
	
	@Autowired
	TreeRepository tr;
	
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	
	@PostConstruct
	public void setupTables() {
		//in the real world you would of course initialize from an sql file

		Employee alice = new Employee("alice", List.of(
				new Tree("Oak", 6.7), 
				new Tree("Limetree", 1.7)));
		er.save(alice);
	}

}
