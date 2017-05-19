package org.app.perf.service;

import lombok.Data;
import org.app.perf.domain.Responsibility;
import org.app.perf.repository.ResponsibilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gauravbehl on 17/5/17.
 */

@Service
@Data
public class ResponsibilityServiceImpl implements ResponsibilityService {

    @Autowired
    private ResponsibilityRepository responsibilityRepository;

    @Override
    public Responsibility findResponsibilityByTitle(String title) {
        return responsibilityRepository.findByTitle(title);
    }

    @Override
    public Iterable<Responsibility> findAllResponsibilities() {
        return responsibilityRepository.findAll();
    }

    @Override
    public void saveResponsibility(Responsibility responsibility) {
        responsibilityRepository.save(responsibility);
    }

}
