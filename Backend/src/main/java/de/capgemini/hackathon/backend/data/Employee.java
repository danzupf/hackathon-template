package de.capgemini.hackathon.backend.data;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Employees")
public class Employee {
	
	@Id
	@GeneratedValue
	private long id;
	
	@NonNull
	private String name;
	
	@NonNull
	@OneToMany(cascade=CascadeType.ALL)
	private List<Tree> plantedTrees;

}
