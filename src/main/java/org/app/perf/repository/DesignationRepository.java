package org.app.perf.repository;

import org.app.perf.domain.Designation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gauravbehl on 16/5/17.
 */
@Repository
public interface DesignationRepository extends CrudRepository<Designation, Long> {

    //@Query("SELECT distinct c FROM Category c LEFT JOIN FETCH c.serviceDetails")

    @Query("SELECT d FROM Designation d LEFT JOIN FETCH d.competencies LEFT JOIN FETCH d.responsibilities  where d.title =  ?1")
    public Designation findByTitle(String title);

}
