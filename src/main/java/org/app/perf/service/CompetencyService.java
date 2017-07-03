package org.app.perf.service;

import org.app.perf.domain.Competency;
import org.app.perf.dto.CompetencyDTO;
import org.app.perf.exception.DataNotFoundException;

import java.util.List;

/**
 * Created by gauravbehl on 19/5/17.
 */
public interface CompetencyService {

    public void save(CompetencyDTO competencyDTO);

    public void remove(CompetencyDTO competency);

    public CompetencyDTO findById(Long id) throws DataNotFoundException;

    List<CompetencyDTO> findAll();
}
