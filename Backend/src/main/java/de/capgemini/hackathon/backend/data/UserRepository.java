package de.capgemini.hackathon.backend.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

//@RepositoryRestResource(collectionResourceRel = "employee", path = "raw-employees")
public interface UserRepository extends CrudRepository<User, Long> {
    public Optional<User> findUserByGoogleID(String googleID);
}
