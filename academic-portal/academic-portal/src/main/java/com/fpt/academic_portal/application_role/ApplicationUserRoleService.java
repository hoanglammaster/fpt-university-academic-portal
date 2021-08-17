package com.fpt.academic_portal.application_role;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class ApplicationUserRoleService {

    private final ApplicationUserRoleRepository roleRepository;

    @Autowired
    public ApplicationUserRoleService(ApplicationUserRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Optional<ApplicationUserRole> getRoleById() {
        return roleRepository.findApplicationRoleById(10);
    }

    public Set<ApplicationUserRole> getAllRoleByIds(Set<Integer> ids){
        return roleRepository.findApplicationUserRolesByIdIsIn(ids);
    }
}
