package com.samanecorp.orienta.security;

import com.samanecorp.orienta.security.jwt.JWTAuthenticationFilter;
import com.samanecorp.orienta.security.jwt.JWTAuthorizationFilter;
import com.samanecorp.orienta.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
        .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
//                .formLogin()
//                .and()
                .authorizeRequests()
                .antMatchers("/login/**", "/register/**").permitAll()
                .antMatchers( "/users/**","/roles/**").hasAnyAuthority("ETUDIANT","UNIVERSITE","ADMIN","SUPER_ADMIN")
//                .antMatchers(HttpMethod.GET, "/api/orienta/agents/**").hasAnyAuthority("ADMIN","SUPER_ADMIN")
                .antMatchers(HttpMethod.GET, "/api/orienta/etudiants/Email/{email}","/api/orienta/demandes/**","/api/orienta/fichiersDossiers/**").hasAnyAuthority("ETUDIANT","ADMIN")
                .antMatchers(HttpMethod.GET,"/api/orienta/universites/Email/{email}").hasAnyAuthority("UNIVERSITE","ADMIN")
                .antMatchers( "/api/orienta/agents/**").hasAuthority("SUPER_ADMIN")
                .antMatchers( "/api/orienta/etudiants/**",
                        "/api/orienta/parcours/**","/api/orienta/typePieces/**").hasAuthority("ETUDIANT")
                .antMatchers("/api/orienta/dossierEtudiants/**","/api/orienta/domaineFormations/**","/api/orienta/formations/**","/api/orienta/entretiens/**"
                        ,"/api/orienta/etatDossier/**","/api/orienta/fichiersDossiers/**","/api/orienta/messages/**"
                        ,"/api/orienta/paiements/**","/api/orienta/demandes/**","/api/orienta/universites/**","/api/orienta/etudiants/**","/users/**").hasAuthority("ADMIN")
                .antMatchers("/api/orienta/demandes/**","/api/orienta/formations/**","/api/orienta/domaineFormations/**","/api/orienta/dossierEtudiants/**").hasAnyAuthority("UNIVERSITE","ADMIN")
                .anyRequest().authenticated()
                .and()
                .logout().invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/logout-success").permitAll()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/api/orienta/formations/**");
        web.ignoring().antMatchers(HttpMethod.GET,"/api/orienta/universites/**");
        web.ignoring().antMatchers("/api/orienta/domaineFormations/**");
        web.ignoring().antMatchers("/api/orienta/demandes/**");
        web.ignoring().antMatchers(HttpMethod.GET,"/api/orienta/TopUniversites/**");
        web.ignoring().antMatchers("/api/orienta/formations/**");
        web.ignoring().antMatchers("/api/orienta/etudiants/**");
        web.ignoring().antMatchers(HttpMethod.GET,"/api/orienta/agents/**");
        web.ignoring().antMatchers("/api/orienta/dossierEtudiants/**");
        web.ignoring().antMatchers("/api/orienta/typePieces/**");
        web.ignoring().antMatchers("/api/orienta/pays/**");
        web.ignoring().antMatchers("/api/orienta/parcours/**");
        web.ignoring().antMatchers("/api/orienta/typeFormations/**");
        web.ignoring().antMatchers("/api/orienta/niveaux/**");
    }
}
