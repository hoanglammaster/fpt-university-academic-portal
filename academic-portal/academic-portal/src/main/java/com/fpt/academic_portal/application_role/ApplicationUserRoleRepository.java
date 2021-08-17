package com.fpt.academic_portal.application_role;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;
import java.util.Set;

@Repository
public interface ApplicationUserRoleRepository extends MongoRepository<ApplicationUserRole, Integer> {

    Optional<ApplicationUserRole> findApplicationRoleById(Integer id);

    Set<ApplicationUserRole> findApplicationUserRolesByIdIsIn(Set<Integer> ids);
}