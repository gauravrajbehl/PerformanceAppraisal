package org.app.perf.repository;

import org.app.perf.domain.Responsibility;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gauravbehl on 11/5/17.
 */
@Repository
public interface ResponsibilityRepository extends CrudRepository<Responsibility, Long> {

    public Responsibility findByTitle(String title);

}
