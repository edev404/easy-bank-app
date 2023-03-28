package tech.edev404.easybank.configuration.security;

import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AppUsernamePwdAuthenticationProvider implements AuthenticationProvider {

    private final AppUserDetailsManager userDetailsManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        try {
            UserDetails user = userDetailsManager.loadUserByUsername(username);
            if (passwordEncoder.matches(password, user.getPassword())) {
                List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(user.getAuthorities().stream().findFirst().get().toString()));
                return new UsernamePasswordAuthenticationToken(username, password, authorities);
            } else {
                throw new BadCredentialsException("Bad credentials");
            }
        } catch (UsernameNotFoundException ex) {
            throw new BadCredentialsException("No user registered with this details");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
    
}
