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
 * Restful Controller class for <code>CompetencyType</code>
 *
 * @author gauravbehl
 * @version 1.0
 * @since   21-June-17
 */
@Controller
@Data
public class CompetencyTypeController {

    @Autowired
    private CompetencyTypeService competencyTypeService;

    /**
     * Rest method used for getting <code>CompetencyTypeDTO</code> by id
     *
     * @param id id of the <code>CompetencyTypeDTO</code>
     * @return returns <code>ResponseEntity</code> consisting found <code>CompetencyTypeDTO</code> record
     * @throws DataNotFoundException is thrown if <code>CompetencyTypeDTO</code> is not found
     */
    @RequestMapping(value = "/competencyType/{id}", method = RequestMethod.GET)
    public ResponseEntity<CompetencyTypeDTO> getCompetencyTypeById(@PathVariable("id") Long id) throws DataNotFoundException {

        CompetencyTypeDTO competencyType = competencyTypeService.findById(id);
        return new ResponseEntity<CompetencyTypeDTO>(competencyType, HttpStatus.OK);
    }

    /**
     * Rest method used for getting all of existing <code>CompetencyTypeDTO</code> data
     *
     * @return returns <code>ResponseEntity</code> consisting found <code>CompetencyTypeDTO</code> records
     */
    @RequestMapping(value = "/competencyTypes", method = RequestMethod.GET)
    public ResponseEntity<List<CompetencyTypeDTO>> getAllCompetencyTypes() throws DataNotFoundException {
        return new ResponseEntity<List<CompetencyTypeDTO>>(competencyTypeService.findAll(),HttpStatus.OK);
    }


    /**
     * Rest method to create new <code>CompetencyTypeDTO</code> record
     * @param competencyTypeDTO <code>RequestBody</code> consisting Json representation for new <code>CompetencyTypeDTO</code> record
     * @return returns <code>ResponseEntity</code> consisting saved <code>CompetencyTypeDTO</code> object
     */
    @RequestMapping(value = "/competencyType", method = RequestMethod.POST)
    public ResponseEntity<CompetencyTypeDTO> create(@RequestBody CompetencyTypeDTO competencyTypeDTO) {

        if(competencyTypeService.exists(competencyTypeDTO) == true) {
            return new ResponseEntity<CompetencyTypeDTO>(competencyTypeDTO,HttpStatus.CONFLICT);
        }

        competencyTypeService.save(competencyTypeDTO);
        return new ResponseEntity<CompetencyTypeDTO>(competencyTypeDTO, HttpStatus.CREATED);
    }

    /**
     * Rest method to update and existing <code>CompetencyTypeDTO</code> record
     *
     * @param id id of Competency Type Object
     * @param competencyTypeDTO
     * @return <code>RequestBody</code> consisting Json representation for an existing <code>CompetencyTypeDTO</code> record
     * @throws DataNotFoundException is thrown when <code>CompetencyTypeDTO</code> is not found
     */
    @RequestMapping(value = "/competencyType/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CompetencyTypeDTO> update(@PathVariable Long id,
                                                    @RequestBody CompetencyTypeDTO competencyTypeDTO) throws DataNotFoundException {

        CompetencyTypeDTO obj = competencyTypeService.findById(id);

        competencyTypeService.save(competencyTypeDTO);
        return new ResponseEntity<CompetencyTypeDTO>(competencyTypeDTO, HttpStatus.OK);
    }

}
