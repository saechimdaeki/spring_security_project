package me.saechimdaeki.security.security.config;

import me.saechimdaeki.security.security.common.AjaxLoginAuthenticationEntryPoint;
import me.saechimdaeki.security.security.filter.AjaxLoginProcessingFilter;
import me.saechimdaeki.security.security.handlers.AjaxAccessDeniedHandler;
import me.saechimdaeki.security.security.handlers.AjaxAuthenticationFailureHandler;
import me.saechimdaeki.security.security.handlers.AjaxAuthenticationSuccessHandler;
import me.saechimdaeki.security.security.provider.AjaxAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@Order(0)
public class AjaxSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(ajaxAuthenticationProvider());
    }

    @Bean
    public AuthenticationProvider ajaxAuthenticationProvider() {
        return new AjaxAuthenticationProvider();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler(){
        return new AjaxAuthenticationSuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler(){
        return new AjaxAuthenticationFailureHandler();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/api/**")
            .authorizeRequests()
            .antMatchers("/api/login").permitAll()
            .antMatchers("/api/messages").hasRole("MANAGER")
            .anyRequest().authenticated()
            .and()
            .addFilterBefore(ajaxLoginProcessingFilter(), UsernamePasswordAuthenticationFilter.class)
        ;
        http.exceptionHandling()
            .authenticationEntryPoint(new AjaxLoginAuthenticationEntryPoint())
            .accessDeniedHandler(ajaxAccessDeniedHandler());

        http.csrf().disable();
    }

    @Bean
    public AccessDeniedHandler ajaxAccessDeniedHandler() {

        return new AjaxAccessDeniedHandler();
    }

    @Bean
    public AjaxLoginProcessingFilter ajaxLoginProcessingFilter() throws Exception {
        AjaxLoginProcessingFilter ajaxLoginProcessingFilter = new AjaxLoginProcessingFilter();
        ajaxLoginProcessingFilter.setAuthenticationManager(authenticationManagerBean());
        ajaxLoginProcessingFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler());
        ajaxLoginProcessingFilter.setAuthenticationFailureHandler(authenticationFailureHandler());
        return ajaxLoginProcessingFilter;
    }
}
