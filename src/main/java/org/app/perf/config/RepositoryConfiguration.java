package org.app.perf.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by gauravbehl on 11/5/17.
 */

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"org.app.perf.domain"})
@EnableJpaRepositories(basePackages = {"org.app.perf.repository"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
