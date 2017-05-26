package org.app.perf.controller;

import lombok.Data;
import org.app.perf.domain.CompetencyType;
import org.app.perf.exception.DataNotFoundException;
import org.app.perf.service.CompetencyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public ResponseEntity<CompetencyType> getCompetencyTypeById(@PathVariable("id") Long id) throws DataNotFoundException {

        CompetencyType competencyType = competencyTypeService.findById(id);
        return new ResponseEntity<CompetencyType>(competencyType, HttpStatus.OK);
    }


    /**
     *
     * @return
     */
    @RequestMapping(value = "/competencyType", method = RequestMethod.GET)
    public ResponseEntity<List<CompetencyType>> getAllCompetencyTypes() {
        return new ResponseEntity<List<CompetencyType>>(competencyTypeService.findAll(),HttpStatus.OK );
    }

}
