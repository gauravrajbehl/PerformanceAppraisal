package org.app.perf.service;

import org.app.perf.domain.CompetencyType;
import org.app.perf.dto.CompetencyTypeDTO;
import org.app.perf.exception.DataNotFoundException;

import java.util.List;

/**
 * Created by gauravbehl on 19/5/17.
 */
public interface CompetencyTypeService {

    public CompetencyTypeDTO findByTitle(String title);

    public CompetencyType findById(Long id) throws DataNotFoundException;

    public List<CompetencyType> findAll();

    public void save(CompetencyType competencyType);

}
