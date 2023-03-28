package tech.edev404.easybank.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfiguration {

    @Bean 
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.authorizeHttpRequests()
                .requestMatchers("api/v1/account**", "api/v1/balance**", "api/v1/loans**", "api/v1/cards**")
                .authenticated()
                .requestMatchers("api/v1/notices**", "api/v1/contact**", "api/v1/sign-up").permitAll()
                .and().formLogin()
                .and().httpBasic();
        return http.build();

    }

    // Only for development envirorment
    // @Bean
    // InMemoryUserDetailsManager inMemoryUserDetails() {
    //     InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
    //     UserDetails admin = User.withUsername("admin")
    //                             .password(passwordEncoder().encode("admin"))
    //                             .authorities("ADMINISTRATOR")
    //                         .build();
    //     inMemoryUserDetailsManager.createUser(admin);
    //     return inMemoryUserDetailsManager;
    // }

    // @Bean 
    // UserDetailsService userDetailsService(DataSource dataSource){
    //     return new JdbcUserDetailsManager(dataSource);
    // }

    @Bean 
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
