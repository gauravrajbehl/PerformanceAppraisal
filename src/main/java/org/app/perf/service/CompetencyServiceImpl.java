package org.app.perf.service;

import lombok.Data;
import org.app.perf.domain.Competency;
import org.app.perf.dto.CompetencyDTO;
import org.app.perf.exception.DataNotFoundException;
import org.app.perf.repository.CompentencyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by gauravbehl on 19/5/17.
 */
@Service
@Data
public class CompetencyServiceImpl implements CompetencyService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CompentencyRepository compentencyRepository;


    @Override
    public void save(CompetencyDTO competencyDTO) {
        Competency competency = modelMapper.map(competencyDTO, Competency.class);
        compentencyRepository.save(competency);
        competencyDTO.setId(competency.getId());
    }

    @Override
    public void remove(CompetencyDTO competencyDTO) {

        Competency competency = modelMapper.map(competencyDTO,Competency.class);
        compentencyRepository.delete(competency);
        System.out.print(competency);
    }

    @Override
    public CompetencyDTO findById(Long id) throws DataNotFoundException {

        Competency competency = compentencyRepository.findOne(id);

        if (competency == null) {
            throw new DataNotFoundException("Competency Not found: " + id);
        }

        //modelMapper.map()
        return modelMapper.map(competency, CompetencyDTO.class);
    }

    @Override
    public List<CompetencyDTO> findAll() throws DataNotFoundException {

        List<Competency> list = (List)compentencyRepository.findAll();
        if (list.size() == 0) {
            throw new DataNotFoundException("Competencies not found");
        }

        List<CompetencyDTO> competencyDTOList = new ArrayList<CompetencyDTO>();

        Iterator<Competency> iterator = list.iterator();
        while(iterator.hasNext()) {
            competencyDTOList.add(modelMapper.map(iterator.next(),CompetencyDTO.class));
        }

        return competencyDTOList;
    }


}
