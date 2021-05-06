package de.capgemini.hackathon.backend.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(collectionResourceRel = "trips", path = "raw-trips")
public interface TripsRepository extends CrudRepository<Trip, Long> {

}
