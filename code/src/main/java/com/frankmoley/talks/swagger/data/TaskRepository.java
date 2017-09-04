package com.frankmoley.talks.swagger.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Frank P. Moley III.
 */
@Repository
public interface TaskRepository extends CrudRepository<TaskEntity, Long>{
    List<TaskEntity> findByPersonId(long personId);
}
