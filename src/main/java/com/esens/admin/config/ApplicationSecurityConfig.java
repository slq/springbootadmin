package com.esens.admin.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import static com.esens.admin.config.Profiles.PROD;

@Configuration
@Profile(PROD)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().fullyAuthenticated()
                .and()
                .formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
                .and()
                .logout().permitAll();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(this.dataSource)
                .usersByUsernameQuery("SELECT login, haslo, true FROM auth.tab_uzytkownik where login = ?")
                .authoritiesByUsernameQuery("SELECT U.login, G.nazwa FROM auth.tab_grupauzytkownika G INNER JOIN auth.rel_grupa_uzytkownik GU ON G.id_grupa_uzytkownika = GU.id_grupy INNER JOIN auth.tab_uzytkownik U ON GU.id_uzytkownik = U.id_uzytkownik WHERE U.login = ?;");
    }
}
