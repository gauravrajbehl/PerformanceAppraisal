package org.app.perf.service;

import org.app.perf.domain.Responsibility;

/**
 * Created by gauravbehl on 17/5/17.
 */
public interface ResponsibilityService {

    public Responsibility findResponsibilityByTitle(String title);

    public Iterable<Responsibility> findAllResponsibilities();

    public void saveResponsibility(Responsibility responsibility);

}
