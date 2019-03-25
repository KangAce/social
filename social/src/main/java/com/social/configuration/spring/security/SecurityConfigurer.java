/*
package com.social.configuration.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;


*/
/**
 * @author alvis
 *//*


@Configuration
@EnableWebSecurity
public class SecurityConfigurer {

    @Configuration
    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        private final LoginAuthenticationEntryPoint restAuthenticationEntryPoint;
        private final FormAuthenticationProvider formAuthenticationProvider;
        private final FormDetailsServiceImpl formDetailsService;
        private final FormAuthenticationSuccessHandler formAuthenticationSuccessHandler;
        private final FormAuthenticationFailureHandler formAuthenticationFailureHandler;
        private final FormLogoutSuccessHandler formLogoutSuccessHandler;
        private final String[] antPatterns = new String[]{"/error", "/favicon.ico", "/module/**", "/plugs/**", "/login", "/user/login", "/user/register", "/api/user/login"};

        @Autowired
        public FormLoginWebSecurityConfigurerAdapter(LoginAuthenticationEntryPoint restAuthenticationEntryPoint, FormAuthenticationProvider formAuthenticationProvider, FormDetailsServiceImpl formDetailsService, FormAuthenticationSuccessHandler formAuthenticationSuccessHandler, FormAuthenticationFailureHandler formAuthenticationFailureHandler, FormLogoutSuccessHandler formLogoutSuccessHandler) {
            this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
            this.formAuthenticationProvider = formAuthenticationProvider;
            this.formDetailsService = formDetailsService;
            this.formAuthenticationSuccessHandler = formAuthenticationSuccessHandler;
            this.formAuthenticationFailureHandler = formAuthenticationFailureHandler;
            this.formLogoutSuccessHandler = formLogoutSuccessHandler;
        }

        */
/**
         * @param http http
         * @throws Exception exception
         *                   csrf is the from submit get method
         *//*

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .addFilterAt(authenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                    .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint)
                    .and().authenticationProvider(formAuthenticationProvider)
                    .authorizeRequests()
                    .antMatchers(antPatterns).permitAll()
                    .anyRequest().hasRole("USER")
                    .and().formLogin().loginProcessingUrl("/user/login").successHandler(formAuthenticationSuccessHandler).failureHandler(formAuthenticationFailureHandler)
                    .and().logout().logoutUrl("/api/user/logout").logoutSuccessUrl("/user/login").logoutSuccessHandler(formLogoutSuccessHandler).invalidateHttpSession(true)
                    .and().rememberMe().key("demo").tokenValiditySeconds(30 * 24 * 60 * 60).userDetailsService(formDetailsService)
                    .and().csrf().disable()
                    .cors();
        }


        @Bean
        public CorsConfigurationSource corsConfigurationSource() {
            final CorsConfiguration configuration = new CorsConfiguration();
            configuration.setMaxAge(3600L);
            configuration.setAllowedOrigins(Collections.singletonList("*"));
            configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
            configuration.setAllowCredentials(true);
            configuration.setAllowedHeaders(Collections.singletonList("*"));
            final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/api/**", configuration);
            return source;
        }


        @Bean
        public RestLoginAuthenticationFilter authenticationFilter() throws Exception {
            RestLoginAuthenticationFilter authenticationFilter = new RestLoginAuthenticationFilter();
            authenticationFilter.setAuthenticationSuccessHandler(formAuthenticationSuccessHandler);
            authenticationFilter.setAuthenticationFailureHandler(formAuthenticationFailureHandler);
            authenticationFilter.setAuthenticationManager(authenticationManagerBean());
            authenticationFilter.setUserDetailsService(formDetailsService);
            return authenticationFilter;
        }


    }
}
*/
