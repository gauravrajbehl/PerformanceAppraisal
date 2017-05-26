package org.app.perf.service;

import lombok.Data;
import org.app.perf.domain.CompetencyType;
import org.app.perf.dto.CompetencyTypeDTO;
import org.app.perf.exception.DataNotFoundException;
import org.app.perf.repository.CompetencyTypeRepository;
import org.modelmapper.ModelMapper;
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
    private ModelMapper mapper;

    @Autowired
    private CompetencyTypeRepository competencyTypeRepository;

    @Override
    public CompetencyTypeDTO findByTitle(String title) {
        CompetencyType competencyType = competencyTypeRepository.findByTitle(title);
        CompetencyTypeDTO dto = mapper.map(competencyType, CompetencyTypeDTO.class);
        return dto;
    }

    @Override
    public CompetencyType findById(Long id) throws DataNotFoundException {

        CompetencyType competencyType = competencyTypeRepository.findOne(id);

        if (competencyType == null) {
            throw new DataNotFoundException("CompetencyType not found. Id: " + id);
        }


        return competencyType;
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
