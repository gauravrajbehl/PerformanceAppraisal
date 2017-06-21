package org.app.perf.service;

import lombok.Data;
import org.app.perf.domain.CompetencyType;
import org.app.perf.dto.CompetencyTypeDTO;
import org.app.perf.exception.DataNotFoundException;
import org.app.perf.repository.CompetencyTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
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
    public CompetencyTypeDTO findByTitle(String title) throws DataNotFoundException{
        CompetencyType competencyType = competencyTypeRepository.findByTitle(title);

        if (competencyType == null) {
            throw new DataNotFoundException("CompetencyType not found. title: " + title);
        }

        CompetencyTypeDTO dto = mapper.map(competencyType, CompetencyTypeDTO.class);
        return dto;
    }

    @Override
    public CompetencyTypeDTO findById(Long id) throws DataNotFoundException {

        CompetencyType competencyType = competencyTypeRepository.findOne(id);

        if (competencyType == null) {
            throw new DataNotFoundException("CompetencyType not found. Id: " + id);
        }

        return mapper.map(competencyType,CompetencyTypeDTO.class);
    }

    @Override
    public List<CompetencyTypeDTO> findAll() throws DataNotFoundException{

        List<CompetencyType> competencyTypeList = (List)competencyTypeRepository.findAll();

        if (competencyTypeList.size() == 0) {
            throw new DataNotFoundException("Competency Types not found");
        }

        List<CompetencyTypeDTO> competencyTypeDTOList = new ArrayList<CompetencyTypeDTO>();
        Iterator<CompetencyType> competencyTypeIterator = competencyTypeRepository.findAll().iterator();

        while (competencyTypeIterator.hasNext()) {
            competencyTypeDTOList.add(mapper.map(competencyTypeIterator.next(), CompetencyTypeDTO.class));
        }

        return competencyTypeDTOList;
    }

    @Override
    public void save(CompetencyTypeDTO competencyTypeDTO) {

        CompetencyType c = mapper.map(competencyTypeDTO, CompetencyType.class);
        competencyTypeRepository.save(c);
    }

    @Override
    public boolean exists(CompetencyTypeDTO competencyTypeDTO) {

        if (competencyTypeRepository.findByTitle(competencyTypeDTO.getTitle()) == null) {
            return false;
        }

        return true;
    }

}
