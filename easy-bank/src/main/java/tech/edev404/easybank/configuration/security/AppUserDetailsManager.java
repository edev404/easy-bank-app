package tech.edev404.easybank.configuration.security;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
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
        Boolean accountNonLocked, credentialsNonExpired, accountNonExpired, enabled;
        enabled = customer.getEnabled();
        accountNonExpired = customer.getAccountNonExpired();
        credentialsNonExpired = customer.getCredentialsNonExpired();
        accountNonLocked = customer.getAccountNonLocked();
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(customer.getAuthority().toString()));
        
        return new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    @Override
    public void createUser(UserDetails user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createUser'");
    }

    @Override
    public void updateUser(UserDetails user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public void deleteUser(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changePassword'");
    }

    @Override
    public boolean userExists(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'userExists'");
    }
    
}