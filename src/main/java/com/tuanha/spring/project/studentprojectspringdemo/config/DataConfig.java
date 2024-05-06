package com.tuanha.spring.project.studentprojectspringdemo.config;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class DataConfig {
    private final Logger logger = LoggerFactory.getLogger(DataConfig.class);

    @Value("${spring.profiles.active}")
    private String active;
    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.username}")
    private String dataSourceUsername;

    @Value("${spring.datasource.password}")
    private String dataSourcePassword;

    @Value("${spring.datasource.driver-class-name}")
    private String dataSourceDriverClassName;

//    @Autowired
//    Environment environment;

    /**
     * If used environment then error
     * -- Relying upon circular references is discouraged and they are prohibited by default.
     * Update your application to remove the dependency cycle between beans.
     * As a last resort, it may be possible to break the cycle automatically by
     * setting.main.allow-circular-references to true. --
     * Reason: In DataConfig using @Autowired Environment
     * However getJPAProperties() using environment get config
     * After printDataSourceConfiguration waiting and call it
     * So, when Spring creates the DataConfig bean
     * it will have to wait for the Environment to be created first but at the same time
     * when creating the Environment
     * it needs the DataConfig to create other beans.
     * ┌──->──┐
     * |  dataConfig
     * └──<-──┘
     */
    public Properties getJPAProperties() {
        Properties properties = new Properties();
        properties.setProperty("active", active);
        properties.setProperty("url", dataSourceUrl);
        properties.setProperty("username", dataSourceUsername);
        properties.setProperty("password", dataSourcePassword);
        properties.setProperty("driver-class-name", dataSourceDriverClassName);
        return properties;
    }

    @PostConstruct
    public void printDataSourceConfiguration() {
        Properties dataSourceProperties = this.getJPAProperties();
        logger.info("DataSource Configuration:");
        logger.info("LOCAL ACTIVE: {}", dataSourceProperties.getProperty("active"));
        logger.info("URL: {}", dataSourceProperties.getProperty("url"));
        logger.info("USERNAME: {}", dataSourceProperties.getProperty("username"));
        logger.info("PASSWORD: {}", dataSourceProperties.getProperty("password"));
        logger.info("DRIVER CLASS NAME: {}", dataSourceProperties.getProperty("driver-class-name"));
    }
}
