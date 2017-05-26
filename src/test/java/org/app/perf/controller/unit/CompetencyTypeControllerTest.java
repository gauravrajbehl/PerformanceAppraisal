package org.app.perf.controller.unit;

import org.app.perf.AbstractWebTests;
import org.app.perf.controller.CompetencyTypeController;
import org.app.perf.domain.CompetencyType;
import org.app.perf.exception.DataNotFoundException;
import org.app.perf.service.CompetencyTypeService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by gauravbehl on 24/5/17.
 */

@WebMvcTest(CompetencyTypeController.class)
public class CompetencyTypeControllerTest extends AbstractWebTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CompetencyTypeService competencyTypeServiceMock;

    @Test
    public void testGetComptencyTypeByIdShouldReturnRecord() throws Exception {

        CompetencyType competencyType = new CompetencyType();
        competencyType.setId(2L);
        competencyType.setTitle("MVC");

        when(competencyTypeServiceMock.findById(2L)).thenReturn(competencyType);

        mockMvc.perform(get("/competencyType/2")).andExpect(status().isOk()).
                andExpect(content().contentType(new MediaType(MediaType.APPLICATION_JSON.getType(),
                        MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8")))).
                andExpect(jsonPath("$.id", is(2))).
                andExpect(jsonPath("$.title", is("MVC")));


        verify(competencyTypeServiceMock, times(1)).findById(2L);
        verifyNoMoreInteractions(competencyTypeServiceMock);
    }


    @Test
    public void testGetComptencyTypeByIdNotFound() throws Exception {

        CompetencyType competencyType = new CompetencyType();
        competencyType.setId(1000L);
        competencyType.setTitle("MVC");

        when(competencyTypeServiceMock.findById(1000L)).thenThrow(DataNotFoundException.class);

        mockMvc.perform(get("/competencyType/1000")).andExpect(status().isNoContent());

        verify(competencyTypeServiceMock, times(1)).findById(1000L);
        verifyNoMoreInteractions(competencyTypeServiceMock);
    }


    @Test
    public void testGetAllShouldReturnAllCompetencies() throws Exception {

        CompetencyType c1 = new CompetencyType();
        c1.setId(1L);
        c1.setTitle("MVC");

        CompetencyType c2 = new CompetencyType();
        c2.setId(2L);
        c2.setTitle("Spring");

        List<CompetencyType> list = new ArrayList<CompetencyType>();
        list.add(c1);
        list.add(c2);

        when(competencyTypeServiceMock.findAll()).thenReturn(list);

        mockMvc.perform(get("/competencyType")).andExpect(status().isOk()).
                andExpect(content().contentType(new MediaType(MediaType.APPLICATION_JSON.getType(),
                        MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8")))).
                andExpect(jsonPath("$", hasSize(2))).
                andExpect(jsonPath("$[0].id", is(1))).andExpect(jsonPath("$[0].title", is("MVC"))).
                andExpect(jsonPath("$[1].id", is(2))).andExpect(jsonPath("$[1].title", is("Spring")));

        verify(competencyTypeServiceMock, times(1)).findAll();
        verifyNoMoreInteractions(competencyTypeServiceMock);
    }


}
