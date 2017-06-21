package org.app.perf.service;

import org.app.perf.domain.CompetencyType;
import org.app.perf.dto.CompetencyTypeDTO;
import org.app.perf.exception.DataNotFoundException;

import java.util.List;

/**
 * Created by gauravbehl on 19/5/17.
 */
public interface CompetencyTypeService {

    public CompetencyTypeDTO findByTitle(String title) throws DataNotFoundException;

    public CompetencyTypeDTO findById(Long id) throws DataNotFoundException;

    public List<CompetencyTypeDTO> findAll() throws DataNotFoundException;

    public void save(CompetencyTypeDTO competencyTypeDTO);

    boolean exists(CompetencyTypeDTO competencyTypeDTO);
}
