package de.capgemini.hackathon.backend.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "tree", path = "raw-trees")
public interface TreeRepository extends CrudRepository<Tree, Long> {

}
