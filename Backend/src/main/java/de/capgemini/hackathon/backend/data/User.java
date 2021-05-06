package de.capgemini.hackathon.backend.data;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "User")
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	
	@NonNull
	private String nameOrEmail;

	@NonNull
	private String googleID;

	private double co2Total;
	
	@NonNull
	@OneToMany(cascade=CascadeType.ALL)
	private List<Trip> trips;

	public void calculateTotalCo2(){
		double sum = 0;
		for (Trip t:
			 trips) {
			sum += t.getVehicleType().co2 * t.getLength();
		}
		co2Total = sum;
	}
}
