package com.fpt.academic_portal.application_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    private final ApplicationUserService userService;

    @Autowired
    public ApplicationUserDetailsService(ApplicationUserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ApplicationUser> user = userService.getApplicationUserByUsername(username);
        if(user.isPresent()){
            return new ApplicationUserDetails(user.get());
        }else{
            throw new UsernameNotFoundException(String.format("User name %s is not found",username));
        }
    }
}
