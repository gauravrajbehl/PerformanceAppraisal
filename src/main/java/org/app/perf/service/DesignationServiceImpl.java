package org.app.perf.service;

import lombok.Data;
import org.app.perf.domain.Designation;
import org.app.perf.repository.DesignationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gauravbehl on 19/5/17.
 */

@Service
@Data
public class DesignationServiceImpl implements DesignationService {


    @Autowired
    private DesignationRepository designationRepository;

    @Override
    public Designation findByTitle(String title) {
        return designationRepository.findByTitle(title);
    }
}
