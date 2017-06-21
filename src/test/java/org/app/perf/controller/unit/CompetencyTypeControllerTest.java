package org.app.perf.controller.unit;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.app.perf.AbstractWebTests;
import org.app.perf.controller.CompetencyTypeController;
import org.app.perf.dto.CompetencyTypeDTO;
import org.app.perf.exception.DataNotFoundException;
import org.app.perf.service.CompetencyTypeService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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

    private static MediaType APPLICATION_JSON = new MediaType(MediaType.APPLICATION_JSON.getType(),
    MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Test
    public void testGetComptencyTypeByIdShouldReturnRecord() throws Exception {

        CompetencyTypeDTO competencyType = createCompetencyTypeDTOWithId("MVC", 2L);

        when(competencyTypeServiceMock.findById(2L)).thenReturn(competencyType);

        mockMvc.perform(get("/competencyType/2")).andExpect(status().isOk()).
                andExpect(content().contentType(APPLICATION_JSON)).
                andExpect(jsonPath("$.id", is(2))).
                andExpect(jsonPath("$.title", is("MVC")));

        verify(competencyTypeServiceMock, times(1)).findById(2L);
        verifyNoMoreInteractions(competencyTypeServiceMock);
    }


    @Test
    public void testGetComptencyTypeByIdNotFound() throws Exception {

        when(competencyTypeServiceMock.findById(2000L)).thenThrow(DataNotFoundException.class);

        mockMvc.perform(get("/competencyType/2000")).andExpect(status().isNoContent());

        verify(competencyTypeServiceMock, times(1)).findById(2000L);
        verifyNoMoreInteractions(competencyTypeServiceMock);
    }


    @Test
    public void testGetCompetencyTypeBydTitleShouldReturnOneCompetency() throws Exception{

        CompetencyTypeDTO competencyTypeDTO = createCompetencyTypeDTOWithId("MVC", 2L);

        when(competencyTypeServiceMock.findByTitle("MVC")).thenReturn(competencyTypeDTO);

        mockMvc.perform(get("/competencyType/title/MVC")).andExpect(status().isOk()).andExpect(content().contentType(APPLICATION_JSON)).
                andExpect(jsonPath("$.id", is(2))).andExpect(jsonPath("$.title", is("MVC")));


        verify(competencyTypeServiceMock, times(1)).findByTitle("MVC");
        verifyNoMoreInteractions(competencyTypeServiceMock);

    }

    @Test
    public void testGetCompetencyTypeBydTitleShouldNotReturnAnyCompetency() throws Exception{

        when(competencyTypeServiceMock.findByTitle("JUNK")).thenThrow(DataNotFoundException.class);

        mockMvc.perform(get("/competencyType/title/JUNK")).andExpect(status().isNoContent());

        verify(competencyTypeServiceMock, times(1)).findByTitle("JUNK");
        verifyNoMoreInteractions(competencyTypeServiceMock);
    }

    @Test
    public void testGetAllShouldReturnAllCompetencies() throws Exception {

        CompetencyTypeDTO c1 = createCompetencyTypeDTOWithId("MVC", 1L);
        CompetencyTypeDTO c2 = createCompetencyTypeDTOWithId("Spring", 2L);

        List<CompetencyTypeDTO> list = new ArrayList<CompetencyTypeDTO>();
        list.add(c1);
        list.add(c2);

        when(competencyTypeServiceMock.findAll()).thenReturn(list);

        mockMvc.perform(get("/competencyTypes")).andExpect(status().isOk()).
                andExpect(content().contentType(APPLICATION_JSON)).
                andExpect(jsonPath("$", hasSize(2))).
                andExpect(jsonPath("$[0].id", is(1))).andExpect(jsonPath("$[0].title", is("MVC"))).
                andExpect(jsonPath("$[1].id", is(2))).andExpect(jsonPath("$[1].title", is("Spring")));

        verify(competencyTypeServiceMock, times(1)).findAll();
        verifyNoMoreInteractions(competencyTypeServiceMock);
    }


    @Test
    public void testSaveCompetencyType() throws Exception {

        CompetencyTypeDTO competencyTypeDTO = createCompetencyType("NewTitle");

        when(competencyTypeServiceMock.exists(competencyTypeDTO)).thenReturn(false);
        doNothing().when(competencyTypeServiceMock).save(competencyTypeDTO);

        mockMvc.perform(post("/competencyType/create").contentType(APPLICATION_JSON).
                content(new ObjectMapper().writeValueAsString(competencyTypeDTO))).
                andExpect(status().isCreated());

        verify(competencyTypeServiceMock,times(1)).exists(competencyTypeDTO);
        verify(competencyTypeServiceMock, times(1)).save(competencyTypeDTO);
        verifyNoMoreInteractions(competencyTypeServiceMock);
    }

    @Test
    public void testSaveDuplicateCompetencyShouldNotSave() throws Exception {

        CompetencyTypeDTO competencyTypeDTO = createCompetencyType("MVC");

        when(competencyTypeServiceMock.exists(competencyTypeDTO)).thenReturn(true);

        mockMvc.perform(post("/competencyType/create").contentType(APPLICATION_JSON).
                content(new ObjectMapper().writeValueAsString(competencyTypeDTO))).
                andExpect(status().isConflict());

        verify(competencyTypeServiceMock,times(1)).exists(competencyTypeDTO);
        verifyNoMoreInteractions(competencyTypeServiceMock);
    }


    @Test
    public void testUpdateCompetencyTypeShouldUpdate() throws Exception {

        CompetencyTypeDTO competencyTypeDTO = createCompetencyTypeDTOWithId("ExistingTitle", 1L);

        when(competencyTypeServiceMock.findById(competencyTypeDTO.getId())).thenReturn(competencyTypeDTO);
        doNothing().when(competencyTypeServiceMock).save(competencyTypeDTO);

        mockMvc.perform(put("/competencyType/update/1").contentType(APPLICATION_JSON).
                content(new ObjectMapper().writeValueAsString(competencyTypeDTO))).
                andExpect(status().isOk());


        verify(competencyTypeServiceMock,times(1)).findById(competencyTypeDTO.getId());
        verify(competencyTypeServiceMock,times(1)).save(competencyTypeDTO);
        verifyNoMoreInteractions(competencyTypeServiceMock);

    }

    private CompetencyTypeDTO createCompetencyTypeDTOWithId(String title, Long id) {
        CompetencyTypeDTO competencyTypeDTO = new CompetencyTypeDTO();
        competencyTypeDTO.setTitle(title);
        competencyTypeDTO.setId(id);
        return competencyTypeDTO;
    }

    private CompetencyTypeDTO createCompetencyType(String title) {
        CompetencyTypeDTO competencyTypeDTO = new CompetencyTypeDTO();
        competencyTypeDTO.setTitle(title);
        return competencyTypeDTO;
    }

}
