package com.frankmoley.talks.swagger.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Frank P. Moley III.
 */
@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Long>{
}
