package org.app.perf.controller;

import lombok.Data;
import org.app.perf.dto.CompetencyDTO;
import org.app.perf.exception.DataNotFoundException;
import org.app.perf.service.CompetencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

/**
 * Created by gauravbehl on 4/7/17.
 */
@Data
@Controller
public class CompetencyController {

    @Autowired
    private CompetencyService competencyService;


    @RequestMapping(value = "/competency/{id}", method = RequestMethod.GET)
    public ResponseEntity<CompetencyDTO> getById(@PathVariable("id") Long id) throws DataNotFoundException {

        CompetencyDTO competencyDTO = competencyService.findById(id);
        return new ResponseEntity<CompetencyDTO>(competencyDTO, HttpStatus.OK);
    }


    @RequestMapping(value = "/competencies", method = RequestMethod.GET)
    public ResponseEntity<List<CompetencyDTO>> getAll() throws DataNotFoundException {
        List<CompetencyDTO> list = competencyService.findAll();
        return new ResponseEntity<List<CompetencyDTO>>(list , HttpStatus.OK);
    }


    @RequestMapping(value = "/competency", method = RequestMethod.POST)
    public ResponseEntity<CompetencyDTO> createNew(@RequestBody CompetencyDTO competencyDTO) {

        if (competencyService.exists(competencyDTO)) {
            return new ResponseEntity<CompetencyDTO>(competencyDTO, HttpStatus.CONFLICT);
        }

        competencyService.save(competencyDTO);

        return new ResponseEntity<CompetencyDTO>(competencyDTO, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/competency/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CompetencyDTO> update(@PathVariable Long id, @RequestBody CompetencyDTO competencyDTO) throws DataNotFoundException{

        CompetencyDTO comp = competencyService.findById(id);

        competencyService.save(competencyDTO);

        return new ResponseEntity<CompetencyDTO>(competencyDTO, HttpStatus.OK);
    }


}
