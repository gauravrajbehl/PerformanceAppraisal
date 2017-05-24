package org.app.perf.service;

import org.app.perf.domain.Designation;

/**
 * Created by gauravbehl on 19/5/17.
 */
public interface DesignationService {

    public Designation findByTitle(String title);

    public void save(Designation designation);

    public void delete(Designation designation);
}
