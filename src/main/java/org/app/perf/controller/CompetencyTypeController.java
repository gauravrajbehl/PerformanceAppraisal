package org.app.perf.controller;

import lombok.Data;
import org.app.perf.domain.CompetencyType;
import org.app.perf.dto.CompetencyTypeDTO;
import org.app.perf.exception.DataNotFoundException;
import org.app.perf.service.CompetencyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by gauravbehl on 24/5/17.
 */
@Controller
@Data
public class CompetencyTypeController {

    @Autowired
    private CompetencyTypeService competencyTypeService;

    /**
     *
     * @param id
     * @return
     * @throws DataNotFoundException
     */
    @RequestMapping(value = "/competencyType/{id}", method = RequestMethod.GET)
    public ResponseEntity<CompetencyTypeDTO> getCompetencyTypeById(@PathVariable("id") Long id) throws DataNotFoundException {

        CompetencyTypeDTO competencyType = competencyTypeService.findById(id);
        return new ResponseEntity<CompetencyTypeDTO>(competencyType, HttpStatus.OK);
    }


    /**
     *
     * @return
     */
    @RequestMapping(value = "/competencyTypes", method = RequestMethod.GET)
    public ResponseEntity<List<CompetencyTypeDTO>> getAllCompetencyTypes() throws DataNotFoundException {
        return new ResponseEntity<List<CompetencyTypeDTO>>(competencyTypeService.findAll(),HttpStatus.OK );
    }

    /**
     *
     * @param title
     * @return
     * @throws DataNotFoundException
     */
    @RequestMapping(value = "/competencyType/title/{title}", method = RequestMethod.GET)
    public ResponseEntity<CompetencyTypeDTO> getCompetencyByTitle(@PathVariable("title") String title) throws DataNotFoundException {

        CompetencyTypeDTO competencyTypeDTO = competencyTypeService.findByTitle(title);
        return new ResponseEntity<CompetencyTypeDTO>(competencyTypeDTO,HttpStatus.OK);

    }


    @RequestMapping(value = "/competencyType/create", method = RequestMethod.POST)
    public ResponseEntity<CompetencyTypeDTO> create(@RequestBody CompetencyTypeDTO competencyTypeDTO) {

        if(competencyTypeService.exists(competencyTypeDTO) == true) {
            return new ResponseEntity<CompetencyTypeDTO>(competencyTypeDTO,HttpStatus.CONFLICT);
        }

        competencyTypeService.save(competencyTypeDTO);
        return new ResponseEntity<CompetencyTypeDTO>(competencyTypeDTO, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/competencyType/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CompetencyTypeDTO> update(@PathVariable Long id,
                                                    @RequestBody CompetencyTypeDTO competencyTypeDTO) throws DataNotFoundException {

        CompetencyTypeDTO obj = competencyTypeService.findById(id);

        competencyTypeService.save(competencyTypeDTO);
        return new ResponseEntity<CompetencyTypeDTO>(competencyTypeDTO, HttpStatus.OK);
    }


}
