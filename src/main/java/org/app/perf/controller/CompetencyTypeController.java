package org.app.perf.controller;

import lombok.Data;
import org.app.perf.domain.CompetencyType;
import org.app.perf.service.CompetencyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/competencyType/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CompetencyType getCompetencyTypeById(@PathVariable("id") Long id) {
        return competencyTypeService.findById(id);
    }


    @RequestMapping(value = "/competencyType", method = RequestMethod.GET)
    @ResponseBody
    public List<CompetencyType> getAllCompetencyTypes() {
        return competencyTypeService.findAll();
    }

}
