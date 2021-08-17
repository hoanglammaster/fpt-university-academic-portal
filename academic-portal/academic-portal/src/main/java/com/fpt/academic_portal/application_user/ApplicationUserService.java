package com.fpt.academic_portal.application_user;

import com.fpt.academic_portal.application_permission.ApplicationUserPermission;
import com.fpt.academic_portal.application_permission.ApplicationUserPermissionService;
import com.fpt.academic_portal.application_role.ApplicationUserRole;
import com.fpt.academic_portal.application_role.ApplicationUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ApplicationUserService {
    private  ApplicationUserRepository userRepository;
    private  ApplicationUserRoleService roleService;
    private  ApplicationUserPermissionService permissionService;

    @Autowired
    public ApplicationUserService(ApplicationUserRepository userRepository, ApplicationUserRoleService roleService, ApplicationUserPermissionService permissionService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.permissionService = permissionService;
    }

    public Optional<ApplicationUser> getApplicationUserByUsername(String username) {
        Optional<ApplicationUser> user =  userRepository.findApplicationUserByUsername(username);
        if(user.isPresent()){
            ApplicationUser applicationUser = user.get();
            applicationUser.setAuthorities(
                    getSimpleGrantedAuthorities(applicationUser.getRole())
            );
            return Optional.of(applicationUser);
        }else{
            return user;
        }

    }

    private Set<SimpleGrantedAuthority> getSimpleGrantedAuthorities(Set<Integer> listRoleIds) {

        Set<ApplicationUserRole> roles = roleService.getAllRoleByIds(listRoleIds);
        Set<ApplicationUserPermission> permissions = new HashSet<>();

        roles.forEach(
                role ->{
                    permissionService.getAllPermissionByRoleId(role.getPermission())
                            .stream()
                            .forEach(
                                    permission ->{
                                        permissions.add(permission);
                                    }
                            );
                }
        );

        Set<SimpleGrantedAuthority> simpleGrantedAuthorities =
                permissions
                        .stream()
                        .map(permission ->
                                new SimpleGrantedAuthority(permission.getPermission())
                        ).collect(Collectors.toSet());
        roles.stream().forEach( role->
                simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()))
        );
        return simpleGrantedAuthorities;
    }
}
