package org.app.perf.service;

import org.app.perf.domain.CompetencyType;

import java.util.List;

/**
 * Created by gauravbehl on 19/5/17.
 */
public interface CompetencyTypeService {

    public CompetencyType findByTitle(String title);

    public CompetencyType findById(Long id);

    public List<CompetencyType> findAll();

    public void save(CompetencyType competencyType);

}
