package com.fpt.academic_portal.application_permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ApplicationUserPermissionService {

    private final ApplicationUserPermissionRepository permissionRepository;

    @Autowired
    public ApplicationUserPermissionService(ApplicationUserPermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    public Set<ApplicationUserPermission> getAllPermissionByRoleId(Set<Integer> listIds){
        return permissionRepository
                .findApplicationUserPermissionsByIdIsIn(listIds)
                ;
    }
}
