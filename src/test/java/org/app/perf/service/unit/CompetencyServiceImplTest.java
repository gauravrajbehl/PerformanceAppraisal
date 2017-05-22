package org.app.perf.service.unit;

import org.app.perf.domain.Competency;
import org.app.perf.repository.CompentencyRepository;
import org.app.perf.service.CompetencyServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

/**
 * Created by gauravbehl on 19/5/17.
 */
@RunWith(SpringRunner.class)
public class CompetencyServiceImplTest {

    @InjectMocks
    private CompetencyServiceImpl competencyServiceImpl;

    @Mock
    private CompentencyRepository compentencyRepositoryMock;


    @Test
    public void testFindCompentencyByTitle() {

        Competency competency = new Competency();
        competency.setTitle("C1");

        when(compentencyRepositoryMock.findByTitle("C1")).thenReturn(competency);

        Competency c = competencyServiceImpl.findByTitle("C1");

        Assert.assertEquals(c.getTitle(), competency.getTitle());
    }

   @Test
    public void testNoCompentencyByTitleFound() {

        when(compentencyRepositoryMock.findByTitle("C2")).thenReturn(null);

        Competency c = competencyServiceImpl.findByTitle("C2");

        Assert.assertNull(c);
    }


}
