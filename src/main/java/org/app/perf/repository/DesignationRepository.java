package org.app.perf.repository;

import org.app.perf.domain.Designation;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by gauravbehl on 16/5/17.
 */
public interface DesignationRepository extends CrudRepository<Designation, Long> {

    public Designation findByTitle(String title);

}
