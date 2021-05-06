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

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Trip")
public class Trip {

	@Id
	@GeneratedValue
	private long id;
	
	@NonNull
	private Vehicle vehicleType;

	@NonNull
	private double length;

	@NonNull
	private Timestamp timestamp;
	
}
