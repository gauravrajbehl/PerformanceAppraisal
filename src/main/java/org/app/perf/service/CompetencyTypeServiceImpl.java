package org.app.perf.service;

import lombok.Data;
import org.app.perf.domain.CompetencyType;
import org.app.perf.repository.CompetencyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gauravbehl on 19/5/17.
 */
@Service
@Data
public class CompetencyTypeServiceImpl implements CompetencyTypeService {

    @Autowired
    private CompetencyTypeRepository competencyTypeRepository;

    @Override
    public CompetencyType findByTitle(String title) {
        return competencyTypeRepository.findByTitle(title);
    }

    @Override
    public CompetencyType findById(Long id) {
        return competencyTypeRepository.findOne(id);
    }

    @Override
    public List<CompetencyType> findAll() {
        return (List<CompetencyType>) competencyTypeRepository.findAll();
    }

    @Override
    public void save(CompetencyType competencyType) {
        competencyTypeRepository.save(competencyType);
    }




}
