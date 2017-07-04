package org.app.perf.controller.unit;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.app.perf.AbstractWebTests;
import org.app.perf.controller.CompetencyController;
import org.app.perf.dto.CompetencyDTO;
import org.app.perf.dto.CompetencyTypeDTO;
import org.app.perf.exception.DataNotFoundException;
import org.app.perf.service.CompetencyService;
import org.app.perf.util.TestDataGenerator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by gauravbehl on 4/7/17.
 */
@WebMvcTest(CompetencyController.class)
public class CompetencyControllerTest extends AbstractWebTests {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CompetencyService competencyServiceMock;


    private static MediaType APPLICATION_JSON = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Test
    public void test_find_by_id_should_return_competencyDTO_json() throws Exception {

        CompetencyDTO competencyDTO = TestDataGenerator.createNewCompetencyDTO(1L, "C01");
        CompetencyTypeDTO competencyTypeDTO = TestDataGenerator.createNewCompetencyTypeDTO(1L,"CT01");
        competencyDTO.setCompetencyType(competencyTypeDTO);

        when(competencyServiceMock.findById(anyLong())).thenReturn(competencyDTO);

        mockMvc.perform(get("/competency/1")).andExpect(status().isOk()).
                andExpect(content().contentType(APPLICATION_JSON)).
                andExpect(jsonPath("$.id", is(1))).
                andExpect(jsonPath("$.title", is("C01"))).
                andExpect(jsonPath("$.compentencyLevel").exists()).
                andExpect(jsonPath("$.competencyType['id']", is(1))).
                andExpect(jsonPath("$.competencyType['title']", is("CT01")));

        verify(competencyServiceMock,times(1)).findById(1L);
        verifyNoMoreInteractions(competencyServiceMock);
    }

    @Test
    public void test_find_by_invalid_id_should_return_NO_CONTENT() throws Exception {

        when(competencyServiceMock.findById(anyLong())).thenThrow(DataNotFoundException.class);

        mockMvc.perform(get("/competency/0")).andExpect(status().isNoContent());

        verify(competencyServiceMock,times(1)).findById(0L);
        verifyNoMoreInteractions(competencyServiceMock);
    }

    @Test
    public void test_find_all_should_return_competencies() throws Exception {

        CompetencyDTO c1 = TestDataGenerator.createNewCompetencyDTO(1L, "C01");
        CompetencyTypeDTO ct1 = TestDataGenerator.createNewCompetencyTypeDTO(1L,"CT01");
        c1.setCompetencyType(ct1);

        CompetencyDTO c2 = TestDataGenerator.createNewCompetencyDTO(2L, "C02");
        CompetencyTypeDTO ct2 = TestDataGenerator.createNewCompetencyTypeDTO(2L,"CT02");
        c1.setCompetencyType(ct2);

        List<CompetencyDTO> competencyDTOList = new ArrayList<CompetencyDTO>();
        competencyDTOList.add(c1);
        competencyDTOList.add(c2);

        when(competencyServiceMock.findAll()).thenReturn(competencyDTOList);

        mockMvc.perform(get("/competencies")).andExpect(status().isOk()).
                andExpect(content().contentType(APPLICATION_JSON)).
                andExpect(jsonPath("$", hasSize(2)));

        verify(competencyServiceMock, times(1)).findAll();
        verifyNoMoreInteractions(competencyServiceMock);

    }

    @Test
    public void test_find_all_should_return_NO_CONTENT() throws Exception {

        when(competencyServiceMock.findAll()).thenThrow(DataNotFoundException.class);

        mockMvc.perform(get("/competencies")).andExpect(status().isNoContent());

        verify(competencyServiceMock, times(1)).findAll();
        verifyNoMoreInteractions(competencyServiceMock);

    }


    @Test
    public void test_save_should_return_created_status() throws Exception {

        CompetencyDTO competencyDTO = TestDataGenerator.createNewCompetencyDTO();
        CompetencyTypeDTO competencyTypeDTO = TestDataGenerator.createNewCompetencyTypeDTO();
        competencyDTO.setCompetencyType(competencyTypeDTO);

        when(competencyServiceMock.exists(any())).thenReturn(false);
        doNothing().when(competencyServiceMock).save(competencyDTO);

        mockMvc.perform(post("/competency").contentType(APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(competencyDTO))).andExpect(status().isCreated());


        verify(competencyServiceMock,times(1)).exists(competencyDTO);
        verify(competencyServiceMock,times(1)).save(competencyDTO);
        verifyNoMoreInteractions(competencyServiceMock);

    }

}
