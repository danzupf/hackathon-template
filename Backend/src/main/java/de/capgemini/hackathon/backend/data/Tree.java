package de.capgemini.hackathon.backend.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "PlantedTrees")
public class Tree {

	@Id
	@GeneratedValue
	private long id;
	
	@NonNull
	private String type;
	
	@NonNull
	private double co2CapturePerSecond;
	
}
