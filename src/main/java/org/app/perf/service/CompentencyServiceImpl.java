package org.app.perf.service;

import lombok.Data;
import org.app.perf.domain.Competency;
import org.app.perf.repository.CompentencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gauravbehl on 19/5/17.
 */
@Service
@Data
public class CompentencyServiceImpl implements CompetencyService {

    @Autowired
    private CompentencyRepository compentencyRepository;

    @Override
    public Competency findByTitle(String title) {
        return compentencyRepository.findByTitle(title);
    }

    @Override
    public void save(Competency competency) {
        compentencyRepository.save(competency);
    }

    @Override
    public void remove(Competency competency) {
        compentencyRepository.delete(competency);
    }


}
