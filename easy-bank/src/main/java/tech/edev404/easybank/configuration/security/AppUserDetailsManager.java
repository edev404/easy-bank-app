package tech.edev404.easybank.configuration.security;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tech.edev404.easybank.model.entity.Customer;
import tech.edev404.easybank.service.CustomersService;

@Service
@RequiredArgsConstructor
public class AppUserDetailsManager implements UserDetailsManager {

    private final CustomersService customerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Customer> customerOptional = customerService.findByEmail(username);

        if (!customerOptional.isPresent()) {
            throw new UsernameNotFoundException("User details not found: " + username);
        }

        Customer customer = customerOptional.get();

        String password = customer.getPassword();
        boolean disabled = !(customer.getEnabled());
        boolean accountExpired = !(customer.getAccountNonExpired());
        boolean accountLocked = !(customer.getAccountNonLocked());
        boolean credentialsExpired = !(customer.getCredentialsNonExpired());
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(customer.getAuthority().toString());
        
        return User.builder()
                .username(username)
                .password(password)
                .disabled(disabled)
                .accountExpired(accountExpired)
                .accountLocked(accountLocked)
                .credentialsExpired(credentialsExpired)
                .authorities(List.of(simpleGrantedAuthority))
                .build();

    }

    @Override
    public void createUser(UserDetails user) {

    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return true;
    }

}