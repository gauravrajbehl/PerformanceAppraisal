package org.app.perf.service;

import org.app.perf.domain.CompetencyType;

/**
 * Created by gauravbehl on 19/5/17.
 */
public interface CompentencyTypeService {

    public CompetencyType findByTitle(String title);

    public void save(CompetencyType competencyType);

}
