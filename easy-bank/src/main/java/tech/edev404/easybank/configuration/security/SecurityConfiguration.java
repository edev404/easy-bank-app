package tech.edev404.easybank.configuration.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;
import tech.edev404.easybank.configuration.security.filter.CsrfCookieFilter;

@Configuration
public class SecurityConfiguration {

    @Value("#{'${client.app.allowedOrigins}'.split(',')}")
    List<String> allowedOriginsProperty;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        CsrfTokenRequestAttributeHandler csrfRequestHandler = new CsrfTokenRequestAttributeHandler();
        csrfRequestHandler.setCsrfRequestAttributeName("_csrf");

        http.securityContext().requireExplicitSave(false)
                .and().sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))

                .cors().configurationSource(new CorsConfigurationSource() {

                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration corsConfiguration = new CorsConfiguration();
                        corsConfiguration.setAllowedOrigins(allowedOriginsProperty);
                        corsConfiguration.setAllowedMethods(List.of("*"));
                        corsConfiguration.setAllowedHeaders(List.of("*"));
                        corsConfiguration.setAllowCredentials(true);
                        corsConfiguration.setMaxAge(3600L);

                        return corsConfiguration;

                    }

                }).and()
                .csrf((csrf) -> csrf.csrfTokenRequestHandler(csrfRequestHandler)
                        .ignoringRequestMatchers("api/v1/contact**", "api/v1/sign-up**") // Public endpoints
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests()
                .requestMatchers("api/v1/account**", "api/v1/balance**", "api/v1/loans**", "api/v1/cards**",
                        "api/v1/user**")
                .authenticated()
                .requestMatchers("api/v1/notices**", "api/v1/contact**", "api/v1/sign-up**").permitAll()
                .and().formLogin()
                .and().httpBasic();
        return http.build();

    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    /*
     * Only for development envirorment
     * 
     * @Bean
     * InMemoryUserDetailsManager inMemoryUserDetails() {
     * InMemoryUserDetailsManager inMemoryUserDetailsManager = new
     * InMemoryUserDetailsManager();
     * UserDetails admin = User.withUsername("admin")
     * .password(passwordEncoder().encode("admin"))
     * .authorities("ADMINISTRATOR")
     * .build();
     * inMemoryUserDetailsManager.createUser(admin);
     * return inMemoryUserDetailsManager;
     * }
     * 
     * @Bean
     * UserDetailsService userDetailsService(DataSource dataSource){
     * return new JdbcUserDetailsManager(dataSource);
     * }
     */

}
