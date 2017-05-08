package com.esens.admin.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import static com.esens.admin.config.Profiles.DEV;

@Configuration
@Profile(DEV)
public class ApplicationSecurityDevConfig extends WebSecurityConfigurerAdapter {

    Logger log = LoggerFactory.getLogger(ApplicationSecurityDevConfig.class);

    @Override
    public void configure(HttpSecurity http) throws Exception {
        log.warn("Configuring http security in DEV profile");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.warn("Configuring auth in DEV profile");
    }
}
